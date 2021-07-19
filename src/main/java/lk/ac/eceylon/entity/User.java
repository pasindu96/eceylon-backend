package lk.ac.eceylon.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String email;

    private String username;

    private String fullname;

    private String mobile;

    private String address;

    private String password;

    private String user_type;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return user_type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.user_type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", type=" + user_type +
                '}';
    }
}
