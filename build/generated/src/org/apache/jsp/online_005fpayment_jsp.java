package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class online_005fpayment_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Sessions Demo</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Ubuntu\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            @import url('https://fonts.googleapis.com/css?family=Krona+One');\n");
      out.write("            .PageHead{\n");
      out.write("                background-color: #a506df;\n");
      out.write("                color: #eee; \n");
      out.write("                font-family: 'Krona One', sans-serif;\n");
      out.write("                width: 100%;\n");
      out.write("                height:200px;\n");
      out.write("            }\n");
      out.write("            .PageBody{\n");
      out.write("                margin: 2cm 3cm 2cm 3cm; \n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            #test{\n");
      out.write("                width: 100%;\n");
      out.write("                \n");
      out.write("                height: 1050px;\n");
      out.write("                background-color: white;   \n");
      out.write("            }\n");
      out.write("            .Display{\n");
      out.write("                padding: 0.5cm 2cm 0.5cm 2cm;\n");
      out.write("            }\n");
      out.write("            .Display h2{\n");
      out.write("                font-family: 'Krona One', sans-serif;\n");
      out.write("                font-size: 3em;\n");
      out.write("                color:#560688; \n");
      out.write("            }\n");
      out.write("            .Display list-group-item{\n");
      out.write("                font-size: 2em;\n");
      out.write("                color:#7306b7;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        /************************************    Navigation bar Styling    ********************************************************************/\n");
      out.write("        \n");
      out.write("        .navbar {\n");
      out.write("            font-family: 'Monteserrat', sans-serif;\n");
      out.write("            font-size: 18px;\n");
      out.write("            margin-bottom: 0;\n");
      out.write("            background-color: #42045f;\n");
      out.write("            border: 0;\n");
      out.write("            font-size: 12px !important;\n");
      out.write("            line-height: 1.42857143 !important;\n");
      out.write("            letter-spacing: 4px;\n");
      out.write("            border-radius: 0;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .navbar li a,\n");
      out.write("        .navbar .navbar-brand {\n");
      out.write("            color: #fff !important;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .navbar-nav li a {\n");
      out.write("            -o-transition: background 1s, color 1s;\n");
      out.write("            -moz-transition: background 1s, color 1s;\n");
      out.write("            -webkit-transition: background 1s, color 1s;\n");
      out.write("            transition: background 1s, color 1s;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .navbar-nav li a:hover,\n");
      out.write("        .navbar-nav li.active a {\n");
      out.write("            color: #42045f !important;\n");
      out.write("            background-color: #fff !important;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .navbar-inverse .navbar-toggle {\n");
      out.write("            border-color: transparent;\n");
      out.write("            color: #fff !important;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .navbar-nav li {\n");
      out.write("            text-align: center;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        /*************************************************************************************************************************************/\n");
      out.write("        \n");
      out.write("        .modal-header,\n");
      out.write("        .close {\n");
      out.write("            background: radial-gradient(rgb(2, 65, 153), rgb(5, 103, 240));\n");
      out.write("            color: #fff !important;\n");
      out.write("            text-align: center;\n");
      out.write("            font-size: 30px;\n");
      out.write("        }\n");
      out.write("        .modal-header h1{\n");
      out.write("            font-family: 'Krona One',sans-serif;\n");
      out.write("            font-size: 3em;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .modal-body {\n");
      out.write("            background: radial-gradient(rgb(26, 25, 25), rgb(51, 49, 49));\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        #login {\n");
      out.write("            font-family: 'Ubuntu', sans-serif;\n");
      out.write("            font-size: 18px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .modal-header,\n");
      out.write("        .modal-body {\n");
      out.write("            padding: 40px 50px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .input-lg {\n");
      out.write("            border-radius: 0px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        /*************************************************   Buttons Styling   *************************************************************************/\n");
      out.write("        \n");
      out.write("        #register {\n");
      out.write("            width: 150px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .btn-block {\n");
      out.write("            font-family: 'Montserrat', sans-serif;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .btn-success,\n");
      out.write("        .btn-danger {\n");
      out.write("            border-radius: 0px;\n");
      out.write("            -o-transition: background 1s, color 1s, border 1s;\n");
      out.write("            -moz-transition: background 1s, color 1s, border 1s;\n");
      out.write("            -webkit-transition: background 1s, color 1s, border 1s;\n");
      out.write("            transition: background 1s, color 1s, border 1s;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .btn-success:hover,\n");
      out.write("        .btn-danger:hover {\n");
      out.write("            background-color: #eee;\n");
      out.write("            color: rgb(26, 25, 25);\n");
      out.write("            border: 1px solid rgb(26, 25, 25);\n");
      out.write("        }\n");
      out.write("        /***********************************************************************************************************************************************/\n");
      out.write("        \n");
      out.write("       .well {\n");
      out.write("            background-color: rgb(26, 25, 25);\n");
      out.write("            border: none;\n");
      out.write("            color: #eee;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
  
            session=request.getSession();
            session.setAttribute("bank", "KB");
            session.setAttribute("receiver_acc", "1234567");
        
      out.write("\n");
      out.write("        <div class=\"PageHead text-center\">\n");
      out.write("            <br>\n");
      out.write("            <h1 style=\"font-size:6em;\">Welcome</h1>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <nav class=\"navbar navbar-inverse\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#Tabs\">\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span> \n");
      out.write("                        </button>\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\">Zambezi Home</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"Tabs\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                            <li><a href=\"#\">Orders</a></li>\n");
      out.write("                            <li><a href=\"#\">Wishlist</a></li>\n");
      out.write("                            <li><a href=\"#\">Cart</a></li>\n");
      out.write("                            <!--<li><a href=\"#\">Tab 4</a></li>-->\n");
      out.write("                            <li><a href=\"#\">Log-out</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <button class=\"btn btn-success navbar-btn navbar-right\" data-toggle=\"modal\" data-target=\"#MyModal\" id=\"register\"><span class=\"glyphicon glyphicon-user\"></span> CHECKOUT</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"MyModal\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog modal-lg\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <!--<center><img src=\"C:\\Users\\Shashwat Kadam\\Desktop\\Web Development\\AXIS\\AxisLogo.png\" width=\"580px\" height=\"170px\"></center>-->\n");
      out.write("                        <h3>Total Amount = 1200</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form role=\"form\" id=\"login\" method=\"post\" action=\"redirect_page\">\n");
      out.write("                            <input type=\"hidden\" name=\"amount\" value=\"1200\">\n");
      out.write("                            <input type=\"hidden\" name=\"merchant_name\" value=\"kbd_online_shopping\">\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <div class=\"col-lg-8\">\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-lg btn-block btn-success\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-ok\"></span> <b>Make Payment</b>\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-4\">\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-lg btn-block btn-danger\" data-dismiss=\"modal\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-remove\"></span> <b>CANCEL</b>\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <div class=\"well text-center\"><i></i></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"container-fluid\" style=\"background-color:#460f7e;\">\n");
      out.write("            <div class=\"PageBody\">\n");
      out.write("                <div id=\"test\">\n");
      out.write("                    <div class=\"Display\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-6\">\n");
      out.write("                                <h3>Happy Shopping with KBD </h3>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
