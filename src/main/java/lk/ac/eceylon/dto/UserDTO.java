package lk.ac.eceylon.dto;

public class UserDTO {
    private String email;
    private String username;
    private String fullname;
    private String mobile;
    private String address;
    private String password;
    private String type;

    public UserDTO() {
    }

    public UserDTO(String email,String address,  String fullname, String mobile, String password, String type,String username) {
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
        this.type = type;
    }

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
        return type;
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
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
