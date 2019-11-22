<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.dao.jdbc.SellerDaoJDBC"%>
<%@page import="model.dao.jdbc.DepartmentDaoJDBC"%>
<%@page import="java.util.ArrayList"%>

<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
    </head>
    <body>

        <form action="index.jsp" method="post">
            <label>Registration: </label> <br/><br/>
            <a href="home_seller.jsp">Sellers</a>
            <a href="home_department.jsp">Departments</a>
        </form>

    </body>
</html>
