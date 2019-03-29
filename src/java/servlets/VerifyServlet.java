package servlets;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
            RequestDispatcher rd1 = request.getRequestDispatcher("otp_servlet");
            RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
            String U_NAME = request.getParameter("uname");
            String PASS = request.getParameter("pass");
            String online_payment=session.getAttribute("online_payment").toString();
            String balance;
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
                String sql;
                sql="SELECT * FROM USER_INFO WHERE USER_NAME = '"+U_NAME + "' AND PASSWORD = '" + PASS +"'" ;
                ResultSet rs;
                rs=null;
                rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    String name123=rs.getString("NAME");
                    session.setAttribute("uname", U_NAME);
                    session.setAttribute("person_name", name123 );
                    session.setAttribute("pass", PASS);
                    session.setAttribute("acc", rs.getString("ACCOUNT_NUMBER"));
                    session.setAttribute("user_email",rs.getString("EMAIL"));
                    session.setAttribute("phone",rs.getString("PHONE"));
                    balance=rs.getString("BALANCE");
                    session.setAttribute("balance", balance);
                    session.setAttribute("invalid","0");
                    if(online_payment.equals("1"))
                    {
                        rd1.forward(request, response);
                    }
                    rd.forward(request,response);
                }
                else
                {
                    session.setAttribute("invalid","1");
                    out.println("<h2>WRONG USERNAME OR PASSWORD</h2>");
                    out.println("<h3>PLEASE LOGIN  AGAIN</h3>");
                    out.println("<a href=\"login.jsp\">TRY AGAIN</a>"); 
                }
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                out.println(se);
             }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
                out.println(e);
             }finally{
                //finally block used to close resources
                try{
                   if(stmt!=null)
                      conn.close();
                }catch(SQLException se){
                }// do nothing
                try{
                   if(conn!=null)
                      conn.close();
                }catch(SQLException se){
                   se.printStackTrace();
                }//end finally try
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
