<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<%-- 
    Document   : sendMail
    Created on : Apr 15, 2018, 8:53:35 PM
    Author     : Vibhav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>send mail</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="mail1" scope="session" class="jMail.Mail" />
        <jsp:setProperty name="mail1" property="to" value="<%= (String)session.getAttribute("user_email") %>" />
        <% System.out.println("user email "+(String)session.getAttribute("user_email")); %>
        <jsp:setProperty name="mail1" property="from" value="KBonline1234@gmail.com" />
        <jsp:setProperty name="mail1" property="smtpServ" value="smtp.gmail.com" />
        <jsp:setProperty name="mail1" property="subject" value="OTP" />
        <jsp:setProperty name="mail1" property="message" value="<%= session.getAttribute("otp").toString() %>" />
        <% System.out.println("otp sent ="+session.getAttribute("otp").toString()); %>  
        <%
            
            String to = mail1.getTo();
            System.out.println("111");
            int result;
            result = mail1.sendMail();
            System.out.println("222");
            
            if (result == 0) {
                //out.println(" Mail Successfully Sent to " + to);
                
                response.sendRedirect("otp_form.jsp");
                
            } else {
                
                out.println(" Mail NOT Sent to " + to);
                
            }
            
        %>
    </body>
</html>
