import java.util.Random;

public class Ocean {
	
	static Ship[][] ships = new Ship[10][10];
	int shotsFired; 
	int hitCount; //hit shit, increase it but hitting the same spot don't increase it
	int shipsSunk; //increment to 10 total ships sunk
	
	
	//Random 
	Random randomRow = new Random();
	Random randomColumn = new Random();
	Random RorC = new Random();
	int upperbound = 10; //0-9
	int randomRowOrColumn = 2;
	

	void Ocean() {
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		
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
	
	//checking the location to put a new ship randomly 
	//boundary checks 
	
	public void placeAllShipsRandomly(Ship ship) { //feed in a ship so that the code is cleaner
		
		int randomR = randomRow.nextInt(upperbound);
		int randomC = randomColumn.nextInt(upperbound);
		int rowOrColumn = RorC.nextInt(randomRowOrColumn); //this will determine whether to place vertically or horizontally
		
		int rows;
		
		// 0  = horizontal
		// 1 = vertical
		
		//boundary check and check location
		
		if (ships[randomR][randomC] == null) {
			if (rowOrColumn == 0) { //if to be placed horizontally
				
			
			
				
				
			
			}
			
			if(rowOrColumn == 1) { //if to be placed vertically
				ship.getLength();
				System.out.println("to be put vertically and length is" + ship.getLength());
			}
		}
	
		
		
		
		//start with big ships first
		//put it here or try it with our random gen location
		//check the ocean and 1 to all loations and buffer 1 cell around the boat       - - - -  //nested forloops for the grid i,j i - 1 , i + 1, j - 1, j + 1
		
		//this will create 
	}
	
	boolean isOccupied(int row, int column) {
		if (ships [row][column].getShipType().equals("empty")) { //would this have an issue with all different types of ships
			//System.out.println("location is emptySea");
			return false;
		}
		else {
			//System.out.println("location is occupied");
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
		
			return true;
		}
		else {

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
	
	
	public static void main(String[] args) {
		Ocean a = new Ocean();
		Battleship b = new Battleship();
		Cruiser c = new Cruiser();
		a.placeAllShipsRandomly(b);
		a.placeAllShipsRandomly(c);
	}

}
