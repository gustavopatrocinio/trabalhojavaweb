<%@page import="model.dao.jdbc.DepartmentDaoJDBC"%>
<%@page import="model.entities.Department"%>
<%@page import="db.DbException"%>
<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        Department dep = new Department();
        DepartmentDaoJDBC depp = new DepartmentDaoJDBC();
        
        String name_department = request.getParameter("name_department");
        
        if(name_department.equals("")){
            out.print("<script>alert('Required fields');</script>");
            response.sendRedirect("registration_department.jsp");
        } else {
            dep.setName(name_department);
            depp.insert(dep);
            out.print("<script>alert('Registration Sucessfully Completed');</script>");
            out.print("<script>window.location.href='index_jsp'</script>");
        }
        
        } catch (IOException e) {
            throw new DbException("Error execute registration department: " + e.getMessage());
        }

%>
