package top.shahow.entity.dto;

/**
 * @author kezh
 * @date 2022-05-15
 */
public class UserDTO {
    private String email;

    private String userName;

    public UserDTO(String email, String userName) {
        this.email = email;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
