<%@page import="model.dao.jdbc.DepartmentDaoJDBC"%>
<%@page import="model.entities.Department"%>
<%@page import="db.DbException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {

        Department dep = new Department();
        DepartmentDaoJDBC depp = new DepartmentDaoJDBC();

        String name_department = request.getParameter("name_department");
        int id_department = Integer.parseInt(request.getParameter("id_department"));

        if (name_department.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            dep.setName(name_department);
            dep.setId(id_department);
            depp.update(dep);
            out.print("<script>alert('Sucessfully updated');</script>");
            out.print("<script>window.location.href='index.jsp'</script>");

        }

    } catch (Exception e) {
        throw new DbException("Error execute update department: " + e.getMessage());
    }


%>
