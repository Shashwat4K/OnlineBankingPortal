<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% session = request.getSession();
            session.setAttribute("online_payment", "0");
            
            System.out.println("inside dashboard");
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Welcome <%= request.getParameter("uname") %></title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        
        <div class="jumbotron text-center">
            <h1>Welcome <%= session.getAttribute("person_name") %></h1>
            <p>Security For You, Service For Us</p>
            
        </div>
        <div class="navigation-bar">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#"><%= session.getAttribute("person_name") %></a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="Profile.jsp">Edit Profile</a></li>
                        <li><a href="Moneytransfer.jsp">Money Transfer</a></li>
                        <li><a href="mpassbook.jsp">Account Details</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li><a href="logout.jsp" id="login"><span class="glyphicon glyphicon-log-out"></span> Log-out</a></li>
                    </ul>
                </div>
                    
            </nav>
        </div>
                    <h1>Welcome <%= session.getAttribute("person_name") %></h1>
                    <h1>BALANCE :  <%= session.getAttribute("balance") %></h1>
    </body>
</html>
