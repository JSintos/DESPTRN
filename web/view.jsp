<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="jandjsandwiches.com.ph.model.Meal" %>
<%@ page import="jandjsandwiches.com.ph.model.Item" %>
<%@ page import="jandjsandwiches.com.ph.model.sandwich.Sandwich" %>
<%@ page import="jandjsandwiches.com.ph.model.drink.Drink" %>
<%@ page import="jandjsandwiches.com.ph.model.extra.Extra" %>

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
			Meal meal = (Meal) request.getAttribute("meal");
		
			ArrayList<String> sandwiches = (ArrayList) request.getAttribute("sandwiches");
			ArrayList<String> drinks = (ArrayList) request.getAttribute("drinks");
			ArrayList<String> extras = (ArrayList) request.getAttribute("extras");
		%>
		
		<jsp:include page="navbar.jsp"></jsp:include>

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

			<h3 class="my-4">You have ordered ${quantity} set/s of set meal J&J ${setMeal}:</h3>

			<% DecimalFormat decimalFormat = new DecimalFormat("#0.00"); %>

			<h5 class="my-4">The total cost is Php <%= decimalFormat.format(meal.getTotalCost()) %></h5>

			<div class="row">
				<div class="col-1"></div>
				<%
					Iterator<Item> itemsIterator = meal.getItems().iterator();
				
					while(itemsIterator.hasNext()){
						Item item = itemsIterator.next();
						
						if(sandwiches.contains(item.getName())){
				%>
				
				<div class="col">
					<div class="card mx-auto mt-4" style="width: 23rem;">
						<img alt="<%= item.getName() %>" class="card-img-top" width="50" src="assets/images/<%= item.getImageName() %>">
		
						<div class="card-body">
							<h4 class="card-title"><%= item.getName() %></h4>
		
							<p class="card-text mt-3">Php <%= item.getPrice() %> | <%= item.getCalorieCount() %> calories</p>
							<p class="card-text mt-3"><%= item.getDescription() %></p>
							<p class="card-text"><%= item.getIngredients() %></p>
						</div>
					</div>
				</div>
				
				<% 
					} else if(drinks.contains(item.getName()) || extras.contains(item.getName())){ 
				%>
				
				<div class="col">
					<div class="card mx-auto mt-4" style="width: 23rem;">
						<img alt="<%= item.getName() %>" class="card-img-top" height="445" width="50" src="assets/images/<%= item.getImageName() %>">
		
						<div class="card-body">
							<h4 class="card-title"><%= item.getName() %></h4>
		
							<p class="card-text mt-3">Php <%= item.getPrice() %></p>
						</div>
					</div>
				</div>
				
				<% }} %>
				
				<div class="col-1"></div>
			</div>
			
			<div class="row">
				<form action="choosemeal" class="mx-auto mt-4 mb-2">
					<input class="btn btn-warning" type="submit" value="Buy another meal"/>
				</form>
			</div>
			
			<div class="text-center mt-5 mb-3">
				<small>&copy; 2021 Joshua Lagerejos & Joshua Sintos</small>
			</div>
		</div>
	</body>
</html>