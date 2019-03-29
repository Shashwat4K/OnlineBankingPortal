package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Moneytransfer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Money Transfer</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function display() {\n");
      out.write("                var p = document.getElementById('p1');\n");
      out.write("                var input = document.getElementById('amt');\n");
      out.write("                var out = document.getElementById('disp');\n");
      out.write("\n");
      out.write("                p.style.setProperty(\"display\", \"block\", \"important\");\n");
      out.write("\n");
      out.write("                out.innerHTML = input.value;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"jumbotron text-center\">\n");
      out.write("            <h1>Welcome to online.com</h1>\n");
      out.write("            <p>This is just tentative</p>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"navigation-bar\">\n");
      out.write("            <nav class=\"navbar navbar-inverse\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"Dashboard.jsp\">User</a>\n");
      out.write("                    </div>\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"Profile.jsp\">Edit Profile</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"#\">Money Transfer</a></li>\n");
      out.write("                        <li><a href=\"AccountDetails\">Account Details</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">  \n");
      out.write("                        <li><a href=\"#\" id=\"logout\"><span class=\"glyphicon glyphicon-log-out\"></span> Log-out</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"moneyportal\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <form method=\"post\" action=\"transaction.jsp\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend>Details of Receiver</legend>\n");
      out.write("                                <label for=\"recipient\">Name of Recipient:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"receiver\" id=\"recipient\" required><br>\n");
      out.write("                                <label for=\"bankname\">Name of bank: </label>\n");
      out.write("                                <select id=\"bankname\" name=\"bankname\" class=\"form-control\">\n");
      out.write("                                    <option value=\"null\">-Select-</option>\n");
      out.write("                                    <option value=\"KB\">KB</option>\n");
      out.write("                                    <option value=\"AXIS Bank\">AXIS Bank</option>\n");
      out.write("                                    <option value=\"State Bank of India\">State Bank of India</option>\n");
      out.write("                                    <option value=\"Bank of India\">Bank of India</option>\n");
      out.write("                                    <option value=\"ICICI Bank\">ICICI Bank</option>\n");
      out.write("                                </select> \n");
      out.write("                                <br>\n");
      out.write("                                <label for=\"accnum\">Account Number of Recipient</label>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" name=\"accnum\" id=\"accnum\" required><br>\n");
      out.write("                            </fieldset>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <label for=\"amt\">Amount: </label>\n");
      out.write("                            <input type='number'class=\"form-control\" name=\"amt\" id=\"amt\" onkeyup=\"display();\" required><br>\n");
      out.write("                            <label for=\"remarks\">Remarks: </label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"7\" name=\"remarks\" id=\"remarks\"></textarea><br>\n");
      out.write("                        </div>\n");
      out.write("                    </div> \n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <p id=\"p1\" style=\"display:none;\">Amount to be transferred</p>\n");
      out.write("                        <h1 id=\"disp\"></h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-lg btn-success  pull-right\">Pay</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-6\">\n");
      out.write("                             <button type=\"reset\" class=\"btn btn-lg btn-danger  pull-left\">Reset</button>\n");
      out.write("                        </div>    \n");
      out.write("                    </div>    \n");
      out.write("                    \n");
      out.write("                       \n");
      out.write("                </form>    \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
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
