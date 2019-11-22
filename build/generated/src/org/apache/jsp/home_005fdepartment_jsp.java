package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.entities.Department;
import model.dao.jdbc.DepartmentDaoJDBC;

public final class home_005fdepartment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Department Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"department_seller.jsp\" method=\"post\">\n");
      out.write("            <label>Name: </label>\n");
      out.write("            <input type=\"text\" name=\"name\"/>\n");
      out.write("            <button type=\"submit\">Search</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

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
                        out.print("<td><a href='update_department.jsp?id=" + list.get(i).getId() + "&name=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("<td><a href='delete.jsp?id=" + list.get(i).getId() + "&name=" + list.get(i).getName() + "'>click<a/></td>");
                        out.print("</tr>");
                    }
                }

                /* else {
                    List<Department> list = dell.findAllDepartmets(name_department);
                    for (int i = 0; i < list.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + list.get(i).getId() + "</td>");
                        out.print("<td>" + list.get(i).getName() + "</td>");
                        out.print("<td><a href='update_department.jsp?id=" + list.get(i).getId() + "&name=" + list.get(i).getName() + "'>click</a></td>");
                        out.print("<td><a href='delete.jsp?id=" + list.get(i).getId() + "&name=" + list.get(i).getName() + "'>click<a/></td>");
                        out.print("</tr>");
                    }
                }*/

                out.print("</table>");
            } catch (Exception e) {
                throw new RuntimeException("Error home department:" + e);
            }
        
      out.write("\n");
      out.write("        <a href=\"registration_department.jsp\">New Register</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
