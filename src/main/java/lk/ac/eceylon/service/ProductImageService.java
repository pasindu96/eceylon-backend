package lk.ac.eceylon.service;

import lk.ac.eceylon.entity.ProductImage;

import java.util.List;

public interface ProductImageService {
    public boolean saveImages(ProductImage image);
    List<ProductImage> getProduct(int productID);
    List<ProductImage> getProductImage(int productID);
}
