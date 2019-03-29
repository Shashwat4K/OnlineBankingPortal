package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class transaction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         ");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            
            
            
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
            catch(SQLException se){
                out.println("EXCEPTION!!");
            }           
            String bank = request.getParameter("bankname");
            int amount = Integer.parseInt(request.getParameter("amt"));
            String sql = "SELECT * FROM `user_info` WHERE `ACCOUNT_NUMBER`= '"+session.getAttribute("acc").toString()+"'";
            String receiver_acc = request.getParameter("accnum");
            String receiver_name = request.getParameter("receiver");
            String user = session.getAttribute("person_name").toString();
            String user_acc = session.getAttribute("user_acc").toString();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(user);
            System.out.println(user_acc);
            //pass the sql query and get the balance in variable balance
            
            int balance = Integer.parseInt(rs.getString("BALANCE"));
            if(balance>amount)//this statement is to be removed afterwards
            {
                if(bank.equals("KB"))
                {
                    sql="SELECT * FROM `user_info` WHERE `ACCOUNT_NUMBER`='"+receiver_acc+"'";
                      rs = stmt.executeQuery(sql);
                      if(rs.next())
                      {
                        
                        balance -= amount;
                        //fetch receiver balance 
                        int rec_bal= Integer.parseInt(rs.getString("BALANCE"));
                        rec_bal += amount;
                        //update BALANCE of row where ACCOUNT_NUMBER = receiver_acc with rec_bal
                        sql = "UPDATE `user_info` SET `BALANCE`='"+rec_bal+"' WHERE `user_info`.`ACCOUNT_NUMBER`="+receiver_acc;
                        //stmt.executeQuery(sql);
                        stmt.executeUpdate(sql);
                        sql = "UPDATE `user_info` SET `BALANCE`='"+balance+"' WHERE `user_info`.`ACCOUNT_NUMBER`="+user_acc;
                        //stmt.executeQuery(sql);
                        stmt.executeUpdate(sql);
                        String table_user = "KB"+session.getAttribute("acc");
                        String table_peer = "KB"+receiver_acc;
                        Date d = new Date();
                        //insert int table table_user a new row with date d, peer_name receiver_name, peer_acc = reciever_acc, event = -1,transaction = ammount and balance = balance 
                        //insert int table  a new row with date d, peer_name = user , peer_acc = user_acc , event = 1,transaction = ammount and balance = rec_bal
                        sql = "INSERT INTO `"+table_user+"` (`INSTANT`, `PEER`, `PEER_ACC`, `EVENT`, `TRANSFER`,`BALANCE`) VALUES ('"+d.toInstant()+"', '"+receiver_name +"', '"+receiver_acc+"', '-1', '"+amount+"', '"+balance+"')";
                        stmt.executeUpdate(sql);
                        sql = "INSERT INTO `"+table_peer+"` (`INSTANT`, `PEER`, `PEER_ACC`, `EVENT`, `TRANSFER`,`BALANCE`) VALUES ('"+d.toInstant()+"', '"+user +"', '"+user_acc+"', '+1', '"+amount+"', '"+rec_bal+"')";
                        stmt.executeUpdate(sql);
                        out.println("Transaction successfull");
                      
                    }
                        else
                        {
                            out.println("Incorrect account number entered");
                        }
                        
                }
                else
                {
                    /*
                      sql="row with ACCOUNT_NUMBER = receiver_acc && bank_name = bank ";
                      rs = stat.executeQuery(sql);
                      if(rs.next())
                    { */ 
                         balance -= amount;
                         //update BALANCE of row where ACCOUNT_NUMBER = receiver_acc with rec_bal
                         String table_user = "KB"+session.getAttribute("acc");
                         Date d = new Date();
                         //insert int table table_user a new row with date d, peer_name receiver_name, peer_acc = reciever_acc, event = -1,transaction = ammount and balance = balance 
                         out.println("Transaction successfull");
                 /* }*/
                          //else
                        {
                            out.println("Incorrect account number entered");
                        }
                     
                }
            }
            else
            {
                out.print("Not enough balance for transaction");
            }
            
        
      out.write("\n");
      out.write("        \n");
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
