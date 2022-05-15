package top.shahow.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import top.shahow.entity.EmailBuilder;
import top.shahow.entity.dto.EmailDTO;
import top.shahow.entity.dto.ValidationDTO;
import top.shahow.exception.MailClientException;

import java.net.URI;

public class MailClient {
    private final static String SCHEME = "https";
    private final static String HOST = "www.shahow.top";
    private final static int PORT = 80;
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private String userName;
    private String password;

    private Boolean validated;

    public MailClient(String username, String password) throws MailClientException {
        this.userName = username;
        this.password = password;
        this.validated = false;
        initClient();
    }

    private void initClient() throws MailClientException {
        drawStartFlag();

        try {
            URI requestUri = new URIBuilder().setScheme(SCHEME).setHost(HOST).setPort(PORT)
                    .setPath(ApiMapping.VALIDATION).build();
            HttpPost post = new HttpPost(requestUri);

            ValidationDTO body = new ValidationDTO(userName, password);
            StringEntity entity = new StringEntity(jsonMapper.writeValueAsString(body), ContentType.APPLICATION_JSON);
            post.setEntity(entity);

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse httpResponse = httpClient.execute(post)) {
                if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    this.validated = true;
                } else {
                    throw new MailClientException(EntityUtils.toString(httpResponse.getEntity()));
                }
            }
        } catch (Exception e) {
            throw new MailClientException(e.getMessage());
        }
    }


    public void send(EmailDTO email) throws MailClientException {
        if (!this.validated) {
            throw new MailClientException("The password is wrong!");
        }
        try {
            URI requestUri = new URIBuilder().setScheme(SCHEME).setHost(HOST).setPort(PORT)
                    .setPath(ApiMapping.SENDER).build();

            HttpPost post = new HttpPost(requestUri);

            StringEntity body = new StringEntity(jsonMapper.writeValueAsString(email), ContentType.APPLICATION_JSON);
            post.setEntity(body);

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse httpResponse = httpClient.execute(post)) {
                if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    throw new MailClientException(EntityUtils.toString(httpResponse.getEntity()));
                }
            }
        } catch (Exception e) {
            throw new MailClientException(e.getMessage());
        }
    }

    private class ApiMapping {
        public static final String BASE_URL = "/api/mail-delivery/";

        public static final String VALIDATION = BASE_URL + "user/validation";
        public static final String SENDER = BASE_URL + "delivery/deliver";
    }

    private void drawStartFlag() {
        System.out.println("============================================");
        System.out.println("\n" +
                "            .-\"''-.  _\n" +
                "          .'       `( \\\n" +
                "        @/            ')   ,--,__,-\"\n" +
                "        /        /      \\ /     /   _/\n" +
                "      __|           ,   |/         /\n" +
                "    .~  `\\   / \\ ,  |   /\n" +
                "  .~      `\\    `  /  _/   _/\n" +
                ".~          `\\  ~~`__/    /\n" +
                "~             `--'/\n" +
                "             /   /    /    \n" +
                "            /  /'    /");
        System.out.println("============================================");
        System.out.println("::  shahow mail client  ::                 (v1.0.0.RELEASE)");
    }
}
