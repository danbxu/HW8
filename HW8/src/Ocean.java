import java.util.Random;

public class Ocean {
	
	public static Ship[][] ships = new Ship[10][10];
	int shotsFired; 
	int hitCount; //hit shit, increase it but hitting the same spot don't increase it
	int shipsSunk; //increment to 10 total ships sunk
	
	
	//Random 
	Random randomRow = new Random();
	Random randomColumn = new Random();
	Random horOrVert = new Random();
	int upperbound = 10; //0-9
	//int randomOrientation = 2;
	
	
	void setShips(int row, int column, Ship ship) {
		ships[row][column] = ship;
	}

	Ocean() {
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
	
	public void placeAllShipsRandomly() { //feed in a ship so that the code is cleaner
		
		
//		int randomR = randomRow.nextInt(upperbound);
//		int randomC = randomColumn.nextInt(upperbound);
//		int horVert = horOrVert.nextInt(randomOrientation); //this will determine whether to place vertically or horizontally
		
		//int rows;
		
		
		// 0  = horizontal
		// 1 = vertical
		
		//boundary check and check location
		
		
		Ship battleship = new Battleship();
		Ship cruiser1 = new Cruiser();
		Ship cruiser2 = new Cruiser();
		Ship destroy1 = new Destroyer();
		Ship destroy2 = new Destroyer();
		Ship destroy3 = new Destroyer();
		Ship sub1 = new Submarine();
		Ship sub2 = new Submarine();
		Ship sub3 = new Submarine();
		Ship sub4 = new Submarine();
		Ship[] fleet = new Ship[10];
		
		for (int i = 0; i < 1; i++) {
			fleet[i] = battleship;
			fleet[i+1] = cruiser1;
			fleet[i+2] = cruiser2;
			fleet[i+3] = destroy1;
			fleet[i+4] = destroy2;
			fleet[i+5] = destroy3;
			fleet[i+6] = sub1;
			fleet[i+7] = sub2;
			fleet[i+8] = sub3;
			fleet[i+9] = sub4;
		}
		
		for (int i = 0; i < fleet.length; i++) {
			int randomR = randomRow.nextInt(upperbound);
			int randomC = randomColumn.nextInt(upperbound);
			boolean horVert = horOrVert.nextBoolean();
			
			while(!fleet[i].okToPlaceShipAt(randomR, randomC, horVert, this)) {
				randomR = randomRow.nextInt(upperbound);
				randomC = randomColumn.nextInt(upperbound);
				horVert = horOrVert.nextBoolean();
			}
			fleet[i].placeShipAt(randomR, randomC, horVert, this);
		}
		
		
		
		
		
		
		
		
		
		
//		if (ships[randomR][randomC] == null) {
//			if (rowOrColumn == 0) { //if to be placed horizontally
//			
//				//for loop checking row
//				
//				
//				
////				check by index
////				
////				//while loop for placing the ships 
////				
////				00000000
////				o      0 
////				o      0      
////				o      0 
////				o      0 
////				o      0 
////				00000000
////			}
////			
////			if(rowOrColumn == 1) { //if to be placed vertically
////				//forloop checking column
//				
//				
//				System.out.println("to be put vertically and length is" + ship.getLength());
//			}
//		}
	
		
		//perhaps use
		
		//ship.setBowColumn(holder)
		//ship.getBowRow(holder)
		
		
		
		//start with big ships first
		//put it here or try it with our random gen location
		//check the ocean and 1 to all loations and buffer 1 cell around the boat       - - - -  //nested forloops for the grid i,j i - 1 , i + 1, j - 1, j + 1
		
		//this will create 
	}
	
	boolean isOccupied(int row, int column) {
		if (ships[row][column].getShipType().equals("empty")) { //would this have an issue with all different types of ships
			//System.out.println("location is emptySea");
			return false;
		}
		else {
			//System.out.println("location is occupied");
			return true;
		}
	}
	
	boolean shootAt(int row, int column) {
		shotsFired++;
		if (!ships[row][column].getShipType().equals("empty") && !ships[row][column].isSunk()) {
			hitCount++;
			return true;
		}
		//TODO implement shooting 
		//This updates shotsfired and hitscount, if the ship becomes sunk, the additional shots return false
		return false;
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
		a.placeAllShipsRandomly();
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				System.out.println("[" + i + "," + k + "]"+ ships[i][k].getShipType());
			}
		}
//		a.placeAllShipsRandomly(b);
//		a.placeAllShipsRandomly(c);
	}

}
