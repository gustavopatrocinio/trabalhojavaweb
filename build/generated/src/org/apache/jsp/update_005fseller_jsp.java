package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class update_005fseller_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Update Seller Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"execute_update_seller.jsp\" method=\"post\">\n");
      out.write("            <label>Id: </label><br>\n");
      out.write("            <input type=\"text\" name=\"id_seller\" value=\"");
      out.print(request.getParameter("id_seller"));
      out.write("\"/><br>\n");
      out.write("            <label>Name: </label><br>\n");
      out.write("            <input type=\"text\" name=\"name_seller\" value=\"");
      out.print(request.getParameter("name_seller"));
      out.write("\"/><br>\n");
      out.write("            <label>Email: </label><br>\n");
      out.write("            <input type=\"password\" name=\"email_seller\" value=\"");
      out.print(request.getParameter("email_seller"));
      out.write("\"/><br>\n");
      out.write("            <label>Password: </label><br>\n");
      out.write("            <input type=\"password\" name=\"password_seller\" value=\"");
      out.print(request.getParameter("password_seller"));
      out.write("\"/><br><br>\n");
      out.write("            <label>Birth Date: </label><br>\n");
      out.write("            <input type=\"text\" name=\"birthdate_seller\" value=\"");
      out.print(request.getParameter("birthdate_seller"));
      out.write("\"/><br><br>\n");
      out.write("            <label>Base Salary: </label><br>\n");
      out.write("            <input type=\"text\" name=\"basesalary_seller\" value=\"");
      out.print(request.getParameter("basesalary_seller"));
      out.write("\"/><br><br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <button type=\"submit\">Update</button>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("              \n");
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
