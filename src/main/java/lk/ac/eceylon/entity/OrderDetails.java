package lk.ac.eceylon.entity;

import javax.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int odID;

    @ManyToOne(optional = false)
    @JoinColumn(name="orderid")
    private Orders order;

    @ManyToOne(optional = false)
    @JoinColumn(name="productID")
    private Product product;

    private int quantity;

    public OrderDetails(Orders order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderDetails() {
    }

    public int getOdID() {
        return odID;
    }

    public void setOdID(int odID) {
        this.odID = odID;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "odID=" + odID +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
