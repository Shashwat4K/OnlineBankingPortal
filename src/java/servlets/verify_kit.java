/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author We_creATe_ThE_WoRLd
 */
public class verify_kit extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String kit=request.getParameter("kitnum");
        String account_number=request.getParameter("acc");
        String U_NAME,PASS;
        System.out.println(account_number);
        System.out.println(kit);
        String table_name="KB"+account_number;
        HttpSession session=request.getSession();
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
            sql="SELECT * FROM ACTIVATION_KIT WHERE KIT = '"+kit + "' AND ACCOUNT_NUMBER = '" + account_number +"'" ;
            ResultSet rs;
            rs=null;
            rs=stmt.executeQuery(sql);
            if(rs.next())
            {
                U_NAME=rs.getString("USER_NAME");
                PASS=rs.getString("PASSWORD");
                //create session for new user
                session.setAttribute("uname", U_NAME);
                session.setAttribute("pass",PASS);
                session.setAttribute("acc",account_number);
                //add details of this new user in the main database
                sql="UPDATE USER_INFO SET USER_NAME = '"+U_NAME+"', PASSWORD = '"+PASS+"' WHERE ACCOUNT_NUMBER = '"+ account_number+"' ";
                stmt.executeUpdate(sql);
                //create table for this new online account
                //sql="CREATE TABLE "+table_name+" (INSTANT DATETIME, PEER VARCHAR(255), PEER_ACC BIGINT, EVENT INT, TRANSFER INT, BALANCE INT)";
                //stmt.executeUpdate(sql);
                sql="DELETE FROM ACTIVATION_KIT WHERE ACCOUNT_NUMBER = '"+account_number+"' ";
                stmt.executeUpdate(sql);
                RequestDispatcher rd = request.getRequestDispatcher("user_home.jsp");
                rd.forward(request, response);
            }
            else
            {
                out.println("<h2>WRONG USERNAME OR PASSWORD</h2>");
                out.println("<h3>PLEASE LOGIN  AGAIN</h3>");
                out.println("<a href=\"signup.jsp\">TRY AGAIN</a>"); 
            }
        }catch(SQLException se){
            //Handle errors for JDBC
            out.println("<h2>WRONG USERNAME OR PASSWORD1</h2>");
            se.printStackTrace();
            out.println(se);
         }catch(Exception e){
            //Handle errors for Class.forName
            out.println("<h2>WRONG USERNAME OR PASSWORD2</h2>");
            e.printStackTrace();
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
