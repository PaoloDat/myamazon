package model;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.ItemInCartDao;
import dao.ItemInCartDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static ItemDao itemDao = new ItemDaoImpl() ;
    private static ItemInCartDao itemInCartDao = new ItemInCartDaoImpl();

    public static void main(String[] args) {



//        Item rubber = new Item();
//        rubber.setCode("BVD12");
//        rubber.setName("стол");
//        rubber.setPrice(900);
//        itemDao.addItem(rubber);
//
//        List<Item> items = itemDao.getItemList();
//        for (Item itemm: items) {
//            System.out.println(itemm.toString());
//        }

//
//    ItemInCart itemInCart= new ItemInCart(2,"erd", "стол", 1200, 3, 3600,2);
//
//    itemInCartDao.addCartDetail(itemInCart,2);

    }
}
