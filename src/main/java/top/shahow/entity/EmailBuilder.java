package top.shahow.entity;

import top.shahow.entity.dto.EmailDTO;
import top.shahow.entity.dto.ReceiverGroupDTO;
import top.shahow.entity.dto.SendMsgDTO;
import top.shahow.entity.dto.UserDTO;

import java.util.*;

/**
 * @author kezh
 * @date 2022-05-15
 */
public class EmailBuilder {
    private EmailDTO email;

    public EmailBuilder() {
        this.email = new EmailDTO();
        this.email.setSendMsg(new SendMsgDTO());
        this.email.setReceiverGroup(new ReceiverGroupDTO());
        this.email.getReceiverGroup().setTo(new ArrayList<>());
        this.email.getReceiverGroup().setCc(new ArrayList<>());
        this.email.getReceiverGroup().setBcc(new ArrayList<>());
    }

    public EmailBuilder setSender(String name) {
        this.email.getSendMsg().setSender(name);
        return this;
    }

    public EmailBuilder setContent(String title, String content) {
        this.email.getSendMsg().setTitle(title);
        this.email.getSendMsg().setContent(content);
        return this;
    }

    public EmailBuilder addTo(UserDTO user) {
        if (Objects.isNull(user)) {
            return this;
        }
        this.email.getReceiverGroup().getTo().add(user);
        return this;
    }

    public EmailBuilder addCc(UserDTO user) {
        if (Objects.isNull(user)) {
            return this;
        }
        this.email.getReceiverGroup().getCc().add(user);
        return this;
    }

    public EmailBuilder addBcc(UserDTO user) {
        if (Objects.isNull(user)) {
            return this;
        }
        this.email.getReceiverGroup().getBcc().add(user);
        return this;
    }

    public EmailDTO build() {
        return this.email;
    }
}
