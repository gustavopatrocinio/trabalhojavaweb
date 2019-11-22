<%@page import="model.dao.jdbc.DepartmentDaoJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
           DepartmentDaoJDBC depp = new DepartmentDaoJDBC();
           int id_department = Integer.parseInt(request.getParameter("id_department"));
           depp.deleteById(id_department);
           out.print("<script>alert('Record deleted')</script>");
           out.print("<script>window.location.href='index.jsp'</script>");
           
           
        } catch (Exception e) {
            throw new RuntimeException("Error execute delete department: " + e.getMessage());
        }




%>
