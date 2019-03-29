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
        <meta name="viewport" content="width=device-width;initial-scale=1.0">
        <title>KB Bank : Internet Banking</title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .navigation-bar{

            }
            .pagebody{

            }
            .content{

            }
            .sidebar{

            }
        </style>
        <!--<script type="text/javascript">
            $(document).ready(function(){
                $(#login).click(function(){
                    $(#)
                });
            });
        </script>-->
    </head>
    <body>
        <%
            session = request.getSession();
            session.setAttribute("online_payment", "0");
        %>
        <div class="jumbotron text-center">
            <h1>Welcome to the Official Website of KB Bank</h1>
            <p>Security for You, Service for Us</p>
        </div>
        <div class="navigation-bar">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Internet Banking</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="login.jsp" id="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <br>
        <div class="pagebody">
            <div class="container">
                <div class="row">
                    <div class="col-lg-9 content">
                        
                    </div>
                    <div class="col-lg-3 sidebar">

                    </div>
                </div> 
            </div>
        </div>    
        <%
            String invalid="0";
            session.setAttribute("invalid", invalid);
        %>
    </body>
</html>


