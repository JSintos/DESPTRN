package jandjsandwiches.com.ph.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SingletonDatabase.createTables(getServletContext().getInitParameter("jdbcDriver"), 
								       getServletConfig().getInitParameter("jdbcUrl"), 
								       getServletConfig().getInitParameter("dbUsername"), 
								       getServletConfig().getInitParameter("dbPassword"));
		
		SingletonDatabase.populateTables();
		
		ArrayList<String> sandwiches = SingletonDatabase.retrieveSandwiches();
		ArrayList<String> drinks = SingletonDatabase.retrieveDrinks();
		
		request.setAttribute("sandwiches", sandwiches);
		request.setAttribute("drinks", drinks);
		request.getRequestDispatcher("chooseMeal.jsp").forward(request, response);
	}
}
