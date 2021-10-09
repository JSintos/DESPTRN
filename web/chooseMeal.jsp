<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

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
		<%
			ArrayList<String> sandwiches = (ArrayList) request.getAttribute("sandwiches");
			ArrayList<String> drinks = (ArrayList) request.getAttribute("drinks");
		%>

		<nav class="navbar navbar-expand-lg navbar-light bg-green">
			<div class="container">
				<a class="navbar-brand" href="/">
					<img alt="Navbar brand" height="75" width="75" src="assets/images/navbar-brand.png">
				</a>
				<button aria-controls="mainNavbar" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" data-target="#mainNavbar" data-toggle="collapse" type="button">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="mainNavbar">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
                            <a class="nav-link" href="/">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link"  href="/products">Products</a>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="/choosemeal">Order</a>
                        </li>
					</ul>
				</div>
			</div>
		</nav>

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
	
			<h3 class="mt-3">Choose a sandwich:</h3>
	
			<form action='choosemeal.action' class="form-group mt-3" method="post">
				<div class="row">
					<div class="col-3">
						<div class="form-group">
							<select class="form-control" name="sandwichType">
								<%

									if(sandwiches != null){
										Iterator<String> sandwichesIterator = sandwiches.iterator();
										
										while(sandwichesIterator.hasNext()){
											String sandwich = sandwichesIterator.next();
										%>
											<option value="<%= sandwich %>"><%= sandwich %></option>
										<%
										}
									}
								
								%>
							</select>
						</div>
					</div>
					
					<div class="col-3">
						<div class="form-group">
							<select class="form-control" name="drinkType">
								<%

									if(drinks != null){
										Iterator<String> drinksIterator = drinks.iterator();
										
										while(drinksIterator.hasNext()){
											String drink = drinksIterator.next();
										%>
											<option value="<%= drink %>"><%= drink %></option>
										<%
										}
									}
								
								%>
							</select>
						</div>
					</div>

					<div class="col-2">
						<button class="btn btn-warning" type="submit">Order Meal</button>
					</div>
				</div>
			</form>
	
			<div class="fixed-bottom text-center mb-3">
				<small>&copy; 2021 Joshua Lagerejos & Joshua Sintos</small>
			</div>
		</div>
	</body>
</html>