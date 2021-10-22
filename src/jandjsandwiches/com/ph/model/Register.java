package jandjsandwiches.com.ph.model;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.utility.Facade;
import jandjsandwiches.com.ph.utility.SingletonDatabase;

public class Register implements Facade {
	String creditCardNumber;
	Sandwich newSandwich;
	Drink newDrink;
	int sandwichQuantity, drinkQuantity;
	
	public Register(Sandwich newSandwich, Drink newDrink, int sandwichQuantity, int drinkQuantity, String creditCardNumber) {
		this.newSandwich = newSandwich;
		this.newDrink = newDrink;
		this.sandwichQuantity = sandwichQuantity;
		this.drinkQuantity = drinkQuantity;
		this.creditCardNumber = creditCardNumber;
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Sandwich getNewSandwich() {
		return newSandwich;
	}

	public void setNewSandwich(Sandwich newSandwich) {
		this.newSandwich = newSandwich;
	}

	public Drink getNewDrink() {
		return newDrink;
	}

	public void setNewDrink(Drink newDrink) {
		this.newDrink = newDrink;
	}
	
	public int getSandwichQuantity() {
		return sandwichQuantity;
	}

	public void setSandwichQuantity(int sandwichQuantity) {
		this.sandwichQuantity = sandwichQuantity;
	}

	public int getDrinkQuantity() {
		return drinkQuantity;
	}

	public void setDrinkQuantity(int drinkQuantity) {
		this.drinkQuantity = drinkQuantity;
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
		if(InventoryManager.getInventoryAmount("sandwich", newSandwich.getName()) >= sandwichQuantity &&
		   InventoryManager.getInventoryAmount("drink", newDrink.getName()) >= drinkQuantity) {
			if(validateCreditCard(creditCardNumber) && !creditCardNumber.equals("")) {
				SingletonDatabase.insertMeal(newSandwich, newDrink, sandwichQuantity, drinkQuantity);
				
				InventoryManager.deductInventory("sandwich", newSandwich.getName(), sandwichQuantity);
				InventoryManager.deductInventory("drink", newDrink.getName(), drinkQuantity);

				return "Success";
			}
			else {
				return "Invalid credit card number";
			}
		}
		else {
			return "Insufficient inventory amount";
		}
	}
}
