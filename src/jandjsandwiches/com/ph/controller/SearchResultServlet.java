package jandjsandwiches.com.ph.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// Handles the search results given an inputted keyword
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		ArrayList<Sandwich> sandwichPrototypes = new ArrayList<Sandwich>();
		ArrayList<Drink> drinkPrototypes = new ArrayList<Drink>();
		ArrayList<Extra> extraPrototypes = new ArrayList<Extra>();

		sandwichPrototypes = SingletonDatabase.getSandwichSearchResults(keyword);
		drinkPrototypes = SingletonDatabase.getDrinkSearchResults(keyword);
		extraPrototypes = SingletonDatabase.getExtraSearchResults(keyword);
		
		request.setAttribute("sandwichPrototypes", sandwichPrototypes);
		request.setAttribute("drinkPrototypes", drinkPrototypes);
		request.setAttribute("extraPrototypes", extraPrototypes);
		
		request.getRequestDispatcher("searchResults.jsp").forward(request, response);
	}
}