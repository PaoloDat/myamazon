package dao;

import model.Item;

import java.util.List;

public interface ItemDao {
    void addItem (Item item);
    void updateItem (Item item);
    void removeItem (int id);
    Item getItemById (int id);
    List<Item> getItemList();
}
