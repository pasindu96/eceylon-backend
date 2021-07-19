package lk.ac.eceylon.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartID;

    @ManyToOne(optional = false)
    @JoinColumn(name="email")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name="productID")
    private Product product;

    @CreationTimestamp
    private Timestamp productDate;

    private int quantity;
    private double price;
    private String status;

    public ShoppingCart() {
    }

    public ShoppingCart(User user, Product product, Timestamp productDate, int quantity, double price,String status) {
        this.user = user;
        this.product = product;
        this.productDate = productDate;
        this.quantity = quantity;
        this.status=status;
        this.price = price;
    }

    public ShoppingCart(User user) {
        this.user = user;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Timestamp getProductDate() {
        return productDate;
    }

    public void setProductDate(Timestamp productDate) {
        this.productDate = productDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartID=" + cartID +
                ", user=" + user +
                ", product=" + product +
                ", productDate=" + productDate +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
