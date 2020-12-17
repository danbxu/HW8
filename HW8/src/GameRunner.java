import java.util.*;

public class GameRunner {

	public void RunGame() {
		Scanner s = new Scanner(System.in);
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		ocean.print();
		while (!ocean.isGameOver()) {
			System.out.println("Please input your row you want to fire on");
			while (!s.hasNextInt()) { // ||
				System.out.println("Please input a number less than 10");
				s.next();
			}
			
			int rowNum = s.nextInt();
			
			System.out.println("Please input your column you want to fire on");
			while (!s.hasNextInt()) {
				System.out.println("Please input a number less than 10");
				s.next();
			}
			int colNum = s.nextInt();
			int[] arr = {rowNum, colNum};
			ocean.setUserInputs(arr);
			ocean.shootAt(arr[0], arr[1]);
			ocean.getShipArray()[arr[0]][arr[1]].shootAt(arr[0], arr[1]);
			ocean.print();
		}
		System.out.println("The number of shots you had was: " + ocean.getShotsFired());
		System.out.println("The number of hits you had was: " + ocean.getHitsCount());
		System.out.println("Thanks for playing!");
	}
	
	public static void main(String[] args) {
		GameRunner r = new GameRunner();
		r.RunGame();
	}
}
