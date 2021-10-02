package jandjsandwiches.com.ph.utility;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.AmericanSub;
import jandjsandwiches.com.ph.model.sandwich.Bacon;
import jandjsandwiches.com.ph.model.sandwich.BaconEggCheese;
import jandjsandwiches.com.ph.model.sandwich.BagelToast;
import jandjsandwiches.com.ph.model.sandwich.BakedBean;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class SandwichFactory implements AbstractFactory {
	public Sandwich createSandwich(String sandwichType) {
		Sandwich sandwich = null;
		
		switch(sandwichType) {
			case "American sub":
				sandwich = new AmericanSub();
				break;
			case "Bacon":
				sandwich = new Bacon();
				break;
			case "Bacon, egg, and cheese":
				sandwich = new BaconEggCheese();
				break;
			case "Bagel toast":
				sandwich = new BagelToast();
				break;
			case "Baked bean":
				sandwich = new BakedBean();
		}
		
		return sandwich;
	}

	@Override
	public Drink createDrink(String drinkType) {
		return null;
	}
}
