<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>J & J Sandwiches</title>
</head>
<body>
	<h1>Welcome to J & J Sandwiches!</h1>
	
	<p>Here are the details of your ordered sandwich:</p>
	<br>
	<p>Name: ${newSandwich.name}</p>
	<p>Description: ${newSandwich.description}</p>
	<p>Price: ${newSandwich.price}</p>
	<p>Ingredients: ${newSandwich.ingredients}</p>
	<p>Calorie Count: ${newSandwich.calorieCount}</p>
	
	<form action="index.jsp">
		<input type="submit" value="< GO BACK"/>
	</form>
</body>
</html>