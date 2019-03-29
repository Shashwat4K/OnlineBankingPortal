package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class mpassbook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>mPassbook</title>\n");
      out.write("         ");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            session = request.getSession();
            
            
            String JDBC_driver="com.mysql.jdbc.Driver";
            String DB_url="jdbc:mysql://localhost/kb_db";
            String DB_user="root";
            String DB_pass="";
            Connection conn=null;
            Statement stmt=null;
            try
            {
                Class.forName(JDBC_driver);
                conn=DriverManager.getConnection(DB_url,DB_user,DB_pass);
                stmt=conn.createStatement();   
            }
            catch(SQLException se)
            {
                System.out.println("EXCEPTION!!");
            }
            String acc_num =(String)session.getAttribute("acc");
            String sql = "SELECT * FROM KB"+acc_num+" ORDER BY INSTANT";
            
            sql = "SELECT * FROM KB"+acc_num;
            ResultSet rs=stmt.executeQuery(sql);
            int i=1;
           
            while(rs.next())
            {
                out.print(i+"\t");
                out.print(rs.getInt("TRANSACTION_ID")+"\t");
                out.print(rs.getString("INSTANT")+"\t");
                out.print(rs.getString("PEER")+"\t");
                out.print(rs.getString("PEER_ACC")+"\t");
                int event = rs.getInt("EVENT");
                if(event==-1)
                {
                    out.print("DEBIT \t");
                }
                else
                {
                    out.print("CREDIT \t");
                }
                out.print(rs.getInt("TRANSFER")+"\t");
                out.print(rs.getInt("BALANCE")+"\t");
                out.print("\n");
                i++;
            }
         
      out.write("\n");
      out.write("         \n");
      out.write("    </body>\n");
      out.write("</html>");
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
