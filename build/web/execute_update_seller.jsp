<%@page import="model.entities.Department"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.management.RuntimeErrorException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.entities.Seller"%>
<%@page import="model.dao.jdbc.SellerDaoJDBC"%>

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
         int id_seller = Integer.parseInt(request.getParameter("id_seller"));
         
         if (name_seller.equals("") || email_seller.equals("") || password_seller.equals("") || birthDate_seller.equals("") || baseSalary_seller.equals("") || department_seller.equals("")) {
                response.sendRedirect("index.jsp");
         }
         else {
             sel.setName(name_seller);
             sel.setEmail(email_seller);
             sel.setPassword(password_seller);
             sel.setBirthDate(sdf.parse(birthDate_seller));
             sel.setBaseSalary(baseSalary_seller);
             sel.setDepartment(new Department(null, department_seller));
             sel.setId(id_seller);
             sell.update(sel);
             out.print("<script>alert('Successfully updated');</script>");
             out.print("<script>window.location.href='index.jsp'</script>");
         }
         
         
      } catch (Exception erro) {
          throw new RuntimeException("Error execute updated seller: " + erro);
      }
  
%>