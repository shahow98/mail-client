package top.shahow.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jndi.toolkit.url.Uri;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import top.shahow.builder.MessageBuilder;
import top.shahow.entity.Message;
import top.shahow.entity.Receiver;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

public class MailClient {
    private String addrUri;
    private String userName;
    private String password;
    private static final int HOST = 7890;

    public MailClient(String addrUri, String username, String password) {
        this.addrUri = addrUri;
        this.userName = username;
        this.password = password;
        drawStartFlag();
        initClient();
    }

    private boolean initClient() {
        boolean flag = false;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> account = new ArrayList<>();
        account.add(new BasicNameValuePair("userName", userName));
        account.add(new BasicNameValuePair("password", password));
        URI requestUri = null;
        try {
            requestUri = new URIBuilder().setScheme("http").setHost(addrUri).setPort(HOST).setPath(ApiMapping.TEST)
                    .setParameters(account).build();
        } catch (URISyntaxException e) {
            System.err.println("URI building fail!");
        }
        HttpGet get = new HttpGet(requestUri);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(get);
            String res = EntityUtils.toString(httpResponse.getEntity());
            if ("true".equals(res)) {
                flag = true;
                System.out.println("This is ok!^_^");
            } else {
                System.err.println("Account or password may be wrong, please try again!Orz");
            }
            httpResponse.close();
        } catch (IOException e) {
            System.err.println("Connention time out: " + addrUri);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }


    public boolean send(MessageBuilder builder) {
        boolean flag = false;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> account = new ArrayList<>();
        account.add(new BasicNameValuePair("userName", userName));
        account.add(new BasicNameValuePair("password", password));
        URI requestUri = null;
        try {
            requestUri = new URIBuilder().setScheme("http").setHost(addrUri).setPort(HOST).setPath(ApiMapping.SENDER)
                    .setParameters(account).build();
        } catch (URISyntaxException e) {
            System.err.println("URI building fail!");
        }
        StringEntity body = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            body = new StringEntity(mapper.writeValueAsString(builder), ContentType.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            System.err.println("Object transform String is fail!");
        }
        HttpPost post = new HttpPost(requestUri);
        post.setEntity(body);
        post.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(post);
            String res = EntityUtils.toString(httpResponse.getEntity());
            if ("true".equals(res)) {
                flag = true;
                System.out.println("Send successfully !^_^");
            } else {
                System.err.println("Fail to send !Orz");
            }
            httpResponse.close();
        } catch (IOException e) {
            System.err.println("Connention time out: " + addrUri);
        } finally {
            try {

                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    private class ApiMapping {
        public static final String TEST = "/api/test/connection";
        public static final String SENDER = "/api/mail/sender";
    }

    private void drawStartFlag(){
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
