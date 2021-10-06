package jandjsandwiches.com.ph.model.drink;

public interface Drink {
	String getName();
	String getPrice();
	String getImageName();
	void printDetails();
	Drink clone();
}
