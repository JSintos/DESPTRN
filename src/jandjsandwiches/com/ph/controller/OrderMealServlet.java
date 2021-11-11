package jandjsandwiches.com.ph.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jandjsandwiches.com.ph.model.Meal;
import jandjsandwiches.com.ph.model.MealBuilder;
import jandjsandwiches.com.ph.model.Register;
import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.utility.DrinkFactory;
import jandjsandwiches.com.ph.utility.ExtraFactory;
import jandjsandwiches.com.ph.utility.SandwichFactory;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class OrderMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int setMeal = Integer.parseInt(request.getParameter("setMeal"));
		request.setAttribute("setMeal", request.getParameter("setMeal"));
		
		Sandwich newSandwich = null;
		if(request.getParameter("sandwichType") != "" && request.getParameter("sandwichType") != null) {
			String sandwichType = request.getParameter("sandwichType");
			newSandwich = new SandwichFactory().createSandwich(sandwichType);
		}
		
		Drink newDrink = null;
		if(request.getParameter("drinkType") != "" && request.getParameter("drinkType") != null) {
			String drinkType = request.getParameter("drinkType");
			newDrink = new DrinkFactory().createDrink(drinkType);
		}
		
		Extra newExtra = null;
		if(request.getParameter("extraType") != "" && request.getParameter("extraType") != null) {
			String extraType = request.getParameter("extraType");
			newExtra = new ExtraFactory().createExtra(extraType);
		}
		
		String quantity = request.getParameter("quantity");
		request.setAttribute("quantity", request.getParameter("quantity"));
		String creditCardNumber = request.getParameter("creditCardNumber");
		
		Meal newMeal = null;
		switch(setMeal) {
			case 1:
				newMeal = MealBuilder.prepareSetMealOne(newSandwich, newDrink);
				break;
			case 2:
				newMeal = MealBuilder.prepareSetMealTwo(newSandwich, newDrink, newExtra);
				break;
			case 3:
				newMeal = MealBuilder.prepareSetMealThree(newSandwich, newExtra);
				break;
			case 4:
				newMeal = MealBuilder.prepareSetMealFour(newExtra);
		}
		
		Register register = new Register(newMeal, Integer.parseInt(quantity), creditCardNumber);
		// Order was processed successfully
		if(register.processOrder()[0].equals("1")) {
			request.setAttribute("meal", newMeal);
			
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", register.processOrder()[1]);
			
			request.setAttribute("sandwiches", SingletonDatabase.retrieveSandwiches());
			request.setAttribute("drinks", SingletonDatabase.retrieveDrinks());
			request.setAttribute("extras", SingletonDatabase.retrieveExtras());
			
			request.getRequestDispatcher("orderMeal.jsp").forward(request, response);
		}
	}
}
