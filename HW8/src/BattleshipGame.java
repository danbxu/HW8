import java.util.*;
/**
 * 
 * @author coreyparker and danxu
 *
 */

public class BattleshipGame {
	int runningScore = 1000; //keeping an upper bound so the user's first score is the lowest score 

	/**
	 * This method will run the game and initialize the ocean and print the map and will continue to run until
	 * isGameOver() is true (when the player sinks all 10 ships)
	 */
	public void RunGame() {
		Scanner s = new Scanner(System.in);
		Ocean ocean = new Ocean(); //create new ocean
		ocean.placeAllShipsRandomly();
		ocean.print();

		while (!ocean.isGameOver()) { //allow to keep going through if the game is not over
			
			//below section just makes sure the user input is 0-9 for rows and columns 
			
			System.out.print("Please input the row you want to fire on: ");
			while (!s.hasNextInt()) { 
				System.out.print("Please input a positive row number less than 10: ");
				s.next();
			}
			int input = s.nextInt();
			while(input > 9 || input < 0) {
				System.out.print("Please input a positive row number less than 10: ");
				while (!s.hasNextInt()) {
					System.out.print("Please input a positive row number less than 10: ");
					s.next();
				}
				input = s.nextInt();
			}
			int rowNum = input;

			System.out.print("Please input the column you want to fire on: ");
			while (!s.hasNextInt()) { 
				System.out.print("Please input a positive column number less than 10: ");
				s.next();
			}
			int input2 = s.nextInt();
			while(input2 > 9 || input2 < 0) {
				System.out.print("Please input a positive column number less than 10: ");
				while (!s.hasNextInt()) {
					System.out.print("Please input a positive column number less than 10: ");
					s.next();
				}
				input2 = s.nextInt();
			}
			int colNum = input2;
			int[] arr = {rowNum, colNum}; //make the row and column inputs into an array 
			ocean.setUserInputs(arr); //set the user inputs 
			ocean.shootAt(arr[0], arr[1]); //shoot at the ship in ocean class
			Ship shotShip = ocean.getShipArray()[arr[0]][arr[1]]; 
			boolean shot = shotShip.shootAt(arr[0], arr[1]); //shoot at the ship in ship class

			if (shotShip.isSunk() && shot == true) {
				ocean.shipsSunk++; //only add to the sunk ships if it's only been sunk in this turn 
			}
			System.out.println();
			ocean.print();

			System.out.println();
			System.out.println("Shots Fired: " + ocean.getShotsFired());
			System.out.println("Hits: " + ocean.getHitsCount());
			System.out.println("Sunken Ships: " + ocean.getShipsSunk());
			System.out.println("________________________________");

		}


		if (ocean.getShotsFired() < runningScore) { //if the current score is less than the previous one, then update current score as best score 
			runningScore = ocean.getShotsFired();
		}


		System.out.println("The number of shots you had was: " + ocean.getShotsFired());
		System.out.println("Your lowest shots were: " + runningScore);
		System.out.println("The number of hits you had was: " + ocean.getHitsCount());
		System.out.println();

	}
	public void RunAgain() { //this method allows the user to run the game over again 
		Scanner s = new Scanner(System.in);	
		int input3 = 1; //set input to yes they want to play 
		while (input3 == 1) {
			this.RunGame();
			//below stuff is to make sure the user either puts in a 1 or 2
			System.out.print("Would you like to play again? Please hit 1 for yes 2 for no: ");
			while (!s.hasNextInt()) { 
				System.out.print("Please input 1 (yes) or 2 (no): ");
				s.next();
			}
			input3 = s.nextInt();
			while(input3 > 2 || input3 < 0) {
				System.out.print("Please input 1 (yes) or 2 (no): ");
				while (!s.hasNextInt()) {
					System.out.print("Please input 1 (yes) or 2 (no): ");
					s.next();
				}
				input3 = s.nextInt();
			}
		}
		System.out.println("Thanks for playing!");
	}



	public static void main(String[] args) {
		BattleshipGame b = new BattleshipGame();
		b.RunAgain();
	}
}
