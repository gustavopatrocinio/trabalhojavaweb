<%@page import="db.DbException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.jdbc.SellerDaoJDBC"%>
<%@page import="model.entities.Seller"%>

<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seller Page</title>
    </head>
    <body>


        <form action="home_seller.jsp" method="post">
            <label>Name: </label>
            <input type="text" name="name"/>
            <button type="submit">Search</button>
            <a href="registration_seller.jsp">New Register</a>
        </form>

        <%
            String name_seller = request.getParameter("name");
            try {
                out.print("<table border='1'>");
                    out.print("<tr>");
                    out.print("<th>Id</th>");
                    out.print("<th>Name</th>");
                    out.print("<th>Email</th>");
                    out.print("<th>Password</th>");
                    out.print("<th>BirthDate</th>");
                    out.print("<th>Base Salary</th>");
                    out.print("<th>Department</th>");
                    out.print("<th>Edit</th>");
                    out.print("<th>Delete</th>");
                    out.print("</tr>");
                    SellerDaoJDBC sell = new SellerDaoJDBC();
                
                
                if (name_seller == "" || name_seller == null) {
                    ArrayList<Seller> list = sell.findAll();
                    for (int i = 0; i < list.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + list.get(i).getId() + "</td>");
                        out.print("<td>" + list.get(i).getName() + "</td>");
                        out.print("<td>" + list.get(i).getEmail() + "</td>");
                        out.print("<td>" + list.get(i).getPassword() + "</td>");
                        out.print("<td>" + list.get(i).getBirthDate() + "</td>");
                        out.print("<td>" + list.get(i).getBaseSalary() + "</td>");
                        out.print("<td>" + list.get(i).getDepartment() + "</td>");
                        out.print("<td><a href='update_seller.jsp?id_seller=" + list.get(i).getId()
                                + "&name_seller=" + list.get(i).getName()
                                + "&email_seller=" + list.get(i).getEmail()
                                + "&password_seller=" + list.get(i).getPassword()
                                + "&birthdate_seller=" + list.get(i).getBirthDate()
                                + "&basesalary_seller=" + list.get(i).getBaseSalary()
                                + "&department_seller=" + list.get(i).getDepartment()+ "'>click</a></td>");
                        out.print("<td><a href='delete_seller.jsp?id_seller=" + list.get(i).getId()
                                + "&name_seller=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("</tr>");
                    }
                } else {
                    ArrayList<Seller> list = sell.findAllSellers(name_seller);
                    for (int i = 0; i < list.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + list.get(i).getId() + "</td>");
                        out.print("<td>" + list.get(i).getName() + "</td>");
                        out.print("<td>" + list.get(i).getEmail() + "</td>");
                        out.print("<td>" + list.get(i).getPassword() + "</td>");
                        out.print("<td>" + list.get(i).getBirthDate() + "</td>");
                        out.print("<td>" + list.get(i).getBaseSalary() + "</td>");
                        out.print("<td>" + list.get(i).getDepartment() + "</td>");
                        out.print("<td><a href='update_seller.jsp?id_seller=" + list.get(i).getId()
                                + "&name_seller=" + list.get(i).getName()
                                + "&email_seller=" + list.get(i).getEmail()
                                + "&password_seller=" + list.get(i).getPassword()
                                + "&birthdate_seller=" + list.get(i).getBirthDate()
                                + "&basesalary_seller=" + list.get(i).getBaseSalary()
                                + "&department_seller=" + list.get(i).getDepartment()+ "'>click</a></td>");
                        out.print("<td><a href='delete_seller.jsp?id_seller=" + list.get(i).getId()
                                + "&name_seller=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("</tr>");
                    }
                }

                out.print("</table>");
            } catch (Exception e) {
                throw new DbException("Error home seller: " + e.getMessage());
            }
        %>
        
    </body>
</html>
