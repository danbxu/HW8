
public class EmptySea extends Ship {
	
	EmptySea() {
		this.length = 1;
	}
	
	@Override 
	boolean shootAt(int row, int column, Ocean ocean) {
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
	
	@Override 
	public int getLength() {
		return length;
	}

}
