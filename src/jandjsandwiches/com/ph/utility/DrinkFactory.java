package jandjsandwiches.com.ph.utility;

import jandjsandwiches.com.ph.model.drink.BottledWater;
import jandjsandwiches.com.ph.model.drink.Coke;
import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.drink.MountainDew;
import jandjsandwiches.com.ph.model.drink.Royal;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class DrinkFactory implements AbstractFactory {
	public Drink createDrink(String drinkType) {
		Drink drink = null;
		
		switch(drinkType) {
			case "Coke":
				drink = new Coke();
				break;
			case "Royal":
				drink = new Royal();
				break;
			case "MountainDew":
				drink = new MountainDew();
				break;
			case "BottledWater":
				drink = new BottledWater();
				break;
		}
		
		return drink;
	}

	@Override
	public Sandwich createSandwich(String sandwichType) {
		return null;
	}
}
