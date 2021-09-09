<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>J & J Sandwiches</title>
</head>
<body>
	<form action='choosesandwich.action' method="post">
		<select name="sandwichType">
			<option value="AmericanSub">AmericanSub</option>
			<option value="Bacon">Bacon</option>
			<option value="BaconEggCheese">BaconEggCheese</option>
			<option value="BagelToast">BagelToast</option>
			<option value="BakedBean">BakedBean</option>
		</select>
		
		<input type="submit" value='Order Sandwich'/>
	</form>
</body>
</html>