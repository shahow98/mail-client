package top.shahow.entity.dto;


import java.util.List;

/**
 * @author kezh
 * @date 2022-05-15
 */
public class ReceiverGroupDTO {

    private List<UserDTO> to;

    private List<UserDTO> cc;


    private List<UserDTO> bcc;

    public List<UserDTO> getTo() {
        return to;
    }

    public void setTo(List<UserDTO> to) {
        this.to = to;
    }

    public List<UserDTO> getCc() {
        return cc;
    }

    public void setCc(List<UserDTO> cc) {
        this.cc = cc;
    }

    public List<UserDTO> getBcc() {
        return bcc;
    }

    public void setBcc(List<UserDTO> bcc) {
        this.bcc = bcc;
    }
}
