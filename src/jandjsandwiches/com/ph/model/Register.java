package jandjsandwiches.com.ph.model;

import java.util.ArrayList;

import jandjsandwiches.com.ph.utility.Facade;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class Register implements Facade {
	Meal meal;
	int quantity;
	String creditCardNumber;
	
	public Register(Meal meal, int quantity, String creditCardNumber) {
		this.meal = meal;
		this.quantity = quantity;
		this.creditCardNumber = creditCardNumber;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public static boolean validateCreditCard(String creditCardNumber) {
		int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(creditCardNumber).reverse().toString();
        
        for(int i = 0; i < reverse.length(); i++) {
            int digit = Character.digit(reverse.charAt(i), 10);
            
            if(i % 2 == 0) { // This is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }
            else { // Add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                
                if(digit >= 5) {
                    s2 -= 9;
                }
            }
        }
        
        return (s1 + s2) % 10 == 0;
	}
	
	public double getTotalCost() {
		ArrayList<Item> items = meal.getItems();
		
		double totalCost = 0.0;
		for(Item item : items) {
			totalCost += Double.parseDouble(item.getPrice());
		}
		
		return totalCost * quantity;
	}
	
	@Override
	public String[] processOrder() {
		ArrayList<Item> items = meal.getItems();
		
		// Checks whether the meal's item's inventory amount is depleted or less than the inputted quantity
		for(Item item : items) {
			if(InventoryManager.getInventoryAmount(item.getName()) == 0) {
				return new String[]{"0", "Sorry, we ran out of " + item.getName() + "."};
			}
			else if(InventoryManager.getInventoryAmount(item.getName()) < quantity) {
				return new String[]{"0", "Sorry, we only have " + InventoryManager.getInventoryAmount(item.getName()) + " pieces left of " + item.getName() + "."};
			}
		}
		
		// Checks whether the inputted credit card number is valid
		if(validateCreditCard(creditCardNumber) && !creditCardNumber.equals("")) {
			SingletonDatabase.insertMeal(meal, getTotalCost(), quantity);
			
			for(Item item : items) {
				InventoryManager.deductInventory(item.getName(), quantity);
			}
			
			return new String[]{"1", "Success!"};
		}
		else {
			return new String[]{"0", "Invalid credit card number."};
		}
	}
}
