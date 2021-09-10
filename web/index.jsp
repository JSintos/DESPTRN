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
	
			<form action='choosesandwich.action' class="form-group mt-3" id="sandwichSeect" method="post">
				<div class="row">
					<div class="col-3">
						<div class="form-group">
							<select class="form-control" name="sandwichType">
								<option value="AmericanSub">American Sub</option>
								<option value="Bacon">Bacon</option>
								<option value="BaconEggCheese">Bacon, Egg, and Cheese</option>
								<option value="BagelToast">Bagel Toast</option>
								<option value="BakedBean">Baked Bean</option>
							</select>
						</div>
					</div>

					<div class="col-2">
						<button class="btn btn-warning" type="submit">Order Sandwich</button>
					</div>
				</div>
			</form>
	
			<div class="fixed-bottom text-center mb-3">
				<small>&copy; 2021 Joshua Lagerejos & Joshua Sintos</small>
			</div>
		</div>
	</body>
</html>