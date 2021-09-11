package jandjsandwiches.com.ph.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.utility.DrinkFactory;
import jandjsandwiches.com.ph.utility.SandwichFactory;

@WebServlet("/choosemeal.action")
public class ChooseMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sandwichType = request.getParameter("sandwichType");
		String drinkType = request.getParameter("drinkType");
		
		Sandwich newSandwich = new SandwichFactory().createSandwich(sandwichType);
		Drink newDrink = new DrinkFactory().createDrink(drinkType);
		
		request.setAttribute("newSandwich", newSandwich);
		request.setAttribute("newDrink", newDrink);
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
