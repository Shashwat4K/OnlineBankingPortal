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
        <title>Welcome <% request.getParameter("name");%></title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
        <style>
            /*.navbar{
                font-size: 1.5em;
                border-radius: 0px;
                letter-spacing: 1px;
            }*/
        </style>
        <script>
            function validate() {

            }


            function change() {
                var preview = document.querySelector('img');
                var file = document.querySelector('input[type=file]').files[0]; //sames as here
                var reader = new FileReader();

                reader.onloadend = function () {
                    preview.src = reader.result;
                }

                if (file) {
                    reader.readAsDataURL(file); //reads the data as a URL
                } else {
                    preview.src = "http://s3.amazonaws.com/37assets/svn/765-default-avatar.png";
                }
            }





        </script>    

    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>Welcome to the Official Website of KB Bank</h1>
            <p>Security For You, Service For Us</p>
        </div>
        <%
            session=request.getSession();
        %>
        <div class="navigation-bar">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="Dashboard.jsp">Home</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="Profile.jsp">Edit Profile</a></li>
                        <li><a href="Moneytransfer.jsp">Money Transfer</a></li>
                        <li><a href="AccountDetails">Account Details</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">  
                        <li><a href="logout.jsp" id="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    </ul>
                </div>
            </nav>
        </div>

        <div class="profile">
            <div class="container">
                <div class="container text-center">
                    <h1 style="font-size: 3em;font-family: 'Titillium Web', sans-serif;">Update Your Profile</h1>
                </div>   
                <br>

                <div class="row">
                    <form method="post" onsubmit="return validate()" action="UpdateDetails">
                        <div class="col-lg-8">
                            <fieldset>
                                <legend>Personal Information</legend>
                                <label for="username">User Name:</label>
                                <input id="username" class="form-control" type="text" name="uname"  placeholder="<%= session.getAttribute("uname") %>"><br>
                                <label for="npass">New Password:</label>
                                <input id="npass" class="form-control" type="password" name="npass"><br>
                                <label for="rnpass">Re-enter New Password:</label>
                                <input id="rnpass" class="form-control" type="password" name="rnpass"><br>
                            </fieldset>
                            <br>
                            <fieldset>
                                <legend>Contact Information</legend>
                                <label for="Email">E-Mail:</label>
                                <input id="Email" class="form-control" type="email" name="email" placeholder="<%= session.getAttribute("user_email")%>"><br>
                                <label for="contact">Contact Number</label>
                                <input id="contact" class="form-control" type="number" name="phone" placeholder="<%= session.getAttribute("phone")%>"><br>

                            </fieldset>

                            <br>
                            <div class="row">
                                <div class="col-lg-6">
                                    <button class="btn btn-lg btn-success" type="submit" style="float:right;width:4.5cm;" >Confirm Update</button>
                                </div>
                                <div class="col-lg-6">
                                    <button type="reset" class="btn btn-lg btn-danger" style="float:left;width:4.5cm;">Reset</button>
                                </div>
                            </div>    
                        </div>  

                        <div class="col-lg-4">
                            <div class="sidebar">
                                
                            </div>
                        </div>
                </div>
                </form>    
            </div>    
        </div>
    </div>
    <br>
    <br>
</body>
</html>
