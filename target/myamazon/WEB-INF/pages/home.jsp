<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>
<head>
    <title>Online Store "My Amason"</title>
    <link href="css/site.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
  </head>
<body>
    <div id="cart">
        <table>
           <tr>
               <td width="200" >покупок в корзине</td>
               <td id="quantity">0</td>
           </tr>
            <tr>
                <td width="200">сумма </td>
                <td id="total">0</td>
            </tr>
        </table>
    </div>

    <div id="cart_form">
        <form>
            <input type="button" value="подтвердить заказ" class="button10" id="confirm" onclick="go()" >
        </form>
    </div>
    <div class="le1">
        <table class="tab" id="mytable">
            <caption class="cap">Список товаров нашего магазина</caption>
            <tr>
                <th width="80" class="rer">Код</th>
                <th width="140" class="rer">Названиие</th>
                <th width="60" class="rer">Цена</th>
                <th width="60" class="rer">Количество</th>
             </tr>
            <c:forEach items="${sessionScope.itemsList}" var="stuck">
                <tr class="spaceUnder">
                    <td>${stuck.code}</td>
                    <td >${stuck.name}</td>
                    <td id=${stuck.id}>${stuck.price}</td>
                    <td class="rer1">
                        <form action="">
                            <input type="text" placeholder="0" size="3" class="incol" name=${stuck.id} >
                            <input type="button" id="addtocart" value="добавить в корзину" class="bun" data-name=${stuck.id} >
                         </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>












