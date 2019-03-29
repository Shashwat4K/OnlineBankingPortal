<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%-- 
    Document   : online_payment
    Created on : 16 Apr, 2018, 1:52:37 AM
    Author     : We_creATe_ThE_WoRLd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Sessions Demo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <style>
            @import url('https://fonts.googleapis.com/css?family=Krona+One');
            .PageHead{
                background-color: #a506df;
                color: #eee; 
                font-family: 'Krona One', sans-serif;
                width: 100%;
                height:200px;
            }
            .PageBody{
                margin: 2cm 3cm 2cm 3cm; 
                
            }
            #test{
                width: 100%;
                
                height: 1050px;
                background-color: white;   
            }
            .Display{
                padding: 0.5cm 2cm 0.5cm 2cm;
            }
            .Display h2{
                font-family: 'Krona One', sans-serif;
                font-size: 3em;
                color:#560688; 
            }
            .Display list-group-item{
                font-size: 2em;
                color:#7306b7;
            }
            
            
        /************************************    Navigation bar Styling    ********************************************************************/
        
        .navbar {
            font-family: 'Monteserrat', sans-serif;
            font-size: 18px;
            margin-bottom: 0;
            background-color: #42045f;
            border: 0;
            font-size: 12px !important;
            line-height: 1.42857143 !important;
            letter-spacing: 4px;
            border-radius: 0;
        }
        
        .navbar li a,
        .navbar .navbar-brand {
            color: #fff !important;
        }
        
        .navbar-nav li a {
            -o-transition: background 1s, color 1s;
            -moz-transition: background 1s, color 1s;
            -webkit-transition: background 1s, color 1s;
            transition: background 1s, color 1s;
        }
        
        .navbar-nav li a:hover,
        .navbar-nav li.active a {
            color: #42045f !important;
            background-color: #fff !important;
        }
        
        .navbar-inverse .navbar-toggle {
            border-color: transparent;
            color: #fff !important;
        }
        
        .navbar-nav li {
            text-align: center;
            font-weight: bold;
        }
        /*************************************************************************************************************************************/
        
        .modal-header,
        .close {
            background: radial-gradient(rgb(2, 65, 153), rgb(5, 103, 240));
            color: #fff !important;
            text-align: center;
            font-size: 30px;
        }
        .modal-header h1{
            font-family: 'Krona One',sans-serif;
            font-size: 3em;
            text-align: center;
        }
        .modal-body {
            background: radial-gradient(rgb(26, 25, 25), rgb(51, 49, 49));
            color: white;
        }
        
        #login {
            font-family: 'Ubuntu', sans-serif;
            font-size: 18px;
        }
        
        .modal-header,
        .modal-body {
            padding: 40px 50px;
        }
        
        .input-lg {
            border-radius: 0px;
        }
        
        /*************************************************   Buttons Styling   *************************************************************************/
        
        #register {
            width: 150px;
        }
        
        .btn-block {
            font-family: 'Montserrat', sans-serif;
        }
        
        .btn-success,
        .btn-danger {
            border-radius: 0px;
            -o-transition: background 1s, color 1s, border 1s;
            -moz-transition: background 1s, color 1s, border 1s;
            -webkit-transition: background 1s, color 1s, border 1s;
            transition: background 1s, color 1s, border 1s;
        }
        
        .btn-success:hover,
        .btn-danger:hover {
            background-color: #eee;
            color: rgb(26, 25, 25);
            border: 1px solid rgb(26, 25, 25);
        }
        /***********************************************************************************************************************************************/
        
       .well {
            background-color: rgb(26, 25, 25);
            border: none;
            color: #eee;
        }
    </style>
    </head>
    <body>
        <%  
            session=request.getSession();
            session.setAttribute("bank", "KB");
            session.setAttribute("receiver_acc", "1234567");
        %>
        <div class="PageHead text-center">
            <br>
            <h1 style="font-size:6em;">Welcome</h1>
        </div>
        <div>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#Tabs">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span> 
                        </button>
                        <a class="navbar-brand" href="#">Zambezi Home</a>
                    </div>
                    <div class="collapse navbar-collapse" id="Tabs">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Orders</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">Cart</a></li>
                            <!--<li><a href="#">Tab 4</a></li>-->
                            <li><a href="#">Log-out</a></li>
                        </ul>
                        <button class="btn btn-success navbar-btn navbar-right" data-toggle="modal" data-target="#MyModal" id="register"><span class="glyphicon glyphicon-user"></span> CHECKOUT</button>
                    </div>
                </div>
            </nav>
        </div>
        <div class="modal fade" id="MyModal" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <!--<center><img src="C:\Users\Shashwat Kadam\Desktop\Web Development\AXIS\AxisLogo.png" width="580px" height="170px"></center>-->
                        <h3>Total Amount = 1200</h3>
                    </div>
                    <div class="modal-body">
                        <form role="form" id="login" method="post" action="redirect_page">
                            <input type="hidden" name="amount" value="1200">
                            <input type="hidden" name="merchant_name" value="kbd_online_shopping">
                            <div class="form-group row">
                                <div class="col-lg-8">
                                    <button type="submit" class="btn btn-lg btn-block btn-success">
                                        <span class="glyphicon glyphicon-ok"></span> <b>Make Payment</b>
                                    </button>
                                </div>
                                <div class="col-lg-4">
                                    <button type="submit" class="btn btn-lg btn-block btn-danger" data-dismiss="modal">
                                        <span class="glyphicon glyphicon-remove"></span> <b>CANCEL</b>
                                    </button>
                                </div>
                            </div>
                            <br>
                        </form>

                        <div class="modal-footer">
                            <div class="well text-center"><i></i></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container-fluid" style="background-color:#460f7e;">
            <div class="PageBody">
                <div id="test">
                    <div class="Display">
                        <div class="row">
                            <div class="col-lg-6">
                                <h3>Happy Shopping with KBD </h3>
                                
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
