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
public class otp_servlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd=request.getRequestDispatcher("otp_form.jsp");
            RequestDispatcher rd1=request.getRequestDispatcher("Moneytransfer.jsp");
            RequestDispatcher rd2=request.getRequestDispatcher("transaction_failed.jsp");
            
            HttpSession session=request.getSession();
            System.out.println(session.getId());
            String account_number=(String)session.getAttribute("acc");
            System.out.println("accouny_num = "+account_number);
            ResultSet rs=null;
            String online_payment = session.getAttribute("online_payment").toString();
            System.out.println("online payment = "+online_payment);
            String bank,receiver_acc,receiver_name;
            int amount;
            if(online_payment.equals("0"))
            {
                amount=Integer.parseInt(request.getParameter("amt"));
                bank=request.getParameter("bankname");
                receiver_acc=(String)request.getParameter("accnum");
                receiver_name=request.getParameter("receiver");
            }
            else
            {
                amount=Integer.parseInt(session.getAttribute("amount").toString());
                bank=session.getAttribute("bank").toString();
                receiver_acc=session.getAttribute("receiver_acc").toString();
                receiver_name=session.getAttribute("receiver_name").toString();
            }
            
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
                    System.out.println("class not found");
                }
                
                conn=DriverManager.getConnection(DB_url,DB_user,DB_pass);
                stmt=conn.createStatement();
                String sql;
                sql="SELECT * FROM USER_INFO WHERE ACCOUNT_NUMBER = '"+account_number+"'";
                rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    String user_email=rs.getString("EMAIL");
                    session.setAttribute("user_email", user_email);
                    float balance=rs.getFloat("BALANCE");
                    if(balance>amount)
                    {
                        if(bank.equals("KB"))
                        {
                            sql="SELECT * FROM USER_INFO WHERE ACCOUNT_NUMBER ='"+receiver_acc+"'";
                                rs = stmt.executeQuery(sql);
                                if(rs.next())
                                {
                                    if(online_payment.equals("0"))
                                    {
                                        session.setAttribute("bank", bank);
                                        session.setAttribute("receiver_acc", receiver_acc);
                                        session.setAttribute("receiver_name",receiver_name);
                                        session.setAttribute("amount", amount);
                                    }
                                    
                                    
                                    //send otp
                                    int otp = (int) (Math.random() * 100000);
                                    session.setAttribute("otp",otp);
                                    response.sendRedirect("sendMail.jsp");




                                    //redirect to otp form
                                }
                                else
                                {
                                    //redirect to money transfer
                                    session.setAttribute("complete", "0");
                                    rd2.forward(request, response);
                                }
                        }
                        else
                        {
                            sql="SELECT * FROM OTHER_BANKS WHERE BANK_NAME = '"+ bank +"' AND ACCOUNT_NUMBER = '"+ receiver_acc +"'"; 
                            rs=stmt.executeQuery(sql);

                            if(rs.next())
                            {
                                if(online_payment.equals("0"))
                                    {
                                        session.setAttribute("bank", bank);
                                        session.setAttribute("receiver_acc", receiver_acc);
                                        session.setAttribute("receiver_name",receiver_name);
                                        session.setAttribute("amount", amount);
                                    }
                                else
                                {
                                    
                                }
                                
                                //send otp
                                  
                                  
                                   int otp = (int) (Math.random() * 100000);
                                    session.setAttribute("otp",otp);
                                    response.sendRedirect("sendMail.jsp");
                                  
                                  
                                  
                                //redirect to otp form
                            }
                            else
                            {
                                //redirect to money transfer
                                session.setAttribute("complete", "0");
                                rd2.forward(request, response);
                            }
                        }
                
                    }
                    else
                    {
                        session.setAttribute("complete", "0");
                        rd2.forward(request, response);
                    }
                }
                else
                {
                    session.setAttribute("complete", "0");
                    rd2.forward(request, response);
                }
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
