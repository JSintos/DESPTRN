package jandjsandwiches.com.ph.utility;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public interface AbstractFactory {
	Sandwich createSandwich(String sandwichType);
	Drink createDrink(String drinkType);
}
