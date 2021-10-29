package jandjsandwiches.com.ph.utility;

import jandjsandwiches.com.ph.model.Meal;
import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;
import jandjsandwiches.com.ph.model.extra.Extra;;

public class MealBuilder {
	/*
	 * Meals:
	 * 1: 1 sandwich, 1 drink
	 * 2: 1 sandwich, 1 drink, 1 extra
	 * 3: 1 sandwich, 1 extra
	 * 4: 1 extra
	 * parameters (Sandwich sandwich, Drink drink, Extra extra)
	 * Create sandwich, drink and extra using factory then pass through MealBuilder
	 */
	
	//meal.addSandwich, meal.addDrink, meal.addExtra
	public Meal prepareSetMeal1(Sandwich sandwich, Drink drink){
	      Meal meal = new Meal();
	      meal.addSandwich(sandwich);
	      meal.addDrink(drink);
	      return meal;
	  }
	
	public Meal prepareSetMeal2(Sandwich sandwich, Drink drink, Extra extra){
	      Meal meal = new Meal();
	      meal.addSandwich(sandwich);
	      meal.addDrink(drink);
	      meal.addExtra(extra);
	      return meal;
	  }
	
	public Meal prepareSetMeal3(Sandwich sandwich, Extra extra){
	      Meal meal = new Meal();
	      meal.addSandwich(sandwich);
	      meal.addExtra(extra);
	      return meal;
	  }
	
	public Meal prepareSetMeal4(Extra extra){
	      Meal meal = new Meal();
	      meal.addExtra(extra);
	      return meal;
	  }
}
