<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.dao.jdbc.SellerDaoJDBC"%>

<%
    try {
           SellerDaoJDBC sell = new SellerDaoJDBC();
           int id_seller = Integer.parseInt(request.getParameter("id_seller"));
           sell.deleteById(id_seller);
           out.print("<script>alert('Record deleted')</script>");
           out.print("<script>window.location.href='index.jsp'</script>");
           
           
        } catch (Exception erro) {
            throw new RuntimeException("Error execute delete seller: " + erro);
        }




%>