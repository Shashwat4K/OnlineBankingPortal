<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%-- 
    Document   : otp_form
    Created on : 16 Apr, 2018, 12:19:14 AM
    Author     : We_creATe_ThE_WoRLd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html lang="en">
    <head>
        <title>OTP Verification</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
                    

                    
                    <form class="login100-form validate-form" action="transaction.jsp" method="POST">
                        <span class="login100-form-title p-b-33">
                            Enter OTP
                        </span>

                        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                            <input class="input100"  name="otp" >
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>



                        <div class="container-login100-form-btn m-t-20">
                            <button type="submit" class="login100-form-btn">
                                Submit
                            </button>
                        </div>


                    </form>


                </div>
            </div>
        </div>

    </body>
</html>