package myservlet;

import dao.ItemInCartDao;
import dao.ItemInCartDaoImpl;
import model.ItemInCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AddCartServlet extends HttpServlet {
    private static ItemInCartDao itemInCartDao = new ItemInCartDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ItemInCart> itemInCartList =(List)session.getAttribute("orders");
        int id = itemInCartDao.getLastId();
        id++;
        itemInCartDao.addCartNumber(id);

        for (ItemInCart object: itemInCartList){
            itemInCartDao.addCartDetail(object, id);
        }


        session.setAttribute("total_q",0);
        session.setAttribute("total_p",0);
        session.setAttribute("orders",null);
    }
}
