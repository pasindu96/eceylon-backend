package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.entity.ShoppingCart;
import lk.ac.eceylon.repository.ProductRepository;
import lk.ac.eceylon.repository.ShoppingCartRepository;
import lk.ac.eceylon.service.ProductService;
import lk.ac.eceylon.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class ShoppingCartImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository cartRepo;
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveCart(@RequestBody  ShoppingCart cart) {
        Product productToUpdate = productRepository.getOne(cart.getProduct().getProductID());
        productToUpdate.setQty_on_hand(productToUpdate.getQty_on_hand()-cart.getQuantity());
        productRepository.save(productToUpdate);

        if(cartRepo.save(cart) != null)
            return true;
        else
            return false;
    }

    @Override
    public List<ShoppingCart> getItems(String email) {
        return cartRepo.findShoppingCartByUserEmail(email);
    }

    @Override
    public boolean updateCart(int cartID) {
//        ShoppingCart cart= cartRepo.findById(cartID).get();
        ShoppingCart cartToUpdate=cartRepo.getOne(cartID);
        cartToUpdate.setStatus("Yes");
        cartRepo.save(cartToUpdate);
        return true;
    }

    @Override
    public boolean deleteItem(int cartID) {
        ShoppingCart cartToUpdate=cartRepo.getOne(cartID);
        cartToUpdate.setStatus("Deleted");

        Product productToUpdate=productRepository.getOne(cartToUpdate.getProduct().getProductID());
        productToUpdate.setQty_on_hand(productToUpdate.getQty_on_hand()+cartToUpdate.getQuantity());
        productRepository.save(productToUpdate);
        if(cartRepo.save(cartToUpdate)!=null)
            return true;
        else
            return false;
    }
}
