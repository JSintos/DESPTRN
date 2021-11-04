package jandjsandwiches.com.ph.model.drink;

public class BottledWater extends Drink {
	public BottledWater() {
		name = "Bottled Water";
		price = "15";
		imageName = "bottledwater.png";
	}
	
	@Override
	public Drink clone() {
		return new BottledWater();
	}
}
