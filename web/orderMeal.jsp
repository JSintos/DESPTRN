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
			ArrayList<String> extras = (ArrayList) request.getAttribute("extras");
			
			String setMeal = (String) request.getAttribute("setMeal");
		
		%>
	
		<jsp:include page="navbar.jsp">
       		<jsp:param name="activeClass" value="Order" />
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
			
			<h3 class="mt-3">Choose the items for your set meal:</h3>
			
			<form action="ordermeal.action" class="form-group mt-3" method="post">
				<input name="setMeal" type="hidden" value='<%= setMeal %>'>

				<div class="row">
					<%
						if(setMeal.equals("1")) {
					%>

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

					<%
						} else if(setMeal.equals("2")) {
					%>

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

					<div class="col-3">
						<div class="form-group">
							<select class="form-control" name="extraType">
								<%
									if(extras != null){
										Iterator<String> extrasIterator = extras.iterator();
										
										while(extrasIterator.hasNext()){
											String extra = extrasIterator.next();
										%>
											<option value="<%= extra %>"><%= extra %></option>
										<%
										}
									}
								
								%>
							</select>
						</div>
					</div>

					<%
						} else if(setMeal.equals("3")) {
					%>

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
							<select class="form-control" name="extraType">
								<%
									if(extras != null){
										Iterator<String> extrasIterator = extras.iterator();
										
										while(extrasIterator.hasNext()){
											String extra = extrasIterator.next();
										%>
											<option value="<%= extra %>"><%= extra %></option>
										<%
										}
									}
								
								%>
							</select>
						</div>
					</div>

					<%
						} else if(setMeal.equals("4")) {
					%>

					<div class="col-3">
						<div class="form-group">
							<select class="form-control" name="extraType">
								<%
									if(extras != null){
										Iterator<String> extrasIterator = extras.iterator();
										
										while(extrasIterator.hasNext()){
											String extra = extrasIterator.next();
										%>
											<option value="<%= extra %>"><%= extra %></option>
										<%
										}
									}
								
								%>
							</select>
						</div>
					</div>

					<%
						}
					%>
				</div>

				<div class="row">
					<div class="col-2">
						<div class="form-group">
							<input class="form-control" min="1" name="quantity" placeholder="Set meal quantity" type="number" value="1">
						</div>
					</div>

					<div class="col-3">
						<div class="form-group">
							<input class="form-control" name="creditCardNumber" placeholder="Credit card number" type="text">
						</div>
					</div>

					<div class="col-2">
						<button class="btn btn-warning" type="submit">Order Meal</button>
					</div>
				</div>
			</form>
	
			<div class="text-center mt-5 mb-3">
				<small>&copy; 2021 Joshua Lagerejos & Joshua Sintos</small>
			</div>
		</div>
	</body>

	<%
		if(request.getAttribute("errorMessage") != null){
	%>
		<script>alert('<%= request.getAttribute("errorMessage") %>');</script>
	<%
		}
	%>
</html>