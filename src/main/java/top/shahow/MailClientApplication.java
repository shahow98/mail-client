package top.shahow;

import top.shahow.builder.MessageBuilder;
import top.shahow.client.MailClient;

public class MailClientApplication {
    public static void main(String[] args) {
        MailClient client = new MailClient("www.shahow.top", "1332892354@qq.com", "123456");
        client.send(new MessageBuilder()
                .addMessage("生日快乐", "柯泽鸿，生日快乐", "韩氏集团")
                .addReceiver("1332892354@qq.com"));

    }
}
