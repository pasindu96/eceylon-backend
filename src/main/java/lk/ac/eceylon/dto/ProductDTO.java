package lk.ac.eceylon.dto;

import lk.ac.eceylon.entity.Category;

public class ProductDTO {
    private int productID;
    private String description;
    private double unitPrice;
    private String displayName;
    private CategoryDTO category;
    private UserDTO user;
    private String deliveryArea;
    private int qty_on_hand;
    private String subCategory;

    public ProductDTO() {
    }

    public ProductDTO(int productID, String description, double unitPrice, String displayName, CategoryDTO category, UserDTO user, String deliveryArea,int qty_on_hand, String subCategory) {
        this.productID = productID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.displayName = displayName;
        this.category = category;
        this.user = user;
        this.deliveryArea = deliveryArea;
        this.qty_on_hand=qty_on_hand;
        this.subCategory = subCategory;
    }

    public int getProductID() {
        return productID;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(int qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productID=" + productID +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", displayName='" + displayName + '\'' +
                ", category=" + category +
                ", user=" + user +
                ", deliveryArea='" + deliveryArea + '\'' +
                ", qty_on_hand=" + qty_on_hand +
                ", subCategory='" + subCategory + '\'' +
                '}';
    }
}
