# mail-client

邮件服务客户端

1. Add this to pom.xml(need my github token or download .jar Orz):

   ``` xml
    <dependency>
      <groupId>top.shahow</groupId>
      <artifactId>mail-client</artifactId>
      <version>1.0.1.release</version>
    </dependency>
    ```

2. Example:

    ``` java
    MailClient client = new MailClient("www.shahow.top", "YOUR_EMAIL", "YOUR_PASSWORD");
    client.send(new MessageBuilder()
          .addMessage("TIELE", "SUBJECT", "CONTENT")
          .addReceiver("TO_EMAIL"));
    ```

3. register

   POST [http://www.shahow.top/api/mail-delivery/user/register](http://www.shahow.top/api/mail-delivery/user/register)
   
   Body: {"userName": "name", "email": "email@domain"}