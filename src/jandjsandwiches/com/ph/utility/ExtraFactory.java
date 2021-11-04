package jandjsandwiches.com.ph.utility;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.extra.ChickenNuggets;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.extra.FrenchFries;
import jandjsandwiches.com.ph.model.extra.Sundae;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class ExtraFactory implements AbstractFactory {
	public Extra createExtra(String extraType) {
		Extra extra = null;
		
		switch(extraType) {
			case "5 pieces chicken nuggets":
				extra = new ChickenNuggets();
				break;
			case "French fries":
				extra = new FrenchFries();
				break;
			case "Sundae":
				extra = new Sundae();
		}
		
		return extra;
	}
	
	@Override
	public Sandwich createSandwich(String sandwichType) {
		return null;
	}
	
	@Override
	public Drink createDrink(String drinkType) {
		return null;
	}
}
