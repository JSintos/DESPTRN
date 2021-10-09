package jandjsandwiches.com.ph.controller;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.utility.Prototype;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		ArrayList<Sandwich> sandwichPrototypes = new ArrayList<Sandwich>();
		ArrayList<Drink> drinkPrototypes = new ArrayList<Drink>();
		
		String sandwichSearchResultQuery = "SELECT * FROM sandwiches WHERE name LIKE ?";
		String drinkSearchResultQuery = "SELECT * FROM drinks WHERE name LIKE ?";
		
		try {
			if(SingletonDatabase.getConnection() != null) {
				PreparedStatement sandwichPreparedStatement = SingletonDatabase.getConnection().prepareStatement(sandwichSearchResultQuery);
				PreparedStatement drinkPreparedStatement = SingletonDatabase.getConnection().prepareStatement(drinkSearchResultQuery);
				
				sandwichPreparedStatement.setString(1, "%" + keyword + "%");
				drinkPreparedStatement.setString(1, "%" + keyword + "%");
				
				ResultSet sandwichResultSet = sandwichPreparedStatement.executeQuery();
				ResultSet drinkResultSet = drinkPreparedStatement.executeQuery();
				
				while(sandwichResultSet.next()) {
					sandwichPrototypes.add(Prototype.getSandwichPrototype(sandwichResultSet.getString("name")));
				}

				while(drinkResultSet.next()) {
					drinkPrototypes.add(Prototype.getDrinkPrototype(drinkResultSet.getString("name")));
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		request.setAttribute("sandwichPrototypes", sandwichPrototypes);
		request.setAttribute("drinkPrototypes", drinkPrototypes);
		request.getRequestDispatcher("searchResults.jsp").forward(request, response);
	}
}