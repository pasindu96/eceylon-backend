package lk.ac.eceylon.dto;

import java.sql.Timestamp;

public class UserOrdersDTO {
    private int orderID;
    private int quantity;
    private double amount;
    private Timestamp date;

    private int productID;
    private String displayName;

    private String email;
    private String name;
    private String address;
    private String mobile;

    public UserOrdersDTO(int orderID, int quantity, double amount, int productID, String displayName, String email, String name, String address, String mobile) {
        this.orderID = orderID;
        this.quantity = quantity;
        this.amount = amount;
        this.productID = productID;
        this.displayName = displayName;
        this.email = email;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public UserOrdersDTO() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserOrdersDTO{" +
                "orderID=" + orderID +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", date=" + date +
                ", productID=" + productID +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
