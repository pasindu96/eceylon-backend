package lk.ac.eceylon.dto;

public class ProductbyUserDTO {
    private int productID;
    private String description;
    private String displayName;
    private int qty_on_hand;
    private String delivery_area;
    private double price;
    private int categoryid;
    private String image;

    public ProductbyUserDTO() {
    }

    public ProductbyUserDTO(int productID, String description, String displayName, int qty_on_hand, String delivery_area, double price,int categoryID) {
        this.productID = productID;
        this.description = description;
        this.displayName = displayName;
        this.qty_on_hand = qty_on_hand;
        this.delivery_area = delivery_area;
        this.price = price;
        this.categoryid=categoryID;
    }

    public ProductbyUserDTO(int productID, String description, String displayName, int qty_on_hand, String delivery_area, double price, int categoryid, String image) {
        this.productID = productID;
        this.description = description;
        this.displayName = displayName;
        this.qty_on_hand = qty_on_hand;
        this.delivery_area = delivery_area;
        this.price = price;
        this.categoryid = categoryid;
        this.image = image;
    }

    public int getProductID() {
        return productID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(int qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }

    public String getDelivery_area() {
        return delivery_area;
    }

    public void setDelivery_area(String delivery_area) {
        this.delivery_area = delivery_area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "ProductbyUserDTO{" +
                "productID=" + productID +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", qty_on_hand=" + qty_on_hand +
                ", delivery_area='" + delivery_area + '\'' +
                ", price=" + price +
                ", categoryid=" + categoryid +
                ", image='" + image + '\'' +
                '}';
    }
}
