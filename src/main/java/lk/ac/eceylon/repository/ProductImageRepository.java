package lk.ac.eceylon.repository;

import lk.ac.eceylon.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {

    List<ProductImage> findProductImageByProductProductID(@Param("id") Integer id);

}
