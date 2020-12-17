
public class Destroyer extends Ship {

	
	
	Destroyer() {
		this.length = 2;
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
		return "Destroyer";
	}
	
	
	@Override 
	boolean isSunk() {
		int counter = 0;
		for (int i = 0; i < 2; i++) {
			if (hit[i] == true) {
				counter++;
			}
		}
		if (counter == 2) {
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
