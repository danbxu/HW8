
public class Cruiser extends Ship {

	
	Cruiser() {
		this.length = 3;
		this.hit = new boolean[4]; 
		for (int i = 0; i < length; i++) {
			hit[i] = false;
		}
	}
	
	@Override 
	public int getLength() {
		return length;
	}
	
	@Override
	String getShipType() {
		return "Cruiser";
	}
	
	@Override 
	boolean isSunk() {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			if (hit[i] == true) {
				counter++;
			}
		}
		if (counter == 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Cruiser a = new Cruiser();
		System.out.println(a.getLength());
		System.out.println(a.getShipType());
	}

}
