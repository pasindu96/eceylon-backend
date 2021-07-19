package lk.ac.eceylon.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int imgID;
    private String imageurl;

    @ManyToOne(optional = false,fetch = FetchType.LAZY )
    @JoinColumn(name="productID")
    @Fetch(FetchMode.JOIN)
    private Product product;

    public ProductImage(String imageurl, Product product) {
        this.imageurl = imageurl;
        this.product = product;
    }

    public ProductImage() {

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "imgID=" + imgID +
                ", imageurl='" + imageurl + '\'' +
                ", product=" + product +
                '}';
    }
}
