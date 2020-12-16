
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
				if (ocean.isOccupied(row, i)) {
					areaFine = false;
				}
			}
		}
		if (!horizontal) {
			if (!(ship.getLength() + row <= 9)) {
				areaFine = false;
			}
			for (int i = 0; i < ship.getLength(); i++) {
				if (ocean.isOccupied(i, column)) {
					areaFine = false;
				}
			}
		}


		if (areaFine) {
			for (int i = 0; i < ship.getLength(); i++) {
				if (horizontal && row == 0) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(1, i + column) && ocean.isOccupied(1, ship.getLength() + 1)) {
							areaFine = false;
						}
					}
					if (column + ship.getLength() == 9) {
						if (ocean.isOccupied(1, i + column - 1) && ocean.isOccupied(1, 9)) {
							areaFine = false;
						}
					}
					else {
						if (ocean.isOccupied(1, column - 1) && ocean.isOccupied(1, column + ship.getLength() + 1) && ocean.isOccupied(1, column + i)) {
							areaFine = false;
						}
					}
				}
				//if not edges
				if (horizontal && row == 9) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(8, i + column) && ocean.isOccupied(8, ship.getLength() + 1)) {
							areaFine = false;
						}
					}
					if (column + ship.getLength() == 9) {
						if (ocean.isOccupied(8, i + column - 1) && ocean.isOccupied(8, 9)) {
							areaFine = false;
						}
					}
					else {
						if (ocean.isOccupied(8, column - 1) && ocean.isOccupied(8, column + ship.getLength() + 1) && ocean.isOccupied(8, column + i)) {
							areaFine = false;
						}
					}
				}
				//if not edges 
				if (horizontal && row != 9 && row != 0) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(row - 1, i + column) && ocean.isOccupied(row - 1, ship.getLength() + 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, i + column) && ocean.isOccupied(row + 1, ship.getLength() + 1)) {
							areaFine = false;
						}
					}
					if (column + ship.getLength() == 9) {
						if (ocean.isOccupied(row - 1, i + column - 1) && ocean.isOccupied(row - 1, 9)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, i + column - 1) && ocean.isOccupied(row + 1, 9)) {
							areaFine = false;
						}
					}
					else {
						if (ocean.isOccupied(row - 1, column - 1) && ocean.isOccupied(row - 1, column + ship.getLength() + 1) && ocean.isOccupied(row - 1, column + i)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, column - 1) && ocean.isOccupied(row + 1, column + ship.getLength() + 1) && ocean.isOccupied(row + 1, column + i)) {
							areaFine = false;
						}
					}
				}






				if (!horizontal && column == 0) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, 1) && ocean.isOccupied(ship.getLength() + 1, 1)) {
							areaFine = false;
						}
					}
					if (row + ship.getLength() == 9) {
						if (ocean.isOccupied(i + row - 1, 1) && ocean.isOccupied(9,1)) {
							areaFine = false;
						}
					}
					else {
						if (ocean.isOccupied(row - 1, 1) && ocean.isOccupied(row + ship.getLength() + 1, 1) && ocean.isOccupied(row + i, 1)) {
							areaFine = false;
						}
					}
				}
				//if not edges
				if (!horizontal && column == 9) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, 8) && ocean.isOccupied(ship.getLength() + 1, 8)) {
							areaFine = false;
						}
					}
					if (row + ship.getLength() == 9) {
						if (ocean.isOccupied(i + row - 1, 8) && ocean.isOccupied(9, 8)) {
							areaFine = false;
						}
					}
					else {
						if (ocean.isOccupied(row - 1, 8) && ocean.isOccupied(row + ship.getLength() + 1, 8) && ocean.isOccupied(row + i, 8)) {
							areaFine = false;
						}
					}
				}
				//if not edges 
				if (!horizontal && column != 9 && column != 0) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, column - 1) && ocean.isOccupied(ship.getLength() + 1, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(i + row, column + 1) && ocean.isOccupied(ship.getLength() + 1, column + 1)) {
							areaFine = false;
						}
					}
					if (row + ship.getLength() == 9) {
						if (ocean.isOccupied(i + row - 1, column - 1) && ocean.isOccupied(9, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(i + row - 1, column + 1) && ocean.isOccupied(9, column + 1)) {
							areaFine = false;
						}
					}
					else {
						if (ocean.isOccupied(row - 1, column - 1) && ocean.isOccupied(row + ship.getLength() + 1, column - 1) && ocean.isOccupied(row + i, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row - 1, column + 1) && ocean.isOccupied(row + ship.getLength() + 1, column + 1) && ocean.isOccupied(row + i, column + 1)) {
							areaFine = false;
						}
					}
				}

			}

		}
		return areaFine;
	}



	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean, Ship ship) {
		//addded ocean because it is easier to create one ocean
//		boolean inLoop = false;
		
		if (ship.okToPlaceShipAt(row, column, horizontal, ocean, ship)) {
			for (int i = 0; i < ship.getLength(); i++) {
				if (horizontal) {
					ocean.setShips(row, column + i, ship);
				}
				else {
					ocean.setShips(row + i, column, ship);
				}
			}
		}

	}

	boolean shootAt(int row, int column, Ocean ocean) {

		//feed in an ocean so it it's always referring to the same ocean 

		return true;
	}

	boolean isSunk() {
		return true;
	}

}
