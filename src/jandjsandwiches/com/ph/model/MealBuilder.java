package jandjsandwiches.com.ph.model;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class MealBuilder {
	public Meal prepareSetMealOne(Sandwich sandwich, Drink drink) {
		Meal meal = new Meal();
		
		meal.addItem(sandwich);
		meal.addItem(drink);
		
		return meal;
	}
	
	public Meal prepareSetMealTwo(Sandwich sandwich, Drink drink, Extra extra) {
		Meal meal = new Meal();
		
		meal.addItem(sandwich);
		meal.addItem(drink);
		meal.addItem(extra);
		
		return meal;
	}
	
	public Meal prepareSetMealThree(Sandwich sandwich, Extra extra) {
		Meal meal = new Meal();
		
		meal.addItem(sandwich);
		meal.addItem(extra);
		
		return meal;
	}
	
	public Meal prepareSetMealFour(Extra extra) {
		Meal meal = new Meal();
		
		meal.addItem(extra);
		
		return meal;
	}
}
