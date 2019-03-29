package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\">\n");
      out.write("        <title>Welcome ");
 request.getParameter("name");
      out.write("</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Titillium+Web\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            /*.navbar{\n");
      out.write("                font-size: 1.5em;\n");
      out.write("                border-radius: 0px;\n");
      out.write("                letter-spacing: 1px;\n");
      out.write("            }*/\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function validate() {\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function change() {\n");
      out.write("                var preview = document.querySelector('img');\n");
      out.write("                var file = document.querySelector('input[type=file]').files[0]; //sames as here\n");
      out.write("                var reader = new FileReader();\n");
      out.write("\n");
      out.write("                reader.onloadend = function () {\n");
      out.write("                    preview.src = reader.result;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (file) {\n");
      out.write("                    reader.readAsDataURL(file); //reads the data as a URL\n");
      out.write("                } else {\n");
      out.write("                    preview.src = \"http://s3.amazonaws.com/37assets/svn/765-default-avatar.png\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>    \n");
      out.write("\n");
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
      out.write("                        <a class=\"navbar-brand\" href=\"#\">User</a>\n");
      out.write("                    </div>\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"Profile.jsp\">Edit Profile</a></li>\n");
      out.write("                        <li><a href=\"Moneytransfer.jsp\">Money Transfer</a></li>\n");
      out.write("                        <li><a href=\"AccountDetails\">Account Details</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">  \n");
      out.write("                        <li><a href=\"#\" id=\"logout\"><span class=\"glyphicon glyphicon-log-out\"></span> Log-out</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"profile\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"container text-center\">\n");
      out.write("                    <h1 style=\"font-size: 3em;font-family: 'Titillium Web', sans-serif;\">Update Your Profile</h1>\n");
      out.write("                </div>   \n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <form method=\"post\" onsubmit=\"return validate()\" action=\"UpdateDetails\">\n");
      out.write("                        <div class=\"col-lg-8\">\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend>Personal Information</legend>\n");
      out.write("                                <label for=\"username\">User Name:</label>\n");
      out.write("                                <input id=\"username\" class=\"form-control\" type=\"text\" name=\"uname\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${request.getParameter(\"uname\")}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("                                <label for=\"npass\">New Password:</label>\n");
      out.write("                                <input id=\"npass\" class=\"form-control\" type=\"password\" name=\"npass\"><br>\n");
      out.write("                                <label for=\"rnpass\">Re-enter New Password:</label>\n");
      out.write("                                <input id=\"rnpass\" class=\"form-control\" type=\"password\" name=\"rnpass\"><br>\n");
      out.write("                            </fieldset>\n");
      out.write("                            <br>\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend>Contact Information</legend>\n");
      out.write("                                <label for=\"Email\">E-Mail:</label>\n");
      out.write("                                <input id=\"Email\" class=\"form-control\" type=\"email\" name=\"email\" placeholder=\"email\"><br>\n");
      out.write("                                <label for=\"contact\">Contact Number</label>\n");
      out.write("                                <input id=\"contact\" class=\"form-control\" type=\"number\" name=\"phone\" placeholder=\"contact\"><br>\n");
      out.write("\n");
      out.write("                            </fieldset>\n");
      out.write("\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-6\">\n");
      out.write("                                    <button class=\"btn btn-lg btn-success\" type=\"submit\" style=\"float:right;width:4.5cm;\" >Submit</button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6\">\n");
      out.write("                                    <button type=\"reset\" class=\"btn btn-lg btn-danger\" style=\"float:left;width:4.5cm;\">Reset</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>    \n");
      out.write("                        </div>  \n");
      out.write("\n");
      out.write("                        <div class=\"col-lg-4\">\n");
      out.write("                            <div class=\"sidebar\">\n");
      out.write("                                <div class=\"DisplayImage\">\n");
      out.write("                                    <fieldset>\n");
      out.write("                                        <legend>Profile Picture</legend>\n");
      out.write("                                        <center><img id=\"profilepic\" class=\"img-circle\" src=\"http://s3.amazonaws.com/37assets/svn/765-default-avatar.png\" width=\"254\" height=\"254\"/></center><br><br>\n");
      out.write("                                        <input id=\"fileUpload\" class=\"form-control\" name=\"FileUpload\" type=\"file\" onchange=\"change();\">\n");
      out.write("\n");
      out.write("                                    </fieldset>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                </div>\n");
      out.write("                </form>    \n");
      out.write("            </div>    \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("</body>\n");
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
