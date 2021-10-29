package jandjsandwiches.com.ph.model;

import jandjsandwiches.com.ph.model.drink.Drink;
import jandjsandwiches.com.ph.model.extra.Extra;
import jandjsandwiches.com.ph.model.sandwich.Sandwich;

import java.util.ArrayList;
import java.util.List;

//public void addSandwich, etc.
//public void getItemList
	//Check if ItemList is not empty
	//If not empty, traverse list then get the names and concatenate to string
	//Ex. if user chooses set meal 1, no need to traverse through extras because it's empty

public class Meal {
   private List<Sandwich> sandwiches = new ArrayList<Sandwich>();
   private List<Drink> drinks = new ArrayList<Drink>();
   private List<Extra> extras = new ArrayList<Extra>();

   public void addSandwich(Sandwich sandwich){
      sandwiches.add(sandwich);
   }
   
   public void addDrink(Drink drink){
	      drinks.add(drink);
   }
   
   public void addExtra(Extra extra){
	      extras.add(extra);
   }
   
   public String getItemList(){
	   String sandwichName = null;
	   String drinkName = null;
	   String extraName = null;
	   String items;
	   
	   if (!sandwiches.isEmpty()){
		   for (Sandwich sandwich : sandwiches) {
			   sandwichName = sandwich.getName();
		   }
	   }
	   
	   if (!drinks.isEmpty()){
		   for (Drink drink : drinks) {
			   drinkName = drink.getName();
		   }
	   }
	   
	   if (!extras.isEmpty()){
		   for (Extra extra : extras) {
			   extraName = extra.getName();
		   }
	   }
	   
	   items = sandwichName + ", " + drinkName + ", " + extraName;
	   return items;
   }
   
   

   //costs for each product, then total cost method (?)
   
   public double getSandwichCost(){
      double cost = 0.0;
      
      for (Sandwich sandwich : sandwiches) {
    	cost += Double.parseDouble(sandwich.getPrice());
      }
      return cost;
   }
   
   public double getDrinkCost(){
	      double cost = 0.0;
	      
	      for (Drink drink : drinks) {
	    	cost += Double.parseDouble(drink.getPrice());
	      }		
      return cost;
   }
   
   public double getExtraCost(){
	      double cost = 0.0;
	      
	      for (Extra extra : extras) {
	    	cost += Double.parseDouble(extra.getPrice());
	      }		
      return cost;
   }
   
   public double getTotalCost(){
	      return getSandwichCost() + getDrinkCost() + getExtraCost();
   }
}
