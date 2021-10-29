package jandjsandwiches.com.ph.model.extra;

public interface Extra {
	String getName();
	String getPrice();
	String getImageName();
	void printDetails();
	Extra clone();
}
