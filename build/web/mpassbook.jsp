<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <title>Welcome <%
            session=request.getSession();
            session.getAttribute("person_name"); %></title>

        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">

        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <style>

            .body{
                margin: 2cm 2cm 2cm 2cm;

                padding: 1cm 1cm;

            }

            .balance h1{

                padding: 0.5cm 0.5cm;

                font-size: 8em;

            }

            .transaction table thead,

            .transaction table tbody{

                padding: 14px;

            }

        </style>

    </head>

    <body>

        <div class="jumbotron text-center">
            <%
                session=request.getSession();
            %>
            <h1>Welcome <%= session.getAttribute("person_name") %></h1>

            <p>Security For You, Service For Us</p>

 

        </div>

        <div class="navigation-bar">

            <nav class="navbar navbar-inverse">

                <div class="container-fluid">

                    <div class="navbar-header">

                        <a class="navbar-brand" href="Dashboard.jsp">Home</a>

                    </div>

                    <ul class="nav navbar-nav">

                        <li><a href="Profile.jsp">Profile</a></li>

                        <li><a href="Moneytransfer.jsp">Money Transfer</a></li>

                        <li class="active"><a href="#">Account Details</a></li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">

 

                        <li><a href="logout.jsp" id="login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>

                    </ul>

                </div>

            </nav>

 

            <div class="container">

                <div class="body">

                    <div class="row">

                        <div class="col-lg-8">

                            <div class="balance">

                                <p>Current Balance: </p>

                                <h1><%
                                    session = request.getSession();
                                    out.print(session.getAttribute("balance").toString()); 
                                %></h1>

                            </div>

 

                            <div class="transactions">

                                <%

                                    

 

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

                                    String acc_num = (String) session.getAttribute("acc");

                                    String sql = "SELECT * FROM KB" + acc_num + " ORDER BY INSTANT DESC";

                                    ResultSet rs = stmt.executeQuery(sql);

                                    int i = 1;

                                    out.println("<table class=\'table table-hover\'>");

                                    out.println("<thead><tr><th>Transaction ID</th><th>Peer</th><th>Peer Account Number</th><th>Transferred Amount</th><th>Transaction Type</th><th>Updated Balance</th><th>time of transaction</th></tr></thead>");

                                    out.println("<tbody>");

                                    while (rs.next()) {
                                        if(rs.getString("EVENT").equals("-1"))
                                        {
                                            out.println("<tr><td>" + rs.getString("TRANSACTION_ID") + "</td><td>" + rs.getString("PEER") + "</td><td>" + rs.getString("PEER_ACC") + "</td><td>" + rs.getString("TRANSFER") + "</td><td>Debit</td><td>" + rs.getString("BALANCE") + "</td><td>" + rs.getString("INSTANT") + "</td></tr>"); 
                                        }
                                        else
                                        {
                                            out.println("<tr><td>" + rs.getString("TRANSACTION_ID") + "</td><td>" + rs.getString("PEER") + "</td><td>" + rs.getString("PEER_ACC") + "</td><td>" + rs.getString("TRANSFER") + "</td><td>Credit</td><td>" + rs.getString("BALANCE") + "</td><td>" + rs.getString("INSTANT") + "</td></tr>");
                                        }    
                                         

                                    }

                                    out.println("</tbody>");

                                    out.println("</table>");

                                    /*while (rs.next()) {

 

                                        out.print(i + "\t");

                                        out.print(rs.getInt("TRANSACTION_ID") + "\t");

                                        out.print(rs.getString("INSTANT") + "\t");

                                        out.print(rs.getString("PEER") + "\t");

                                        out.print(rs.getString("PEER_ACC") + "\t");

                                        int event = rs.getInt("EVENT");

                                        if (event == -1) {

                                            out.print("DEBIT \t");

                                        } else {

                                            out.print("CREDIT \t");

                                        }

                                        out.print(rs.getInt("TRANSFER") + "\t");

                                        out.print(rs.getInt("BALANCE") + "\t");

                                        out.print("\n");

                                        i++;

                                    }*/

 

 

                                %>   

                            </div>

                        </div>

                    </div>

                </div>

            </div>   

        </div>

    </body>

</html>

 

 

//

