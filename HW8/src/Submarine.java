
public class Submarine extends Ship {

	//TODO constructor 
	
	//create an constructor to override
	// one space
	
	Submarine() {
		this.length = 1;
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
		return "Submarine";
	}
	
	@Override 
	boolean isSunk() {
		int counter = 0;
		for (int i = 0; i < 1; i++) {
			if (hit[i] == true) {
				counter++;
			}
		}
		if (counter == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "x";
		}
		else {
			return "S";
		}
	}
	
}
