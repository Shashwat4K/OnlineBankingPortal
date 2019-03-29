<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <%
            session=request.getSession();
        %>
        <title>Welcome <%= session.getAttribute("person_name") %></title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>Welcome <%= session.getAttribute("person_name") %></h1>
            <p>Thanks for doing transaction with KB bank</p>
            
        </div>
        <div class="navigation-bar">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Internet Banking</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="Dashboard.jsp">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="logout.jsp" id="login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <br>
        
        
        <%
            session=request.getSession();
            
            if(session.getAttribute("complete").equals("1"))
            {
                out.print("TRANSACTION SUCCESSFUL");
                out.print("<br><br>");
                out.print("TRANSCATION ID : "+session.getAttribute("transaction_id").toString()+"<br>");
                
                out.print("PEER : "+session.getAttribute("receiver_name")+"<br>");
                
                out.print("PEER ACCOUNT : "+ session.getAttribute("receiver_acc").toString()+"<br>");
                
                
                out.print("TRANSFER AMOUNT : "+session.getAttribute("amount")+"<br>");
                out.print("BALANCE : "+session.getAttribute("balance")+"<br><br>");
                
            }
            else
            {
                out.print("TRANSACTION UNSUCCESSFUL");
            }
        
        
        %>
        
        
    </body>
</html>
