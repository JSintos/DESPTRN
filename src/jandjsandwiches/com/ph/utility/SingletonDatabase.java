package jandjsandwiches.com.ph.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class SingletonDatabase {
	private static Connection connection;

	private static String jdbcDriver;
	private static String jdbcUrl;
	private static String dbUsername;
	private static String dbPassword;
	
	//Fix Singleton getConnection/getInstance
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
	
	public static Connection getConnection() {
		return (connection != null) ? connection : getInstance();
	}

	public static void createTables(String driver, String url, String username, String password){
		jdbcDriver = driver;
		jdbcUrl = url;
		dbUsername = username;
		dbPassword = password;
		
		try {
			connection = getInstance();

			Statement statement;
			if(connection != null) {
				String sandwichesTableQuery = "CREATE TABLE IF NOT EXISTS sandwiches(sandwichId int NOT NULL AUTO_INCREMENT, name varchar(50), description varchar(300), price double, ingredients varchar(300), calorieCount int, imageName varchar(50), PRIMARY KEY (sandwichId))";
				
				statement = connection.createStatement();
				statement.executeUpdate(sandwichesTableQuery);
				
				String drinksTableQuery = "CREATE TABLE IF NOT EXISTS drinks(drinkId int NOT NULL AUTO_INCREMENT, name varchar(25), price double, imageName varchar(50), PRIMARY KEY (drinkId))";
				
				statement = connection.createStatement();
				statement.executeUpdate(drinksTableQuery);
				
				String mealsTableQuery = "CREATE TABLE IF NOT EXISTS meals(mealId int NOT NULL AUTO_INCREMENT, sandwichName varchar(50), sandwichDescription varchar(300), sandwichPrice double, sandwichIngredients varchar(300), sandwichCalorieCount int, sandwichImageName varchar(50), drinkName varchar(25), drinkPrice double, drinkImageName varchar(50), PRIMARY KEY (mealId))";
				
				statement = connection.createStatement();
				statement.executeUpdate(mealsTableQuery);
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
	
	public static void populateTables() {
		try {
			connection = getInstance();

			Statement statement;
			ResultSet resultSet;
			if(connection != null) {
				String[] sandwiches = {"American sub", "Bacon", "Bacon, egg, and cheese", "Bagel toast", "Baked bean"};
				String[] sandwichesTableQueries = {
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName) VALUES('American sub', 'Traditionally uses sliced turkey breast, ham, roast beef, American or cheddar cheese, chopped or shredded lettuce, tomatoes and green peppers on a roll of bread.', 250, 'Meat, cheese, assorted vegetables, and condiments.', 100, 'americansub.jpg')",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName) VALUES('Bacon', 'Often eaten with ketchup or brown sauce.', 250, 'Bacon, buttered/ toasted bread, and ketchup or brown sauce.', 100, 'bacon.jpg')",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName) VALUES('Bacon, egg, and cheese', 'Breakfast sandwich, usually with fried or scrambled egg.', 250, 'Bacon, eggs, cheese, and buttered/ toasted bread.', 100, 'baconeggcheese.jpg')",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName) VALUES('Bagel toast', 'Pressed, toasted bagel filled with vegetables and cheese and grilled on a sandwich toaster or panini press.', 250, 'Toasted bagel, vegetables, and cheese.', 100, 'bageltoast.jpg')",
						"INSERT INTO sandwiches(name, description, price, ingredients, calorieCount, imageName) VALUES('Baked bean', 'Canned baked beans on white or brown bread, sometimes with butter.', 250, 'Baked beans, garnishes such as lettuces and toppings such as mayonnaise or ketchup.', 100, 'bakedbean.jpg')",
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
						"INSERT INTO drinks(name, price, imageName) VALUES('Bottled Water', 15, 'bottledwater.png')",
						"INSERT INTO drinks(name, price, imageName) VALUES('Coke', 50, 'coke.png')",
						"INSERT INTO drinks(name, price, imageName) VALUES('Mountain Dew', 50, 'mountaindew.png')",
						"INSERT INTO drinks(name, price, imageName) VALUES('Royal', 50, 'royal.png')"
						};
				
				for(int counter = 0; counter < drinks.length; counter++) {
					String drinkSelectQuery = "SELECT * FROM drinks WHERE name = '" + drinks[counter] + "'";
					
					statement = connection.createStatement();
					resultSet = statement.executeQuery(drinkSelectQuery);
					if(resultSet.next() == false) {
						statement.executeUpdate(drinksTableQueries[counter]);
					}
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
	
	public static ArrayList<String> retrieveSandwiches() {
		ArrayList<String> sandwiches = new ArrayList<String>();
		
		try {
			connection = getInstance();
			
			String query = "SELECT name FROM sandwiches";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				sandwiches.add(resultSet.getString("name"));
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return sandwiches;
	}
	
	public static ArrayList<String> retrieveDrinks() {
		ArrayList<String> drinks = new ArrayList<String>();
		
		try {
			connection = getInstance();
			
			String query = "SELECT name FROM drinks";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				drinks.add(resultSet.getString("name"));
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return drinks;
	}
	
	public static void insertMeal(Sandwich newSandwich, Drink newDrink) {
		String query = "INSERT INTO meals(sandwichName, sandwichDescription, sandwichPrice, sandwichIngredients, sandwichCalorieCount, sandwichImageName, drinkName, drinkPrice, drinkImageName) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = getInstance();
			
			if(connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, newSandwich.getName());
				preparedStatement.setString(2, newSandwich.getDescription());
				preparedStatement.setString(3, newSandwich.getPrice());
				preparedStatement.setString(4, newSandwich.getIngredients());
				preparedStatement.setString(5, newSandwich.getCalorieCount());
				preparedStatement.setString(6, newSandwich.getImageName());
				preparedStatement.setString(7, newDrink.getName());
				preparedStatement.setString(8, newDrink.getPrice());
				preparedStatement.setString(9, newDrink.getImageName());
				
				preparedStatement.executeUpdate();
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
}
