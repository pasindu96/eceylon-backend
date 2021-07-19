package lk.ac.eceylon.repository;

import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    //List<Product> findProductByCategoryCategoryID(@Param("id") Integer id);
    List<Product> findProductByDisplayNameLike(@Param("displayName") String displayName);
    List<Product>  findProductByCategoryCategoryID(@Param("categoryID") int categoryID);
    List<Product> findProductByDisplayNameContaining(@Param("displayName") String displayName);
    List<Product> findProductByUserEmail(@Param("email") String email);
    List<Product>  findProductByCategoryCategoryIDOrderByUnitPriceAsc(@Param("categoryID") int categoryID);

}
