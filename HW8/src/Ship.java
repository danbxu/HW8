
public abstract class Ship {

	int bowRow; //0-9 the front of the ship
	int bowColumn; //0-9 front of the ship
	int length; //number of squares occupied by ship and empty sea location has length of 1
	boolean horizontal; //true if the ship occupies a single row, false otherwise
	boolean[] hit = new boolean [4]; //array of booleans telling weather that part of ship has been hit
	//note this needs to be overriden if different types of ships

	abstract int getLength(); //to be overridden

	abstract String getShipType(); //to be overridden 

	int getBowRow() {
		return bowRow;
	}

	int getBowColumn() {
		return bowColumn;
	}

	boolean isHorizontal() {
		//TODO
		return horizontal; //true if ship occupies a single row, otherwise false
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


	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean, Ship ship) {

		boolean areaFine = true;
		
		if (horizontal) {
			if (!(ship.getLength() + column <= 9)) {
				areaFine = false;
			}
			for (int i = 0; i < ship.getLength(); i++) {
				if (!ocean.isOccupied(row, i)) {
					areaFine = false;
				}
			}
		}
		if (!horizontal) {
			if (!(ship.getLength() + row <= 9)) {
				areaFine = false;
			}
			for (int i = 0; i < ship.getLength(); i++) {
				if (!ocean.isOccupied(i, column)) {
					areaFine = false;
				}
			}
		}
	
		
		if (areaFine) {
			for (int i = 0; i < ship.getLength(); i++) {
				if (horizontal && row == 0) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(1, i + column + 1)) {
							areaFine = false;
						}
					}
				}
				if (!horizontal) {

				}
			}
		}
		//if vertical and zero == 0 only check to the right of it
		//000000000
		
		//edge case ship + column  = 9 
		//edge case column = 0 
		//edge case ship  + row = 9
		
		for (int i = -1; i < 2; i++) {
			if (ships[row][column + i] == null) {
				
			}
		}

		//TODO this can't stick out of the array
		//not overlap, not touch another ship vertically/diagonally/horizontally. 
		//says whether it is legal to do so 
		//maybe use nested forloop
		return areaFine;
	}

	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//addded ocean because it is easier to create one ocean 
	}

	boolean shootAt(int row, int column, Ocean ocean) {

		//feed in an ocean so it it's always referring to the same ocean 

		return true;
	}

	boolean isSunk() {
		return true;
	}

}
