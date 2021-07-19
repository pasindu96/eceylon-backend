package lk.ac.eceylon.service;

import lk.ac.eceylon.dto.CategoryDTO;
import lk.ac.eceylon.dto.ProductDTO;
import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.entity.ProductImage;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDTO product);
    //Product getProduct(int id);
    List<Product> getProduct(int id);
    Product getProductByID(int id);
    List<Product> getCategoryByProductName(String name);
    List<Product> getProductByUser(String email);
    List<Product> getAllProducts();
    boolean updateProduct(Product product);
    List<Product> getFilteredProducts(int id);

}
