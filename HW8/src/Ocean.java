
public class Ocean {
	
	Ship[][] ships = new Ship[10][10];
	int shotsFired; 
	int hitCount; //hit shit, increase it but hitting the same spot don't increase it
	int shipsSunk; //increment to 10 total ships sunk
	boolean gameState; 
	
	
	void Ocean() {
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		gameState = false;
		
		//adds emptySea into null
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (ships [i][j] == null) {
					EmptySea emptySea = new EmptySea();
					ships [i][j] = emptySea;
				}
			}
		}
		
		//TODO creates an empty ocean and fills the ships with Empty Seas
		//initializes any game variables like shots fired.
	}
	
	
	void placeAllShipsRandomly() {
		//start with big ships first
		//put it here or try it with our random gen location
	}
	
	boolean isOccupied(int row, int column) {
		if (ships [row][column].getShipType().equals("empty")) { //would this have an issue with all different types of ships
			System.out.println("location is emptySea");
			return false;
		}
		else {
			System.out.println("location is occupied");
			return true;
		}
	}
	
	boolean shootAt(int row, int column) {
		//TODO implement shooting 
		//This updates shotsfired and hitscount, if the ship becomes sunk, the additional shots return false
		return true;
	}
	
	
	int getShotsFired() {
		return shotsFired;
	}
	
	int getHitsCount() {
		return hitCount;
	}
	
	int getShipsSunk() {
		return shipsSunk;
	}
	
	boolean isGameOver() {
		if (shipsSunk == 10) {
			gameState = true;
			return true;
		}
		else {
			gameState = false;
			return false;
		}
	}
	
	//returns ship array 10x10
	Ship[][] getShipArray() {
		return ships;
	}
	
	//only method without input out and 
	void print() {
		//TODO this prints the ocean with  0-9 on the tope and 0-9 on the left
		//'S' to show where fired shots and hit a real ship
		//'-' to show a location you have fired and nothing is there
		//'x' to indicate a sunken ship
		//'.'hitCount indicate a location that you have never fired upon
	}

}
