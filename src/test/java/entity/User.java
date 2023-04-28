package entity;
import lombok.Data;

@Data
public class User {
    private String userName;
    private String password;

    private  String email;
    private  String currentAddress;
    private  String permanentAddress;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String email, String currentAddress, String permanentAddress) {
        this.userName = userName;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }
}
