package lk.ac.eceylon.repository;

import lk.ac.eceylon.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
    List<ShoppingCart> findShoppingCartByUserEmail(@Param("email") String email);

}
