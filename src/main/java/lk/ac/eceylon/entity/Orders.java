package lk.ac.eceylon.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int orderid;

    @CreationTimestamp
    private Timestamp orderdate;

    private double amount;

    @ManyToOne(optional = false)
    @JoinColumn(name="email")
    private User user;

    private String status;

    public Orders() {
    }

    public Orders(Timestamp orderdate, double amount, User user) {
        this.orderdate = orderdate;
        this.amount = amount;
        this.user = user;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getDate() {
        return orderdate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", orderdate=" + orderdate +
                ", amount=" + amount +
                ", user=" + user +
                ", status='" + status + '\'' +
                '}';
    }
}
