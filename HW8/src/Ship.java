
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


	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		int shipLeng = this.getLength();
		

		boolean areaFine = true;

		if (horizontal) {
			if (!(shipLeng + column <= 9)) {
				areaFine = false;
			}
			for (int i = 0; i < shipLeng; i++) {
				if (ocean.isOccupied(row, i)) {
					areaFine = false;
				}
			}
		}
		if (!horizontal) {
			if (!(shipLeng + row <= 9)) {
				areaFine = false;
			}
			for (int i = 0; i < shipLeng; i++) {
				if (ocean.isOccupied(i, column)) {
					areaFine = false;
				}
			}
		}


		if (areaFine) {
			for (int i = 0; i < shipLeng; i++) {
				if (horizontal && row == 0) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(1, i + column) && ocean.isOccupied(1, shipLeng + 1)) {
							areaFine = false;
						}
					}
					if (column + shipLeng == 9) {
						if (ocean.isOccupied(1, i + column - 1) && ocean.isOccupied(1, 9)) {
							areaFine = false;
						}
					}
					if(column!= 0 && column + shipLeng != 9) {
						if (ocean.isOccupied(1, column - 1) && ocean.isOccupied(1, column + shipLeng + 1) && ocean.isOccupied(1, column + i)) {
							areaFine = false;
						}
					}
				}
				//if not edges
				if (horizontal && row == 9) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(8, i + column) && ocean.isOccupied(8, shipLeng + 1)) {
							areaFine = false;
						}
					}
					if (column + shipLeng == 9) {
						if (ocean.isOccupied(8, i + column - 1) && ocean.isOccupied(8, 9)) {
							areaFine = false;
						}
					}
					if (column != 0 && column + shipLeng != 9) {
						if (ocean.isOccupied(8, column - 1) && ocean.isOccupied(8, column + shipLeng + 1) && ocean.isOccupied(8, column + i)) {
							areaFine = false;
						}
					}
				}
				//if not edges 
				if (horizontal && row != 9 && row != 0) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(row - 1, i + column) && ocean.isOccupied(row - 1, shipLeng + 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, i + column) && ocean.isOccupied(row + 1, shipLeng + 1)) {
							areaFine = false;
						}
					}
					if (column + shipLeng == 9) {
						if (ocean.isOccupied(row - 1, i + column - 1) && ocean.isOccupied(row - 1, 9)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, i + column - 1) && ocean.isOccupied(row + 1, 9)) {
							areaFine = false;
						}
					}
					if(column != 0 && column + shipLeng != 9) {
						if (ocean.isOccupied(row - 1, column - 1) && ocean.isOccupied(row - 1, column + shipLeng + 1) && ocean.isOccupied(row - 1, column + i)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, column - 1) && ocean.isOccupied(row + 1, column + shipLeng + 1) && ocean.isOccupied(row + 1, column + i)) {
							areaFine = false;
						}
					}
				}






				if (!horizontal && column == 0) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, 1) && ocean.isOccupied(shipLeng + 1, 1)) {
							areaFine = false;
						}
					}
					if (row + shipLeng == 9) {
						if (ocean.isOccupied(i + row - 1, 1) && ocean.isOccupied(9,1)) {
							areaFine = false;
						}
					}
					if (row != 0 && row + shipLeng != 9) {
						if (ocean.isOccupied(row - 1, 1) && ocean.isOccupied(row + shipLeng + 1, 1) && ocean.isOccupied(row + i, 1)) {
							areaFine = false;
						}
					}
				}
				//if not edges
				if (!horizontal && column == 9) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, 8) && ocean.isOccupied(shipLeng + 1, 8)) {
							areaFine = false;
						}
					}
					if (row + shipLeng == 9) {
						if (ocean.isOccupied(i + row - 1, 8) && ocean.isOccupied(9, 8)) {
							areaFine = false;
						}
					}
					if (row != 0 && row + shipLeng != 9) {
						if (ocean.isOccupied(row - 1, 8) && ocean.isOccupied(row + shipLeng + 1, 8) && ocean.isOccupied(row + i, 8)) {
							areaFine = false;
						}
					}
				}
				//if not edges 
				if (!horizontal && column != 9 && column != 0) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, column - 1) && ocean.isOccupied(shipLeng + 1, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(i + row, column + 1) && ocean.isOccupied(shipLeng + 1, column + 1)) {
							areaFine = false;
						}
					}
					if (row + shipLeng == 9) {
						if (ocean.isOccupied(i + row - 1, column - 1) && ocean.isOccupied(9, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(i + row - 1, column + 1) && ocean.isOccupied(9, column + 1)) {
							areaFine = false;
						}
					}
					if(row!=0 && row + shipLeng != 9) {
						if (ocean.isOccupied(row - 1, column - 1) && ocean.isOccupied(row + shipLeng + 1, column - 1) && ocean.isOccupied(row + i, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row - 1, column + 1) && ocean.isOccupied(row + shipLeng + 1, column + 1) && ocean.isOccupied(row + i, column + 1)) {
							areaFine = false;
						}
					}
				}

			}

		}
		return areaFine;
	}



	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//added ocean because it is easier to create one ocean
		
		if (this.okToPlaceShipAt(row, column, horizontal, ocean)) {
			this.setBowColumn(column);
			this.setBowRow(row);
			this.setHorizontal(horizontal);
			for (int i = 0; i < this.getLength(); i++) {
				if (horizontal) {
					ocean.setShips(row, column + i, this);
				}
				else {
					ocean.setShips(row + i, column, this);
				}
			}
		}

	}

	boolean shootAt(int row, int column, Ocean ocean) {
		if (!ocean.getShipArray()[row][column].getShipType().equals("empty") && !ocean.getShipArray()[row][column].isSunk()) {
			Ship currentShip = ocean.getShipArray()[row][column];
			if(currentShip.isHorizontal()) {
				currentShip.hit[column - currentShip.getBowColumn()] = true;
			}
			else {
				currentShip.hit[row - currentShip.getBowRow()] = true;
			}
			return true;
		}

		//feed in an ocean so it it's always referring to the same ocean 

		return false;
	}

	boolean isSunk() {
		return true;
	}

}
