package jandjsandwiches.com.ph.utility;

import jandjsandwiches.com.ph.model.drink.BottledWater;
import jandjsandwiches.com.ph.model.drink.Coke;
import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.drink.MountainDew;
import jandjsandwiches.com.ph.model.drink.Royal;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class DrinkFactory implements AbstractFactory {
	public Drink createDrink(String drinkType) {
		Drink drink = null;
		
		switch(drinkType) {
			case "Bottled Water":
				drink = new BottledWater();
				break;
			case "Coke":
				drink = new Coke();
				break;
			case "Mountain Dew":
				drink = new MountainDew();
				break;
			case "Royal":
				drink = new Royal();
		}
		
		return drink;
	}

	@Override
	public Extra createExtra(String extraType) {
		return null;
	}
	
	@Override
	public Sandwich createSandwich(String sandwichType) {
		return null;
	}
}
