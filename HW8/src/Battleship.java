
public class Battleship extends Ship {

	//TODO create a constructor

	Battleship() {
		this.length = 4;
		this.hit = new boolean[4]; 
		for (int i = 0; i < length; i++) {
			hit[i] = false;
		}
	}
	
	//checking all index of ship or ocean 

	@Override 
	public int getLength() {
		return length;
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

	@Override 
	boolean isSunk() {
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			if (hit[i] == true) {
				counter++;
			}
		}
		if (counter == 4) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	String getShipType() {
		return "Battleship";
	}
}
