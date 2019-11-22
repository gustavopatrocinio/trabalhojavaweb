<%@page import="java.util.List"%>
<%@page import="model.entities.Department"%>
<%@page import="model.dao.jdbc.DepartmentDaoJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Page</title>
    </head>
    <body>
        <form action="department_seller.jsp" method="post">
            <label>Name: </label>
            <input type="text" name="name"/>
            <button type="submit">Search</button>
        </form>

        <%
            String name_department = request.getParameter("name");
            try {
                out.print("<table border='1'>");
                out.print("<tr>");
                out.print("<th>Id</th>");
                out.print("<th>Name</th>");
                out.print("</tr>");

                DepartmentDaoJDBC dell = new DepartmentDaoJDBC();

                if (name_department == "" || name_department == null) {
                    List<Department> list = dell.findAll();
                    for (int i = 0; i < list.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + list.get(i).getId() + "</td>");
                        out.print("<td>" + list.get(i).getName() + "</td>");
                        out.print("<td><a href='update_department.jsp?id_department=" + list.get(i).getId() + "&name_department=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("<td><a href='delete.jsp?id_department=" + list.get(i).getId() + "&name_department=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("</tr>");
                    }
                }

                 else {
                    List<Department> list = dell.findAllDepartmets(name_department);
                    for (int i = 0; i < list.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + list.get(i).getId() + "</td>");
                        out.print("<td>" + list.get(i).getName() + "</td>");
                        out.print("<td><a href='update_department.jsp?id_department=" + list.get(i).getId() + "&name_department=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("<td><a href='delete.jsp?id_department=" + list.get(i).getId() + "&name_department=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("</tr>");
                    }
                }

                out.print("</table>");
            } catch (Exception e) {
                throw new RuntimeException("Error home department:" + e);
            }
        %>
        <a href="registration_department.jsp">New Register</a>
    </body>
</html>
