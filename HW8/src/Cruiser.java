
public class Cruiser extends Ship {

	
	Cruiser() {
		this.length = 3;
	}
	
	@Override 
	public int getLength() {
		return length;
	}
	
	@Override
	String getShipType() {
		return "Cruiser";
	}
	
	public static void main(String[] args) {
		Cruiser a = new Cruiser();
		System.out.println(a.getLength());
		System.out.println(a.getShipType());
	}

}
