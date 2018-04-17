package myservlet;


import com.google.gson.Gson;
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
import java.util.*;


public class CartServlet extends HttpServlet {
    private static ItemDao itemDao = new ItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer cartId = (Integer) session.getAttribute("cartId");

        if(session.getAttribute("total_q") == null) {
            session.setAttribute("total_q", quantity);
        } else {
            session.setAttribute("total_q", quantity + (Integer)session.getAttribute("total_q") );
        }
        if(session.getAttribute("total_p") == null) {
            session.setAttribute("total_p", price*quantity);
        } else {
            session.setAttribute("total_p",(Integer)session.getAttribute("total_p") + price*quantity);
        }




        String text_q = session.getAttribute("total_q").toString();
        String text_p = session.getAttribute("total_p").toString();


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(text_q + "=" +text_p);




        Item item = itemDao.getItemById(id);
        ItemInCart itemInCart = new ItemInCart(id, item.getCode(), item.getName(),
                item.getPrice(), quantity, price*quantity,cartId  );

        if (session.getAttribute("orders") == null) {
            List<ItemInCart> myorder = new ArrayList<>();
            myorder.add(itemInCart);
            session.setAttribute("orders", myorder);
        } else {
            List<ItemInCart> myorder = (List<ItemInCart>) session.getAttribute("orders");
            myorder.add(itemInCart);
            session.setAttribute("orders", myorder);
        }



        System.out.println(session.getAttribute("orders"));



    }
}


//
//        int price =Integer.parseInt(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//        request.getSession().setAttribute("quantity",quantity);
//        request.getSession().setAttribute("total",price*quantity);
//
//        Map<String, Integer> cartel = new LinkedHashMap<>();
//        cartel.put("quantity", quantity);
//        cartel.put("total", price*quantity);
//
//        String json = new Gson().toJson(cartel);
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);



//    Integer quantity = (Integer) request.getSession().getAttribute("quantity");
//        total_q = total_q+quantity;
//                request.getSession().setAttribute("total_q",123);
//                request.getRequestDispatcher("WEB-INF/pages/home.jsp").forward(request,response);













//        Item item = itemDao.getItemById(id);
//        ItemInCart itemInCart = new ItemInCart(id, item.getCode(), item.getName(), item.getPrice(), quantity, price*quantity,cartId  );
//
//        List<ItemInCart> myorder = (ArrayList) request.getSession().getAttribute("orders");
//        List<ItemInCart> myorder = new ArrayList<>();
//        myorder.add(itemInCart);
//        request.getSession().setAttribute("orders", myorder);