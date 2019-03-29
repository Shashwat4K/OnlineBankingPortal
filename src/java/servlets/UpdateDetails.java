package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author We_creATe_ThE_WoRLd
 */
public class UpdateDetails extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            RequestDispatcher rd=request.getRequestDispatcher("Dashboard.jsp");
            String account_number=session.getAttribute("acc").toString();
            String user_name=request.getParameter("uname");
            String new_pass=request.getParameter("npass");
            String rn_pass=request.getParameter("rnpass");
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");
            ResultSet rs=null;
            String JDBC_driver="com.mysql.jdbc.Driver";
            String DB_url="jdbc:mysql://localhost/kb_db";
            String DB_user="root";
            String DB_pass="";
            Connection conn=null;
            Statement stmt=null;
            try
            {
                try
                {
                    Class.forName(JDBC_driver);
                }
                catch(ClassNotFoundException e)
                {
                    
                }
                conn=DriverManager.getConnection(DB_url,DB_user,DB_pass);
                stmt=conn.createStatement();
                String sql;
                if(!user_name.equals(""))
                {
                    sql="UPDATE USER_INFO SET USER_NAME='"+user_name+"' WHERE ACCOUNT_NUMBER = '"+account_number+"'";
                    stmt.executeUpdate(sql);
                }
                if(!new_pass.equals(""))
                {
                    if(new_pass.equals(rn_pass))
                    {
                        sql="UPDATE USER_INFO SET PASSWORD='"+new_pass+"' WHERE ACCOUNT_NUMBER = '"+account_number+"'";
                        stmt.executeUpdate(sql);
                    }
                }
                if(!phone.equals(""))
                {
                    sql="UPDATE USER_INFO SET PHONE='"+phone+"' WHERE ACCOUNT_NUMBER = '"+account_number+"'";
                    stmt.executeUpdate(sql);
                }
                if(!email.equals(""))
                {
                    sql="UPDATE USER_INFO SET EMAIL='"+email+"' WHERE ACCOUNT_NUMBER = '"+account_number+"'";
                    stmt.executeUpdate(sql);
                }
                rd.forward(request, response);
            }
            catch(SQLException se)
            {
                System.out.println(se);
            }
            
            
            
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
