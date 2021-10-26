package jandjsandwiches.com.ph.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jandjsandwiches.com.ph.model.Register;
import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.utility.DrinkFactory;
import jandjsandwiches.com.ph.utility.SandwichFactory;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class ChooseMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sandwichType = request.getParameter("sandwichType");
		String drinkType = request.getParameter("drinkType");
		
		String sandwichQuantity = request.getParameter("sandwichQuantity");
		String drinkQuantity = request.getParameter("drinkQuantity");
		
		String creditCardNumber = request.getParameter("creditCardNumber");
		
		Sandwich newSandwich = new SandwichFactory().createSandwich(sandwichType);
		Drink newDrink = new DrinkFactory().createDrink(drinkType);
		
		Register register = new Register(newSandwich, newDrink, Integer.parseInt(sandwichQuantity), Integer.parseInt(drinkQuantity), creditCardNumber);
		// Order was processed successfully
		if(register.processOrder().equals("Success")) {
			request.setAttribute("newSandwich", newSandwich);
			request.setAttribute("newDrink", newDrink);
			request.setAttribute("sandwichQuantity", sandwichQuantity);
			request.setAttribute("drinkQuantity", drinkQuantity);
			
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
		else {
			// Order was invalid because the specified product's inventory amount is insufficient
			if(register.processOrder().equals("Insufficient inventory amount")) {
				ArrayList<String> sandwiches = SingletonDatabase.retrieveSandwiches();
				ArrayList<String> drinks = SingletonDatabase.retrieveDrinks();
				
				request.setAttribute("sandwiches", sandwiches);
				request.setAttribute("drinks", drinks);
				request.setAttribute("triggerAlert", "Insufficient inventory amount");
				
				request.getRequestDispatcher("chooseMeal.jsp").forward(request, response);
			}
			// Order was invalid because the inputted credit card number is invalid
			else if(register.processOrder().equals("Invalid credit card number")) {
				ArrayList<String> sandwiches = SingletonDatabase.retrieveSandwiches();
				ArrayList<String> drinks = SingletonDatabase.retrieveDrinks();
				
				request.setAttribute("sandwiches", sandwiches);
				request.setAttribute("drinks", drinks);
				request.setAttribute("triggerAlert", "Invalid credit card number");
				
				request.getRequestDispatcher("chooseMeal.jsp").forward(request, response);
			}
		}
	}

}
