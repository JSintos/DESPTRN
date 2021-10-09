package jandjsandwiches.com.ph.utility;

import java.util.HashMap;
import java.util.Map;

import jandjsandwiches.com.ph.model.drink.*;
import jandjsandwiches.com.ph.model.sandwich.*;

public class Prototype {
	private static final Map<String, Sandwich> sandwichPrototypes = new HashMap<>();
	private static final Map<String, Drink> drinkPrototypes = new HashMap<>();
	
	static {
		sandwichPrototypes.put("American sub", new AmericanSub());
		sandwichPrototypes.put("Bacon", new Bacon());
		sandwichPrototypes.put("Bacon, egg, and cheese", new BaconEggCheese());
		sandwichPrototypes.put("Bagel toast", new BagelToast());
		sandwichPrototypes.put("Baked bean", new BakedBean());
		
		drinkPrototypes.put("Bottled Water", new BottledWater());
		drinkPrototypes.put("Coke", new Coke());
		drinkPrototypes.put("Mountain Dew", new MountainDew());
		drinkPrototypes.put("Royal", new Royal());
	}
	
	public static Sandwich getSandwichPrototype(String sandwichType) {
		try {
			return sandwichPrototypes.get(sandwichType).clone();
		} catch(NullPointerException npe) {
			System.out.println("Prototype with the name " + sandwichType + " doesn't exist.");
			
			return null;
		}
	}
	
	public static Drink getDrinkPrototype(String drinkType) {
		try {
			return drinkPrototypes.get(drinkType).clone();
		} catch(NullPointerException npe) {
			System.out.println("Prototype with the name " + drinkType + " doesn't exist.");
			
			return null;
		}
	}
}
