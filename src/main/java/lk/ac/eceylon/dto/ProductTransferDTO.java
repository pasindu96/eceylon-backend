package lk.ac.eceylon.dto;

public class ProductTransferDTO {
    private int productID;
    private String displayName;

    public ProductTransferDTO(int productID, String displayName) {
        this.productID = productID;
        this.displayName = displayName;
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

    @Override
    public String toString() {
        return "ProductTransferDTO{" +
                "productID=" + productID +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
