package jandjsandwiches.com.ph.utility;

import jandjsandwiches.com.ph.model.*;

public class Factory {
	public static Sandwich createSandwich(String sandwichType) {
		Sandwich sandwich = null;
		
		switch(sandwichType) {
			case "AmericanSub":
				sandwich = new AmericanSub();
				break;
			case "Bacon":
				sandwich = new Bacon();
				break;
			case "BaconEggCheese":
				sandwich = new BaconEggCheese();
				break;
			case "BagelToast":
				sandwich = new BagelToast();
				break;
			case "BakedBean":
				sandwich = new BakedBean();
		}
		
		return sandwich;
	}
}
