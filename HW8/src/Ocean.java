import java.util.Random;
import java.util.*;

public class Ocean {

	public static Ship[][] ships = new Ship[10][10];
	int shotsFired; 
	int hitCount; //hit shit, increase it but hitting the same spot don't increase it
	int shipsSunk; //increment to 10 total ships sunk
	static ArrayList<int[]> userInputs = new ArrayList<int[]>();
	int[] input = new int[2];


	public int[] getInput() {
		return input;
	}

	public void setInput(int[] input) {
		this.input = input;
		userInputs.add(input);
	}


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
		input = null;
		//userInputs.clear();
		int arr[] = {10, 10}; 
		userInputs.add(arr);

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

	public void setUserInputs(ArrayList<int[]> userInputs) {
		this.userInputs = userInputs;
	}

	public void placeAllShipsRandomly() { //feed in a ship so that the code is cleaner


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
		System.out.println("        The gameboard:");
		System.out.println();
		//TODO this prints the ocean with  0-9 on the tope and 0-9 on the left
		//'S' to show where fired shots and hit a real ship
		//'-' to show a location you have fired and nothing is there
		//'x' to indicate a sunken ship
		//'.'hitCount indicate a location that you have never fired upon


		for (int i = 0; i < 10; i++ ) {
			boolean hasBeenCalled = false;
			if (i == 0) {
				for (int j = 0; j < 10; j++) {
					if (j ==0) {
						System.out.print("   " + j);
					}
					else {
						System.out.print("  " + j);
					}
				}
				System.out.println();
			}

			for (int j = 0; j < 10; j++) {
				hasBeenCalled = false;
				String symbol = ".";
				Ship currentShip = ships[i][j];
				boolean isHor = currentShip.isHorizontal();
				int column = currentShip.getBowColumn();
				int row = currentShip.getBowRow();

				if (userInputs != null) {
					for (int k = 1; k < userInputs.size(); k++) {
						if (userInputs.get(k)[0] == i && userInputs.get(k)[1] == j) {
							hasBeenCalled = true;
							//symbol = currentShip.toString();
							
						}
					}
				}

				if (j == 0) {
					System.out.print(i + " ");
				}
				if (hasBeenCalled) {
					symbol = currentShip.toString();
				}
				System.out.print("[" + symbol + "]");
//				hasBeenCalled = false;
			}
			System.out.println();
		}
		System.out.println("________________________________");


	}


	public static void main(String[] args) {
		Ocean a = new Ocean();
		a.placeAllShipsRandomly();
		int [] arr = new int[2];
		arr[0] = 7;
		arr[1] = 3;
		a.setInput(arr);
		System.out.println(Arrays.toString(userInputs.get(1)));
		a.print();
		arr[0] = 2;
		arr[1] = 4;
		a.setInput(arr);
		System.out.println(Arrays.toString(userInputs.get(2)));
		a.print();
	}

}
