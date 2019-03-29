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
        <title>Money Transfer</title>
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            function display() {
                var p = document.getElementById('p1');
                var input = document.getElementById('amt');
                var out = document.getElementById('disp');

                p.style.setProperty("display", "block", "important");

                out.innerHTML = input.value;
            }
        </script>
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
                        <a class="navbar-brand" href="Dashboard.jsp">Home</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li><a href="Profile.jsp">Edit Profile</a></li>
                        <li class="active"><a href="#">Money Transfer</a></li>
                        <li><a href="mpassbook.jsp">Account Details</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">  
                        <li><a href="logout.jsp" id="logout"><span class="glyphicon glyphicon-log-out"></span> Log-out</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="moneyportal">
            <div class="container">
                <form method="post" action="otp_servlet">
                    <div class="row">
                        <div class="col-lg-6">
                            <fieldset>
                                <legend>Details of Receiver</legend>
                                <label for="recipient">Name of Recipient:</label>
                                <input type="text" class="form-control" name="receiver" id="recipient" required><br>
                                <label for="bankname">Name of bank: </label>
                                <select id="bankname" name="bankname" class="form-control">
                                    <option value="null">-Select-</option>
                                    <option value="KB">KB</option>
                                    <option value="AXIS Bank">AXIS Bank</option>
                                    <option value="State Bank of India">State Bank of India</option>
                                    <option value="Bank of India">Bank of India</option>
                                    <option value="ICICI Bank">ICICI Bank</option>
                                </select> 
                                <br>
                                <label for="accnum">Account Number of Recipient</label>
                                <input type="number" class="form-control" name="accnum" id="accnum" required><br>
                            </fieldset>
                        </div>
                        <div class="col-lg-6">
                            <label for="amt">Amount: </label>
                            <input type='number'class="form-control" name="amt" id="amt" onkeyup="display();" required><br>
                            
                        </div>
                    </div> 
                    <br>
                    <div class="text-center">
                        <p id="p1" style="display:none;">Amount to be transferred</p>
                        <h1 id="disp"></h1>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <button type="submit" class="btn btn-lg btn-success  pull-right">Pay</button>
                        </div>
                        <div class="col-lg-6">
                             <button type="reset" class="btn btn-lg btn-danger  pull-left">Reset</button>
                        </div>    
                    </div>    
                    
                       
                </form>    
            </div>
        </div>
        <br><br>
    </body>
</html>
