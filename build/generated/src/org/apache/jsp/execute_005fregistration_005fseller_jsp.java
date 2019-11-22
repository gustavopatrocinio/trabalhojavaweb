package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import db.DbException;
import model.entities.Department;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.io.IOException;
import java.util.Date;
import model.dao.jdbc.SellerDaoJDBC;
import model.entities.Seller;

public final class execute_005fregistration_005fseller_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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



      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
