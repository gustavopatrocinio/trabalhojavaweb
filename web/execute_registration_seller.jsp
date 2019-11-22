<%@page import="db.DbException"%>
<%@page import="model.entities.Department"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.dao.jdbc.SellerDaoJDBC"%>
<%@page import="model.entities.Seller"%>

<%
        try {
 
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Seller sel = new Seller();
            SellerDaoJDBC sell = new SellerDaoJDBC();
            
            String name_seller = request.getParameter("name_seller");
            String email_seller = request.getParameter("email_seller");
            String password_seller = request.getParameter("password_seller");
            String birthDate_seller = (request.getParameter("birthdate_seller"));
            Double baseSalary_seller = Double.parseDouble(request.getParameter("basesalary_seller"));
            String department_seller = request.getParameter("department_seller");

            if (name_seller.equals("") || email_seller.equals("") || password_seller.equals("") || birthDate_seller.equals("") || baseSalary_seller.equals("") || department_seller.equals("")) {
                out.print("<script>alert('Required fields');</script>");
                response.sendRedirect("registration_seller.jsp");
            }
            else {
                sel.setName(name_seller);
                sel.setEmail(email_seller);
                sel.setPassword(password_seller);
                sel.setBirthDate(sdf.parse(birthDate_seller));
                sel.setBaseSalary(baseSalary_seller);
                sel.setDepartment(new Department(null, department_seller));
                sell.insert(sel);
             out.print("<script>alert('Registration successfully Complete');</script>");
             out.print("<script>window.location.href='index.jsp'</script>");

        }
    }
    catch (IOException e) {
            throw new DbException("Error execute registration seller" + e.getMessage());
    }


%>



