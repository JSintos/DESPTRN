package jandjsandwiches.com.ph.model.drink;

public class Royal extends Drink {
	public Royal() {
		name = "Royal";
		price = "50";
		imageName = "royal.png";
	}
	
	@Override
	public Drink clone() {
		return new Royal();
	}
}
