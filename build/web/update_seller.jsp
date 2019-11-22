<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Seller Page</title>
    </head>
    <body>
        <form action="execute_update_seller.jsp" method="post">
            <label>Id: </label><br>
            <input type="text" name="id_seller" value="<%=request.getParameter("id_seller")%>"/><br>
            <label>Name: </label><br>
            <input type="text" name="name_seller" value="<%=request.getParameter("name_seller")%>"/><br>
            <label>Email: </label><br>
            <input type="password" name="email_seller" value="<%=request.getParameter("email_seller")%>"/><br>
            <label>Password: </label><br>
            <input type="password" name="password_seller" value="<%=request.getParameter("password_seller")%>"/><br><br>
            <label>Birth Date: </label><br>
            <input type="date" name="birthdate_seller" value="<%=request.getParameter("birthdate_seller")%>"/><br><br>
            <label>Base Salary: </label><br>
            <input type="text" name="basesalary_seller" value="<%=request.getParameter("basesalary_seller")%>"/><br><br>
            <label>Department: </label><br>
            <input type="text" name="department_seller" value="<%=request.getParameter("department_seller")%>"/><br><br>
            
            <button type="submit">Update</button>
            
        </form>
              
    </body>
</html>
