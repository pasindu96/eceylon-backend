package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.dto.ProductDTO;
import lk.ac.eceylon.entity.Category;
import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.entity.ProductImage;
import lk.ac.eceylon.entity.User;
import lk.ac.eceylon.repository.ProductRepository;
import lk.ac.eceylon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Product saveProduct(ProductDTO productDTO) {

        User user=new User();
        user.setEmail(productDTO.getUser().getEmail());

        Category category=new Category();
        category.setCategoryID(productDTO.getCategory().getCategoryID());
        //System.out.println(category);
        Product product=new Product();
        product.setDescription(productDTO.getDescription());
        product.setUnitPrice(productDTO.getUnitPrice());
        product.setDisplayName(productDTO.getDisplayName());
        product.setCategory(category);
        product.setQty_on_hand(productDTO.getQty_on_hand());
        product.setUser(user);
        product.setDelivery_Area(productDTO.getDeliveryArea());
        product.setSubCategory(productDTO.getSubCategory());

        return productRepository.save(product);
    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public Product getProduct(int id) {
//
//        return productRepository.findById(id).get();
//    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getProduct(int id) {
        return productRepository.findProductByCategoryCategoryID(id);
    }

    @Override
    public Product getProductByID(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getCategoryByProductName(String name) {
        return productRepository.findProductByDisplayNameContaining(name);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean updateProduct(Product product) {
        Product productToUpdate = productRepository.getOne(product.getProductID());
        productToUpdate.setQty_on_hand(product.getQty_on_hand());
        productToUpdate.setDisplayName(product.getDisplayName());
        productToUpdate.setQty_on_hand(product.getQty_on_hand());
        productToUpdate.setUnitPrice(product.getUnitPrice());
        productToUpdate.setDelivery_Area(product.getDelivery_Area());
        productToUpdate.setDescription(product.getDescription());
        productRepository.save(productToUpdate);
        return true;
    }

    @Override
    public List<Product> getFilteredProducts(int id) {

        return productRepository.findProductByCategoryCategoryIDOrderByUnitPriceAsc(id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getProductByUser(String email) {
        return productRepository.findProductByUserEmail(email);
    }
}
