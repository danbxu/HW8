
public abstract class Ship {
	
	int bowRow; //0-9 the front of the ship
	int bowColumn; //0-9 front of the ship
	int length; //number of squares occupied by ship and empty sea location has length of 1
	boolean horizontal; //true if the ship occupies a single row, false otherwise
	boolean[] hit = new boolean [4]; //array of booleans telling weather that part of ship has been hit
	//note this needs to be overriden if different types of ships
	 
	int getLength() {
		return length;
	}
	
	int getBowRow() {
		return bowRow;
	}
	
	int getBowColumn() {
		return bowColumn;
	}

	boolean isHorizontal() {
		return horizontal;
	}
	
	void setBowRow(int row) {
		this.bowRow = row;
	}
	
	void setBowColumn(int column) {
		this.bowColumn = column;
	}
	
	void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	
	abstract String getShipType();
	//to be overrriden 
	
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//TODO this can't stick out of the array
		return true;
	}
	
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		
	}
	
	boolean shootAt(int row, int column) {
		//if it isn't sunken
		return true;
	}
	
	boolean isSunk() {
		//forloop
		//if every part of the ship has been hit
		return true;
	}
	
}
