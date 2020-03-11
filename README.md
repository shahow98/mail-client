# mail-client
 邮件服务客户端

###### 1 Add this to pom.xml(need my github token or download .jar Orz):  
```
<dependency>
  <groupId>top.shahow</groupId>
  <artifactId>mail-client</artifactId>
  <version>1.0.1.release</version>
</dependency>
```
###### 2 register:  
http://www.shahow.top:7890/api/user/register?email=YOUR_EMAIL&password=YOUR_PASSWORD
###### 3 example:  
```
MailClient client = new MailClient("www.shahow.top", "YOUR_EMAIL", "YOUR_PASSWORD");
client.send(new MessageBuilder()
      .addMessage("TIELE", "SUBJECT", "CONTENT")
      .addReceiver("TO_EMAIL"));
```
