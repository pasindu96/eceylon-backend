package lk.ac.eceylon.dto;

public class OrderProductDetailDTO {
    private String name;
    private int quantity;
    private double amount;

    public OrderProductDetailDTO() {
    }

    public OrderProductDetailDTO(String name, int quantity, double amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProductDetailDTO{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
