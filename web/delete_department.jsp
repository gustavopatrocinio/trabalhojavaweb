<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Department Page</title>
    </head>
    <body>

        <form action="execute_delete_department.jsp" method="post">
            <label>Id: </label><br>
            <input type="text" name="id_department" value="<%=request.getParameter("id_department")%>"/><br>
            <label>Name: </label><br>
            <input type="text" name="name_department" value="<%=request.getParameter("name_department")%>"/><br><br>
            <button type="submit">Delete</button>

        </form>

    </body>
</html>