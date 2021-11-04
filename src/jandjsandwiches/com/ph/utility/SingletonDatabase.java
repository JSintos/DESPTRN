package jandjsandwiches.com.ph.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jandjsandwiches.com.ph.model.Meal;
import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class SingletonDatabase {
	private static Connection connection;

	private static String jdbcDriver;
	private static String jdbcUrl;
	private static String dbUsername;
	private static String dbPassword;
	
	private static Connection getInstance() {
		Connection connection = null;
		
		try {
			Class.forName(jdbcDriver);
			
			connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
		} catch(ClassNotFoundException cfne) {
			System.err.println(cfne.getMessage());
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return connection;
	}
	
	// Singleton implementation of the connection instance
	public static Connection getConnection() {
		return (connection != null) ? connection : getInstance();
	}

	// Creates the required tables needed for the functions to work
	public static void createTables(String driver, String url, String username, String password){
		jdbcDriver = driver;
		jdbcUrl = url;
		dbUsername = username;
		dbPassword = password;
		
		try {
			connection = getInstance();

			Statement statement;
			if(connection != null) {
				String sandwichesTableQuery = "CREATE TABLE IF NOT EXISTS sandwiches(sandwichId int NOT NULL AUTO_INCREMENT, name varchar(50), description varchar(300), price double, ingredients varchar(300), calorieCount int, imageName varchar(50), inventoryAmount int, PRIMARY KEY (sandwichId))";
				
				statement = connection.createStatement();
				statement.executeUpdate(sandwichesTableQuery);
				
				String drinksTableQuery = "CREATE TABLE IF NOT EXISTS drinks(drinkId int NOT NULL AUTO_INCREMENT, name varchar(25), price double, imageName varchar(50), inventoryAmount int, PRIMARY KEY (drinkId))";
				
				statement = connection.createStatement();
				statement.executeUpdate(drinksTableQuery);
				
				String extrasTableQuery = "CREATE TABLE IF NOT EXISTS extras(extraId int NOT NULL AUTO_INCREMENT, name varchar(25), price double, imageName varchar(50), inventoryAmount int, PRIMARY KEY (extraId))";
				
				statement = connection.createStatement();
				statement.executeUpdate(extrasTableQuery);
				
				String mealsTableQuery = "CREATE TABLE IF NOT EXISTS meals(mealId int NOT NULL AUTO_INCREMENT, items varchar(100), totalCost double, quantity int, PRIMARY KEY (mealId))";
				
				statement = connection.createStatement();
				statement.executeUpdate(mealsTableQuery);
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
	
	// Populates the newly created tables with the catalog of products
	public static void populateTables() {
		try {
			connection = getConnection();

			Statement statement;
			ResultSet resultSet;
			if(connection != null) {
				String[] sandwiches = {"American sub", "Bacon", "Bacon, egg, and cheese", "Bagel toast", "Baked bean"};
				String[] sandwichesTableQueries = {
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName, inventoryAmount) VALUES('American sub', 'Traditionally uses sliced turkey breast, ham, roast beef, American or cheddar cheese, chopped or shredded lettuce, tomatoes and green peppers on a roll of bread.', 250, 'Meat, cheese, assorted vegetables, and condiments.', 100, 'americansub.jpg', 100)",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName, inventoryAmount) VALUES('Bacon', 'Often eaten with ketchup or brown sauce.', 250, 'Bacon, buttered/ toasted bread, and ketchup or brown sauce.', 100, 'bacon.jpg', 100)",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName, inventoryAmount) VALUES('Bacon, egg, and cheese', 'Breakfast sandwich, usually with fried or scrambled egg.', 250, 'Bacon, eggs, cheese, and buttered/ toasted bread.', 100, 'baconeggcheese.jpg', 100)",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName, inventoryAmount) VALUES('Bagel toast', 'Pressed, toasted bagel filled with vegetables and cheese and grilled on a sandwich toaster or panini press.', 250, 'Toasted bagel, vegetables, and cheese.', 100, 'bageltoast.jpg', 100)",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName, inventoryAmount) VALUES('Baked bean', 'Canned baked beans on white or brown bread, sometimes with butter.', 250, 'Baked beans, garnishes such as lettuces and toppings such as mayonnaise or ketchup.', 100, 'bakedbean.jpg', 100)",
						};
				
				for(int counter = 0; counter < sandwiches.length; counter++) {
					String sandwichSelectQuery = "SELECT * FROM sandwiches WHERE name = '" + sandwiches[counter] + "'";
					
					statement = connection.createStatement();
					resultSet = statement.executeQuery(sandwichSelectQuery);
					if(resultSet.next() == false) {
						statement.executeUpdate(sandwichesTableQueries[counter]);
					}
				}
				
				String[] drinks = {"Bottled Water", "Coke", "Mountain Dew", "Royal"};
				String[] drinksTableQueries = {
						"INSERT INTO drinks(name, price, imageName, inventoryAmount) VALUES('Bottled Water', 15, 'bottledwater.png', 100)",
						"INSERT INTO drinks(name, price, imageName, inventoryAmount) VALUES('Coke', 50, 'coke.png', 100)",
						"INSERT INTO drinks(name, price, imageName, inventoryAmount) VALUES('Mountain Dew', 50, 'mountaindew.png', 100)",
						"INSERT INTO drinks(name, price, imageName, inventoryAmount) VALUES('Royal', 50, 'royal.png', 100)"
						};
				
				for(int counter = 0; counter < drinks.length; counter++) {
					String drinkSelectQuery = "SELECT * FROM drinks WHERE name = '" + drinks[counter] + "'";
					
					statement = connection.createStatement();
					resultSet = statement.executeQuery(drinkSelectQuery);
					if(resultSet.next() == false) {
						statement.executeUpdate(drinksTableQueries[counter]);
					}
				}
				
				String[] extras = {"5 pieces chicken nuggets", "French fries", "Sundae"};
				String[] extrasTableQueries = {
						"INSERT INTO extras(name, price, imageName, inventoryAmount) VALUES('5 pieces chicken nuggets', 25, 'chickennuggets.png', 100)",
						"INSERT INTO extras(name, price, imageName, inventoryAmount) VALUES('French fries', 25, 'frenchfries.png', 100)",
						"INSERT INTO extras(name, price, imageName, inventoryAmount) VALUES('Sundae', 25, 'sundae.png', 100)",
						};
				
				for(int counter = 0; counter < extras.length; counter++) {
					String extraSelectQuery = "SELECT * FROM extras WHERE name = '" + extras[counter] + "'";
					
					statement = connection.createStatement();
					resultSet = statement.executeQuery(extraSelectQuery);
					if(resultSet.next() == false) {
						statement.executeUpdate(extrasTableQueries[counter]);
					}
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
	
	// Retrieves the list of sandwich products
	public static ArrayList<String> retrieveSandwiches() {
		ArrayList<String> sandwiches = new ArrayList<String>();
		
		try {
			connection = getConnection();
			
			String query = "SELECT name FROM sandwiches";
			
			if(connection != null) {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					sandwiches.add(resultSet.getString("name"));
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return sandwiches;
	}
	
	// Retrieves the list of drink products
	public static ArrayList<String> retrieveDrinks() {
		ArrayList<String> drinks = new ArrayList<String>();
		
		try {
			connection = getConnection();
			
			if(connection != null) {
				String query = "SELECT name FROM drinks";
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					drinks.add(resultSet.getString("name"));
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return drinks;
	}
	
	// Retrieves the list of extra products
	public static ArrayList<String> retrieveExtras() {
		ArrayList<String> extras = new ArrayList<String>();
		
		try {
			connection = getConnection();
			
			if(connection != null) {
				String query = "SELECT name FROM extras";
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					extras.add(resultSet.getString("name"));
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return extras;
	}
	
	// Inserts a meal into the database after processing a valid order
	public static void insertMeal(Meal newMeal, int quantity) {
		String query = "INSERT INTO meals(items, totalCost, quantity) VALUES(?, ?, ?)";
		
		try {
			connection = getConnection();
			
			if(connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, newMeal.getItemList());
				preparedStatement.setDouble(2, newMeal.getTotalCost());
				preparedStatement.setInt(3, quantity);
				
				preparedStatement.executeUpdate();
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
	
	public static ArrayList<Sandwich> getSandwichSearchResults(String keyword) {
		ArrayList<Sandwich> sandwichPrototypes = new ArrayList<Sandwich>();
		String query = "SELECT * FROM sandwiches WHERE name LIKE ?";
		
		try {
			connection = getConnection();
			
			if(connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, "%" + keyword + "%");
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					sandwichPrototypes.add(Prototype.getSandwichPrototype(resultSet.getString("name")));
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return sandwichPrototypes;
	}
	
	public static ArrayList<Drink> getDrinkSearchResults(String keyword) {
		ArrayList<Drink> drinkPrototypes = new ArrayList<Drink>();
		String query = "SELECT * FROM drinks WHERE name LIKE ?";
		
		try {
			connection = getConnection();
			
			if(connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, "%" + keyword + "%");
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					drinkPrototypes.add(Prototype.getDrinkPrototype(resultSet.getString("name")));
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return drinkPrototypes;
	}
	
	public static ArrayList<Extra> getExtraSearchResults(String keyword) {
		ArrayList<Extra> extraPrototypes = new ArrayList<Extra>();
		String query = "SELECT * FROM extras WHERE name LIKE ?";
		
		try {
			connection = getConnection();
			
			if(connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, "%" + keyword + "%");
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					extraPrototypes.add(Prototype.getExtraPrototype(resultSet.getString("name")));
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return extraPrototypes;
	}
}
