package myservlet;

import dao.ItemDao;
import dao.ItemDaoImpl;
import model.Item;
import model.ItemInCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class HomeServlet extends HttpServlet {
    private static ItemDao itemDao = new ItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Item> itemsList = itemDao.getItemList();



        session.setAttribute("itemsList", itemsList);

        session.setAttribute("cartId",1);
        request.getRequestDispatcher("WEB-INF/pages/home.jsp").forward(request,response);
    }
}
