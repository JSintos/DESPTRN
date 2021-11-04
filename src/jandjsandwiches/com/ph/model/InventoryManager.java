package jandjsandwiches.com.ph.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class InventoryManager {
	private static String determineProduct(String type) {
		if(SingletonDatabase.retrieveSandwiches().contains(type)) {
			return "sandwiches";
		}
		else if(SingletonDatabase.retrieveDrinks().contains(type)) {
			return "drinks";
		}
		else {
			return "extras";
		}
	}
	
	// Returns the specified product's inventory amount
	public static int getInventoryAmount(String type) {
		try {
			if(SingletonDatabase.getConnection() != null) {
				String query = "SELECT inventoryAmount FROM " + determineProduct(type) + " WHERE name = ?";
				
				PreparedStatement preparedStatement = SingletonDatabase.getConnection().prepareStatement(query);
				
				preparedStatement.setString(1, type);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					return resultSet.getInt("inventoryAmount");
				}
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		
		return -1;
	}
	
	// Deducts the specified product's inventory amount by the quantity ordered by the user
	public static void deductInventory(String type, int quantity) {
		int currentInventoryAmount = getInventoryAmount(type);
		
		try {
			if(SingletonDatabase.getConnection() != null) {
				String query = "UPDATE " + determineProduct(type) + " SET inventoryAmount = ? WHERE name = ?";
				
				PreparedStatement preparedStatement = SingletonDatabase.getConnection().prepareStatement(query);
				
				preparedStatement.setInt(1, currentInventoryAmount - quantity);
				preparedStatement.setString(2, type);
				
				preparedStatement.executeUpdate();
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
}
