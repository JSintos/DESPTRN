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

/**
 * Servlet implementation class SearchResultServlet
 */
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//search keyword that the user inputed
		String keyword = request.getParameter("keyword");
		
		//pass search input through arraylist then iterator
		
		ArrayList<Sandwich> sandwichPrototypes = new ArrayList<Sandwich>();
		ArrayList<Drink> drinkPrototypes = new ArrayList<Drink>();
		
		//SQL Query, edit into prepared statement
		String sandwichResultQuery = "SELECT * FROM sandwiches WHERE name LIKE ?";
		String drinkResultQuery = "SELECT * FROM drinks WHERE name LIKE ?";
		
		try {
			if(SingletonDatabase.getConnection() != null) {
				PreparedStatement sandwichPreparedStatement = SingletonDatabase.getConnection().prepareStatement(sandwichResultQuery);
				PreparedStatement drinkPreparedStatement = SingletonDatabase.getConnection().prepareStatement(drinkResultQuery);
				
				sandwichPreparedStatement.setString(1, "%" + keyword + "%");
				drinkPreparedStatement.setString(1, "%" + keyword + "%");
				
				System.out.println(sandwichPreparedStatement.toString());
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
		
		request.setAttribute("sandwiches", sandwichPrototypes);
		request.setAttribute("drinks", drinkPrototypes);
		request.getRequestDispatcher("searchResults.jsp").forward(request, response);
		
	}

}
