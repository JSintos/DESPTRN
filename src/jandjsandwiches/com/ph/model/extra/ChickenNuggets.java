package jandjsandwiches.com.ph.model.extra;

public class ChickenNuggets extends Extra {
	public ChickenNuggets() {
		name = "5 pieces chicken nuggets";
		price = "25";
		imageName = "chickennuggets.png";
	}
	
	@Override
	public Extra clone() {
		return new ChickenNuggets();
	}
}
