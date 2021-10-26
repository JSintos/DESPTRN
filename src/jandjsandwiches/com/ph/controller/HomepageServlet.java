package jandjsandwiches.com.ph.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.utility.Prototype;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creates the required tables needed for the functions to work
		SingletonDatabase.createTables(getServletContext().getInitParameter("jdbcDriver"), 
			       getServletConfig().getInitParameter("jdbcUrl"), 
			       getServletConfig().getInitParameter("dbUsername"), 
			       getServletConfig().getInitParameter("dbPassword"));

		SingletonDatabase.populateTables();
		
		ArrayList<String> sandwiches = SingletonDatabase.retrieveSandwiches();
		ArrayList<String> drinks = SingletonDatabase.retrieveDrinks();
		
		if(request.getServletPath().equals("/products")) {
			ArrayList<Sandwich> sandwichPrototypes = new ArrayList<Sandwich>();
			ArrayList<Drink> drinkPrototypes = new ArrayList<Drink>();
			
			// Populates the array list with the sandwich prototypes
			for(String sandwich : sandwiches) {
				sandwichPrototypes.add(Prototype.getSandwichPrototype(sandwich));
			}
			
			// Populates the array list with the drink prototypes
			for(String drink : drinks) {
				drinkPrototypes.add(Prototype.getDrinkPrototype(drink));
			}
			
			request.setAttribute("sandwichPrototypes", sandwichPrototypes);
			request.setAttribute("drinkPrototypes", drinkPrototypes);
			
			request.getRequestDispatcher("products.jsp").forward(request, response);
		}
		else if(request.getServletPath().equals("/choosemeal")) {
			request.setAttribute("sandwiches", sandwiches);
			request.setAttribute("drinks", drinks);
			
			request.getRequestDispatcher("chooseMeal.jsp").forward(request, response);
		}
	}
}
