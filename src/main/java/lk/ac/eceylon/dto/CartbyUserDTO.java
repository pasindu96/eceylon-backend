package lk.ac.eceylon.dto;

public class CartbyUserDTO {
    private int cartID;
    private int productID;
    private String displayName;
    private int orderQty;
    private double unitPrice;

    public CartbyUserDTO(int cartID, int productID, String displayName, int orderQty, double unitPrice) {
        this.cartID = cartID;
        this.productID = productID;
        this.displayName = displayName;
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
    }

    public CartbyUserDTO() {
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "CartbyUserDTO{" +
                "cartID=" + cartID +
                ", productID=" + productID +
                ", displayName='" + displayName + '\'' +
                ", orderQty=" + orderQty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
