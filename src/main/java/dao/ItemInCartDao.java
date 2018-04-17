package dao;

import model.ItemInCart;

public interface ItemInCartDao {
    void addCartNumber(int id);
    void addCartDetail (ItemInCart itemInCart, int id);
    int  getLastId();
}
