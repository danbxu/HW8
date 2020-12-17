import java.util.*;

public class GameRunner {
	int runningScore = 1000;

	public void RunGame() {
		Scanner s = new Scanner(System.in);
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		//System.out.println("Here!");

		ocean.print();

		//plse delete
		//ocean.shipsSunk = 10;
		while (!ocean.isGameOver()) {
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
			int[] arr = {rowNum, colNum};
			ocean.setUserInputs(arr);
			ocean.shootAt(arr[0], arr[1]);
			Ship shotShip = ocean.getShipArray()[arr[0]][arr[1]];
			boolean shot = shotShip.shootAt(arr[0], arr[1]);

			if (shotShip.isSunk() && shot == true) {
				ocean.shipsSunk++;
			}
			System.out.println();
			ocean.print();

			System.out.println();
			System.out.println("Shots Fired: " + ocean.getShotsFired());
			System.out.println("Hits: " + ocean.getHitsCount());
			System.out.println("Sunken Ships: " + ocean.getShipsSunk());
			System.out.println("________________________________");

		}


		if (ocean.getShotsFired() < runningScore) {
			runningScore = ocean.getShotsFired();
		}


		System.out.println("The number of shots you had was: " + ocean.getShotsFired());
		System.out.println("Your lowest shots were: " + runningScore);
		System.out.println("The number of hits you had was: " + ocean.getHitsCount());
		System.out.println();

	}
	public void RunAgain() {
		Scanner s = new Scanner(System.in);	
		//this.RunGame();
		int input3 = 1;
		while (input3 == 1) {
			//GameRunner r = new GameRunner();
			this.RunGame();
			

		//	this.RunGame();

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
//			if (input3 == 1) {
//				System.out.println("Back for more?");
//				//			System.out.println();
//				//			Ocean ocean = new Ocean();
//				//			ocean.shipsSunk = 0;
//				//			this.RunGame();
//				//		}
//			}
//			else {
//				System.out.println("All good! Thanks for playing!");
//			}
		}
		System.out.println("Thanks for playing!");
	}



	public static void main(String[] args) {
		GameRunner r = new GameRunner();
		r.RunAgain();
		//r.RunGame();
	//	System.out.println("finished 1");
//		GameRunner s = new GameRunner();
//		s.RunGame();
		//r.RunGame();
		//System.out.println("hi");
		//Scanner s = new Scanner(System.in);
		//		int choice = 1;
		//		while(choice == 1) {
		//			r.RunGame();
		//			System.out.print("Would you like to play again? Please hit 1 for yes 2 for no: ");
		//			while (!s.hasNextInt()) { 
		//				System.out.print("Please input 1 (yes) or 2 (no): ");
		//				s.next();
		//			}
		//			int input = s.nextInt();
		//			while(input > 2 || input < 0) {
		//				System.out.print("Please input 1 (yes) or 2 (no): ");
		//				while (!s.hasNextInt()) {
		//					System.out.print("Please input 1 (yes) or 2 (no): ");
		//					s.next();
		//				}
		//				input = s.nextInt();
		//			}
		//			choice = input;
		//			if (choice == 1) {
		//				System.out.println("Back for more?");
		//			}
		//		}
		//		System.out.println("All good! Have a great day!");
	}
}
