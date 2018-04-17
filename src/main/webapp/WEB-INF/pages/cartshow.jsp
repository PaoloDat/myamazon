<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Title</title>
    <link href="css/site.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/cartshow.js"></script>

    <style>
        #db {
            position: absolute;
            top: 10px;
            right: 0;
            width: 200px;
        }
    </style>
</head>
<body>
    <div class="le1">
        <table class="tab">
            <caption class="cap">Ваша корзина</caption>
            <tr>
                <th width="80" class="rer">код товара</th>
                <th width="80" class="rer">название</th>
                <th width="80" class="rer">цена</th>
                <th width="80" class="rer">количество</th>
                <th width="140" class="rer">общая стоимость</th>
            </tr>
            <c:forEach items="${orders}" var="un">
                <tr class="spaceUnder">
                    <td>${un.code}</td>
                    <td>${un.name}</td>
                    <td>${un.price}</td>
                    <td>${un.quantity}</td>
                    <td class="newtotal">${un.total}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" align="right" style="font-weight: bold">Всего к оплате:</td>
                <td id="sum" align="right" style="font-weight: bold"></td>
            </tr>
        </table>
    </div>
    <br>
    <br>
    <div class="db" id="db">
        <form>
            <input type="button" value="Сохранить заказ в базу данных" class="dbbutton">
        </form>
    </div>

</body>
</html>
