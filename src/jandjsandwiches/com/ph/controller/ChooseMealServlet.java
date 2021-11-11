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
		request.setAttribute("setMeal", request.getParameter("setMeal"));
		
		request.setAttribute("sandwiches", SingletonDatabase.retrieveSandwiches());
		request.setAttribute("drinks", SingletonDatabase.retrieveDrinks());
		request.setAttribute("extras", SingletonDatabase.retrieveExtras());
		
		request.getRequestDispatcher("orderMeal.jsp").forward(request, response);
	}

}
