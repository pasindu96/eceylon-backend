package lk.ac.eceylon.dto;

import java.util.Arrays;

public class ProductImageDTO {
    private int imgID;
    private String imageurl;
    private ProductDTO product;

    public ProductImageDTO() {
    }

    public ProductImageDTO(int imgID, String imageurl, ProductDTO product) {
        this.imgID = imgID;
        this.imageurl = imageurl;
        this.product = product;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImageDTO{" +
                "imgID=" + imgID +
                ", imageurl='" + imageurl + '\'' +
                ", product=" + product +
                '}';
    }
}
