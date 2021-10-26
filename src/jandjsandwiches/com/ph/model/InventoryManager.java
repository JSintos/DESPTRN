package jandjsandwiches.com.ph.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class InventoryManager {
	// Returns the specified product's inventory amount
	public static int getInventoryAmount(String product, String type) {
		try {
			if(SingletonDatabase.getConnection() != null) {
				String query = "";
				
				if(product.equals("sandwich")) {
					query = "SELECT inventoryAmount FROM sandwiches WHERE name = ?";
				}
				else {
					query = "SELECT inventoryAmount FROM drinks WHERE name = ?";
				}
				
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
	public static void deductInventory(String product, String type, int quantity) {
		int currentInventoryAmount = getInventoryAmount(product, type);
		
		try {
			if(SingletonDatabase.getConnection() != null) {
				String query = "";
				
				if(product.equals("sandwich")) {
					query = "UPDATE sandwiches SET inventoryAmount = ? WHERE name = ?";
				}
				else {
					query = "UPDATE drinks SET inventoryAmount = ? WHERE name = ?";
				}
				
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
