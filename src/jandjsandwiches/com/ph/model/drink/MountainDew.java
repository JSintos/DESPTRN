package jandjsandwiches.com.ph.model.drink;

public class MountainDew extends Drink {
	public MountainDew() {
		name = "Mountain Dew";
		price = "50";
		imageName = "mountaindew.png";
	}
	
	@Override
	public Drink clone() {
		return new MountainDew();
	}
}
