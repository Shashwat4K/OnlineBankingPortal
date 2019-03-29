<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%--<% pageContext.setAttribute("page1","trasaction.jsp");%>--%>
    </head>
    <body>
        <%
            session = request.getSession();
            RequestDispatcher rd = request.getRequestDispatcher("transaction_receipt.jsp");
            String otp_entered = request.getParameter("otp").toString();
            String otp_sent =  session.getAttribute("otp").toString();
            String JDBC_driver = "com.mysql.jdbc.Driver";
            String DB_url = "jdbc:mysql://localhost/kb_db";
            String DB_user = "root";
            String DB_pass = "";
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName(JDBC_driver);
                conn = DriverManager.getConnection(DB_url, DB_user, DB_pass);
                stmt = conn.createStatement();
            } catch (SQLException se) {
                System.out.println("EXCEPTION!!");
            }

            if (otp_entered.equals(otp_sent)) {
                String table_user;
                String bank = (String) session.getAttribute("bank");
                int amount = Integer.parseInt(session.getAttribute("amount").toString());
                String account_num = session.getAttribute("acc").toString();
                String sql = "SELECT * FROM USER_INFO WHERE ACCOUNT_NUMBER = " + account_num;
                String receiver_acc =  session.getAttribute("receiver_acc").toString();
                String receiver_name = (String) session.getAttribute("receiver_name");
                String user = (String) session.getAttribute("person_name");
                String user_acc = session.getAttribute("acc").toString();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                float balance = rs.getFloat("BALANCE");
                if (balance > amount)//this statement is to be removed afterwards
                {
                    if (bank.equals("KB")) {
                        sql = "SELECT * FROM USER_INFO WHERE ACCOUNT_NUMBER ='" + receiver_acc + "'";
                        rs = stmt.executeQuery(sql);
                        if (rs.next()) {
                            balance -= amount;

                            //fetch receiver balance 
                            int rec_bal = Integer.parseInt(rs.getString("BALANCE"));
                            rec_bal += amount;
                            //update BALANCE of row where ACCOUNT_NUMBER = receiver_acc with rec_bal
                            sql = "UPDATE USER_INFO SET BALANCE='" + rec_bal + "' WHERE ACCOUNT_NUMBER='" + receiver_acc + "'";
                            //stmt.executeQuery(sql);
                            stmt.executeUpdate(sql);
                            sql = "UPDATE USER_INFO SET BALANCE='" + balance + "' WHERE ACCOUNT_NUMBER='" + user_acc + "'";
                            //stmt.executeQuery(sql);
                            stmt.executeUpdate(sql);
                            session.setAttribute("balance", balance);
                            table_user = "KB" + session.getAttribute("acc");
                            String table_peer = "KB" + receiver_acc;
                            //Date d = new Date();
                            //insert int table table_user a new row with date d, peer_name receiver_name, peer_acc = reciever_acc, event = -1,transaction = ammount and balance = balance 
                            //insert int table  a new row with date d, peer_name = user , peer_acc = user_acc , event = 1,transaction = ammount and balance = rec_bal
                            double transaction_num = Math.random() * 100000;
                         
                            sql = "INSERT INTO " + table_user + " (`TRANSACTION_ID`,`INSTANT`, `PEER`, `PEER_ACC`, `EVENT`, `TRANSFER`,`BALANCE`) VALUES ( '" + (int) transaction_num + "', NOW(), '" + receiver_name + "', '" + receiver_acc + "', '-1', '" + amount + "', '" + balance + "')";
                            stmt.executeUpdate(sql);
                            session.setAttribute("transaction_id", transaction_num);
                            sql = "INSERT INTO `" + table_peer + "` (`TRANSACTION_ID`,`INSTANT`, `PEER`, `PEER_ACC`, `EVENT`, `TRANSFER`,`BALANCE`) VALUES ( '" + (int) transaction_num + "', NOW(), '" + user + "', '" + user_acc + "', '+1', '" + amount + "', '" + rec_bal + "')";
                            stmt.executeUpdate(sql);

                            session.setAttribute("complete", "1");
                            rd.forward(request, response);
                        } else {
                            session.setAttribute("complete", "0");
                            rd.forward(request, response);
                        }

                    } else {
                        System.out.println("bank name=" + bank);
                        System.out.println("receiver account = " + receiver_acc);
                        sql = "SELECT * FROM OTHER_BANKS WHERE BANK_NAME = '" + bank + "' AND ACCOUNT_NUMBER = '" + receiver_acc + "'";
                        rs = stmt.executeQuery(sql);

                        if (rs.next()) {
                            balance -= amount;
                            System.out.println(rs.getString("BANK_NAME"));
                            sql = "UPDATE USER_INFO SET BALANCE='" + balance + "' WHERE ACCOUNT_NUMBER='" + user_acc + "'";
                            stmt.executeUpdate(sql);
                            System.out.println("111");
                            session.setAttribute("balance", balance);
                            table_user = "KB" + session.getAttribute("acc");
                            String table_peer = "KB" + receiver_acc;
                            //Date d = new Date();
                            //insert int table table_user a new row with date d, peer_name , peer_acc = reciever_acc, event = -1,transaction = ammount and balance = balance 
                            //insert int table  a new row with date d, peer_name = user , peer_acc = user_acc , event = 1,transaction = ammount and balance = rec_bal
                            double transaction_num = Math.random() * 100000;
                         
                            sql = "INSERT INTO " + table_user + " (`TRANSACTION_ID`,`INSTANT`, `PEER`, `PEER_ACC`, `EVENT`, `TRANSFER`,`BALANCE`) VALUES ( '" + (int) transaction_num + "', NOW(), '" + receiver_name + "', '" + receiver_acc + "', '-1', '" + amount + "', '" + balance + "')";
                            stmt.executeUpdate(sql);
                            session.setAttribute("complete", "1");
                            rd.forward(request, response);
                        } else {
                            session.setAttribute("complete", "0");
                            rd.forward(request, response);
                        }

                        //insert int table table_user a new row with date d, peer_name receiver_name, peer_acc = reciever_acc, event = -1,transaction = ammount and balance = balance 
                    }
                }
            } else {

            }


        %>

    </body>
</html>
