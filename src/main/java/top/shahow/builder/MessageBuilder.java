package top.shahow.builder;

import com.sun.istack.internal.NotNull;
import top.shahow.entity.Message;
import top.shahow.entity.Receiver;

public class MessageBuilder {
    private Message message;
    private Receiver receiver;

    public MessageBuilder(){
        message = new Message();
        receiver = new Receiver();
    }

    /**
     * 构造邮件消息体
     * @param title
     * @param content
     * @param addresser
     * @return
     */
    public MessageBuilder addMessage(@NotNull String title, @NotNull String content, String addresser){
        message.setTitle(title);
        message.setContent(content);
        if(addresser == null)
            addresser = "";
        message.setAddresser(addresser);
        return this;
    }

    /**
     * 构造邮件消息体
     * @param title
     * @param content
     * @return
     */
    public MessageBuilder addMessage(@NotNull String title, @NotNull String content){
        message.setTitle(title);
        message.setContent(content);
        return this;
    }



    /**
     * 构造发送、抄送、密送对象邮箱地址
     * @param to
     * @param cc
     * @param bcc
     * @return
     */
    public MessageBuilder addReceiver(@NotNull String[] to , String[] cc, String[] bcc){
        receiver.setTo(to);
        receiver.setCc(cc);
        receiver.setBcc(bcc);
        return this;
    }

    /**
     * 构造发送、抄送对象邮箱地址
     * @param to
     * @param cc
     * @return
     */
    public MessageBuilder addReceiver(@NotNull String[] to , String[] cc){
        receiver.setTo(to);
        receiver.setCc(cc);
        return this;
    }

    /**
     * 构造发送、密送对象邮箱地址
     * @param to
     * @param bcc
     * @param isBcc
     * @return
     */
    public MessageBuilder addReceiver(@NotNull String[] to , String[] bcc, boolean isBcc){
        receiver.setTo(to);
        receiver.setBcc(bcc);
        return this;
    }


    /**
     * 构造发送对象邮箱地址
     * @param to
     * @return
     */
    public MessageBuilder addReceiver(@NotNull String[] to){
        receiver.setTo(to);
        return this;
    }

    /**
     * 构造发送对象邮箱地址
     * @param to
     * @return
     */
    public MessageBuilder addReceiver(@NotNull String to){
        receiver.setTo(new String[]{to});
        return this;
    }

    public Message getMessage() {
        return message;
    }

    public Receiver getReceiver(){
        return  receiver;
    }
}
