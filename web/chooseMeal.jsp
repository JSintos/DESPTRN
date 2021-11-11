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
	
			<h3 class="mt-3">Choose a set meal:</h3>
	
			<div class="row mt-3">
				<div class="col">
					<div class="card">
						<div class="card-body">
							<h3 class="card-title">J&J 1</h3>

							<p class="card-text mt-3">Includes a sandwich of your choice and a drink of your choice.</p>

							<form action="choosemeal.action" class="mt-3" method="post">
								<input name="setMeal" type="hidden" value="1">
								<button class="btn btn-warning" type="submit">Choose J&J 1</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card">
						<div class="card-body">
							<h3 class="card-title">J&J 2</h3>

							<p class="card-text mt-3">Includes a sandwich of your choice, a drink of your choice, and an extra of your choice.</p>

							<form action="choosemeal.action" class="mt-3" method="post">
								<input name="setMeal" type="hidden" value="2">
								<button class="btn btn-warning" type="submit">Choose J&J 2</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card">
						<div class="card-body">
							<h3 class="card-title">J&J 3</h3>

							<p class="card-text mt-3">Includes a sandwich of your choice and an extra of your choice.</p>

							<form action="choosemeal.action" class="mt-3" method="post">
								<input name="setMeal" type="hidden" value="3">
								<button class="btn btn-warning" type="submit">Choose J&J 3</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card">
						<div class="card-body">
							<h3 class="card-title">J&J 4</h3>

							<p class="card-text mt-3">Includes an extra of your choice.</p>

							<form action="choosemeal.action" class="mt-3" method="post">
								<input name="setMeal" type="hidden" value="4">
								<button class="btn btn-warning" type="submit">Choose J&J 4</button>
							</form>
						</div>
					</div>
				</div>
			</div>
	
			<div class="text-center mt-5 mb-3">
				<small>&copy; 2021 Joshua Lagerejos & Joshua Sintos</small>
			</div>
		</div>
	</body>
</html>