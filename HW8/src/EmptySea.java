
public class EmptySea extends Ship {
	
	EmptySea() {
		this.length = 1;
	}
	
	@Override 
	boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override 
	boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		return "-";
	}
	
	@Override
	String getShipType() {
		return "empty";
	}

}
