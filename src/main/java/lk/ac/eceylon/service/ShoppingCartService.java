package lk.ac.eceylon.service;

import lk.ac.eceylon.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService  {
    public boolean saveCart(ShoppingCart cart);
    public List<ShoppingCart> getItems(String email);
    public boolean updateCart(int cartID);
    public boolean deleteItem(int cartID);
}
