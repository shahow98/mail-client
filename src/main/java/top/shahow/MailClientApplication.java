package top.shahow;

import top.shahow.builder.MessageBuilder;
import top.shahow.client.MailClient;

public class MailClientApplication {
    public static void main(String[] args) {
        MailClient client = new MailClient("www.shahow.top", "1332892354@qq.com", "123456");
        client.send(new MessageBuilder()
                .addMessage("生日快乐", contentTemplate("标题", "验证码", "46546"), "韩氏集团")
                .addReceiver("1332892354@qq.com"));

    }

    public static String contentTemplate(String title, String optionName, String body) {
        StringBuffer content = new StringBuffer();
        content.append("<h2 style=\"text-align: center;\">");
        content.append(title);
        content.append("</h2>");
        content.append("<div style=\"border: 1px solid black;width: 600px;height: 200px;margin: auto;\">");
        content.append("<div style=\"background-color: #009CDA;width: 100%;height: 40px;\">");
        content.append("<h3 style=\"margin: 0;color: white;text-align: center;line-height:40px;\">");
        content.append(optionName);
        content.append("</h3>");
        content.append("</div>");
        content.append("<div style=\"width: 100%;height: 160px;\">");
        content.append("<p  style=\"margin: 0;text-align: center;line-height:160px\">");
        content.append(body);
        content.append("</p>");
        content.append("</div>");
        content.append("</div>");
        return content.toString();
    }
}
