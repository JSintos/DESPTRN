package jandjsandwiches.com.ph.model;

import java.util.ArrayList;

import jandjsandwiches.com.ph.utility.Facade;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class Register implements Facade {
	Meal newMeal;
	int quantity;
	String creditCardNumber;
	
	public Register(Meal newMeal, int quantity, String creditCardNumber) {
		this.newMeal = newMeal;
		this.quantity = quantity;
		this.creditCardNumber = creditCardNumber;
	}

	public Meal getNewMeal() {
		return newMeal;
	}

	public void setNewMeal(Meal newMeal) {
		this.newMeal = newMeal;
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
	
	@Override
	public String processOrder() {
		ArrayList<Item> items = newMeal.getItems();
		
		// Checks whether the meal's item's inventory amount is depleted or less than the inputted quantity
		for(Item item : items) {
			if(InventoryManager.getInventoryAmount(item.getName()) == 0) {
				return "Sorry, we ran out of " + item.getName() + ".";
			}
			else if(InventoryManager.getInventoryAmount(item.getName()) < quantity) {
				return "Sorry, we only have " + InventoryManager.getInventoryAmount(item.getName()) + " pieces left of " + item.getName() + ".";
			}
		}
		
		// Checks whether the inputted credit card number is valid
		if(validateCreditCard(creditCardNumber) && !creditCardNumber.equals("")) {
			SingletonDatabase.insertMeal(newMeal, quantity);
			
			for(Item item : items) {
				InventoryManager.deductInventory(item.getName(), quantity);
			}
			
			return "Success!";
		}
		else {
			return "Invalid credit card number.";
		}
	}
}
