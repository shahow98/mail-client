package top.shahow.entity.dto;

/**
 * @author kezh
 * @date 2022-05-15
 */

public class SendMsgDTO {
    private String title;

    private String content;

    private String sender;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
