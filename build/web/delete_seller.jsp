<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Seller Page</title>
    </head>
    <body>

        <form action="execute_delete_seller.jsp" method="post">
            <label>Id: </label><br>
            <input type="text" name="id_seller" value="<%=request.getParameter("id_seller")%>"/><br>
            <label>Name: </label><br>
            <input type="text" name="name_seller" value="<%=request.getParameter("name_seller")%>"/><br><br>
            <button type="submit">Delete</button>

        </form>

    </body>
</html>

