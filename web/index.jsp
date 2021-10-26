<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>

    <html>
        <head>
            <meta charset = "utf-8">
            <meta content = "width=device-width, initial-scale=1.0" name = "viewport">
            <meta content = "ie-edge" http-equiv = "X-UA-Compatible">
        
            <link href = "assets/css/bootstrap.min.css" rel = "stylesheet">
            <link href = "assets/css/index.css" rel = "stylesheet">
            <link href = "assets/css/fonts.css" rel = "stylesheet">
    
            <script src = "assets/js/font-awesome.min.js" type = "text/javascript"></script>
    
            <title>J & J Sandwiches</title>
        </head>
    
        <body>
          	<jsp:include page="navbar.jsp">
          		<jsp:param name="activeClass" value="Home" />
          	</jsp:include>

            <div class="container">
                <div class="card h-50">
                    <div class="row">
                        <div class="col">
                            <img alt="Logo" class="card-img" src="assets/images/logo.png">
                        </div>
    
                        <div class="col-9">
                            <div class="card-body">
                                <h1 class="card-title">Welcome to J & J Sandwiches!</h1>
                                <h5 class="card-text mt-4">Try out our freshly made sandwiches!</h5>
                            </div>
                        </div>
                    </div>
                </div>
        
                <div class="fixed-bottom text-center mb-3">
                    <small>&copy; 2021 Joshua Lagerejos & Joshua Sintos</small>
                </div>
            </div>
        </body>
    </html>

