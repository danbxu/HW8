
public class Battleship extends Ship {
	
	//TODO create a constructor
	
	Battleship() {
		this.length = 4;
	}

	@Override
	public String toString() {
		//implement something like if sunk, 
		return "S"; //return x if the ship is sunk
	}
	
	@Override 
	boolean isSunk() {
		//if sunk, can be used in toString
		return false;
	}
	
	@Override
	String getShipType() {
		return "Battleship";
	}

}
