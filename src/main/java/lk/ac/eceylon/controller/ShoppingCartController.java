package lk.ac.eceylon.controller;

import lk.ac.eceylon.dto.CartbyUserDTO;
import lk.ac.eceylon.entity.ShoppingCart;
import lk.ac.eceylon.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/eceylon")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @PostMapping(value = "/cart",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCartItems(@RequestBody ShoppingCart cart){
        return cartService.saveCart(cart);
    }

    @GetMapping(value="/cart/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartbyUserDTO> getCartItems(@PathVariable String email){
//        public List<CartbyUserDTO> getCartItems(@PathVariable(value="email") String email){
//            email=email.replace("email=","");
        List<ShoppingCart> cartItems=cartService.getItems(email);
        List<CartbyUserDTO> cartList=new ArrayList<CartbyUserDTO>();
        if(cartItems!=null){
            for (ShoppingCart item : cartItems) {
                if(item.getStatus().equals("No")) {
                    cartList.add(new CartbyUserDTO(
                            item.getCartID(),
                            item.getProduct().getProductID(),
                            item.getProduct().getDisplayName(),
                            item.getQuantity(),
                            item.getPrice()
                    ));
                }
            }
        }
        return cartList;
    }

    @GetMapping(value = "/cart/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteProduct(@PathVariable String id){
//        id=id.replace("id=","");
        return cartService.deleteItem(Integer.parseInt(id));
    }
}
