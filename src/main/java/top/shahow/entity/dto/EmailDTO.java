package top.shahow.entity.dto;


/**
 * @author kezh
 * @date 2022-05-15
 */
public class EmailDTO {
    private SendMsgDTO sendMsg;

    private ReceiverGroupDTO receiverGroup;

    public SendMsgDTO getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(SendMsgDTO sendMsg) {
        this.sendMsg = sendMsg;
    }

    public ReceiverGroupDTO getReceiverGroup() {
        return receiverGroup;
    }

    public void setReceiverGroup(ReceiverGroupDTO receiverGroup) {
        this.receiverGroup = receiverGroup;
    }
}
