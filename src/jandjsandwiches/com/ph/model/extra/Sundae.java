package jandjsandwiches.com.ph.model.extra;

public class Sundae extends Extra {
	public Sundae() {
		name = "Sundae";
		price = "25";
		imageName = "sundae.png";
	}
	
	@Override
	public Extra clone() {
		return new Sundae();
	}

}
