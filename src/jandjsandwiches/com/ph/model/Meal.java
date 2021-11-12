package jandjsandwiches.com.ph.model;

import java.util.ArrayList;
import java.util.Iterator;

import jandjsandwiches.com.ph.utility.MealIterator;

public class Meal implements MealIterator {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	@Override
	public Iterator createIterator() {
		return items.iterator();
	}
	
	public String getItemList() {
		String itemList = "";
		
		for(int counter = 0; counter < items.size(); counter++) {
			if(counter != items.size() - 1) {
				itemList += items.get(counter).getName() + ", ";
			}
			else {
				itemList += items.get(counter).getName();
			}
		}
		
		return itemList;
	}
	
	public double getTotalCost() {
		double totalCost = 0.0;
		
		for(Item item : items) {
			totalCost += Double.parseDouble(item.getPrice());
		}
		
		return totalCost;
	}
}
