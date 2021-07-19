package lk.ac.eceylon.dto;

public class OrderDetailDTO {
    private int orderid;
    private int productid;
    private int quantity;
    private int cartid;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderid, int productid, int quantity, int cartid) {
        this.orderid = orderid;
        this.productid = productid;
        this.quantity = quantity;
        this.cartid = cartid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderid=" + orderid +
                ", productid=" + productid +
                ", quantity=" + quantity +
                ", cartid=" + cartid +
                '}';
    }
}
