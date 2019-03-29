<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>Welcome to the Official Website of KB Bank</h1>
            <p>Security for You, Service for Us</p>

        </div>
        <div class="navigation-bar">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="index.jsp">Internet Bank</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp" id="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <form method="post" action="verify_kit">
                        <fieldset>
                            <legend>Enter Kit Details</legend>
                            <label for="acc">Account Number: </label>
                            <input type="number" class="form-control" name="acc" id="acc" placeholder="Account Number" required><br>
                            <label for="kitNum">Kit Number</label>
                            <input type="number" class="form-control" name="kitnum" id="kitnum" required><br> 
                            <button type="submit" class="btn btn-lg btn-success" name="Signup" >Sign-up</button>
                        </fieldset>
                    </form>
                </div>   
            </div>

        </div>    
    </body>
</html>
