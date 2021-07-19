package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.entity.ProductImage;
import lk.ac.eceylon.repository.ProductImageRepository;
import lk.ac.eceylon.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public boolean saveImages(ProductImage image) {
        Product product=new Product();
        product.setProductID(image.getProduct().getProductID());
        ProductImage img=new ProductImage();
        img.setImageurl(image.getImageurl().replace("C:\\fakepath\\", ""));
        img.setProduct(product);

        if(productImageRepository.save(img)==null)
            return false;
        else
            return true;

    }

    @Override
    public List<ProductImage> getProduct(int productID) {
        return productImageRepository.findProductImageByProductProductID(productID);
        //return null;
    }

    @Override
    public List<ProductImage> getProductImage(int productID) {
        return productImageRepository.findProductImageByProductProductID(productID);
    }
}
