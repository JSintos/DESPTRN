package jandjsandwiches.com.ph.utility;

import java.util.HashMap;
import java.util.Map;

import jandjsandwiches.com.ph.model.drink.BottledWater;
import jandjsandwiches.com.ph.model.drink.Coke;
import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.drink.MountainDew;
import jandjsandwiches.com.ph.model.drink.Royal;
import jandjsandwiches.com.ph.model.extra.ChickenNuggets;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.extra.FrenchFries;
import jandjsandwiches.com.ph.model.extra.Sundae;
import jandjsandwiches.com.ph.model.sandwich.AmericanSub;
import jandjsandwiches.com.ph.model.sandwich.Bacon;
import jandjsandwiches.com.ph.model.sandwich.BaconEggCheese;
import jandjsandwiches.com.ph.model.sandwich.BagelToast;
import jandjsandwiches.com.ph.model.sandwich.BakedBean;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

public class Prototype {
	private static final Map<String, Sandwich> sandwichPrototypes = new HashMap<>();
	private static final Map<String, Drink> drinkPrototypes = new HashMap<>();
	private static final Map<String, Extra> extraPrototypes = new HashMap<>();
	
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
		
		extraPrototypes.put("5 pieces chicken nuggets", new ChickenNuggets());
		extraPrototypes.put("French fries", new FrenchFries());
		extraPrototypes.put("Sundae", new Sundae());
	}
	
	// Returns the corresponding sandwich prototype given a name
	public static Sandwich getSandwichPrototype(String sandwichType) {
		try {
			return sandwichPrototypes.get(sandwichType).clone();
		} catch(NullPointerException npe) {
			System.out.println("Prototype with the name " + sandwichType + " doesn't exist.");
			
			return null;
		}
	}
	
	// Returns the corresponding drink prototype given a name
	public static Drink getDrinkPrototype(String drinkType) {
		try {
			return drinkPrototypes.get(drinkType).clone();
		} catch(NullPointerException npe) {
			System.out.println("Prototype with the name " + drinkType + " doesn't exist.");
			
			return null;
		}
	}
	
	// Returns the corresponding extra prototype given a name
	public static Extra getExtraPrototype(String extraType) {
		try {
			return extraPrototypes.get(extraType).clone();
		} catch(NullPointerException npe) {
			System.out.println("Prototype with the name " + extraType + " doesn't exist.");
			
			return null;
		}
	}
}
