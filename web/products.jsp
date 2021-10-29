<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
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
			ArrayList<Sandwich> sandwichPrototypes = (ArrayList) request.getAttribute("sandwichPrototypes");
			ArrayList<Drink> drinkPrototypes = (ArrayList) request.getAttribute("drinkPrototypes");
			ArrayList<Extra> extraPrototypes = (ArrayList) request.getAttribute("extraPrototypes");
		%>

        <jsp:include page="navbar.jsp">
       		<jsp:param name="activeClass" value="Products" />
       	</jsp:include>

        <div class="container">
            <div>
            	<%

	                if(sandwichPrototypes != null){
	                    Iterator<Sandwich> sandwichPrototypesIterator = sandwichPrototypes.iterator();
	                    
	                    while(sandwichPrototypesIterator.hasNext()){
	                        Sandwich sandwichPrototype = sandwichPrototypesIterator.next();
	                    %>
	                        <div class="card mb-3 h-50">
	                            <div class="row">
                                    <div class="col">
                                        <img alt="<%= sandwichPrototype.getName() %>" class="card-img" src="assets/images/<%= sandwichPrototype.getImageName() %>">
                                    </div>

	                                <div class="col-9">
	                                    <div class="card-body">
	                                        <h3 class="card-title">
                                                <strong><%= sandwichPrototype.getName() %> | Php <%= sandwichPrototype.getPrice() %></strong>
                                            </h3>
	            
	                                        <p class="card-text mt-3"><%= sandwichPrototype.getDescription() %></p>
                                            <p class="card-text mt-3"><small class="text-muted"><%= sandwichPrototype.getIngredients() %></small></p>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    <%
	                    }
	                }
	            
	            %>
            </div>

            <div class="text-center mt-5 mb-3">
                <small>&copy; 2021 Joshua Lagerejos & Joshua Sintos</small>
            </div>
        </div>
    </body>
</html>

