import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class JunitTesting {

	@BeforeEach
	void setUp() throws Exception {
	}

	//TESTING Battleship ================================================================================

	//Tests if Battleship constructor works and returns length 4
	@Test
	void CreateBattleshipAndTest() {
		Battleship test = new Battleship(); 
		assertEquals(test.getLength(), 4);
	}

	//Tests if Battleship constructor works and returns hit[] all initialized to false
	@Test
	void CheckBattleshipHitArray() {
		Battleship test = new Battleship();
		assertEquals(test.hit[0], false);
		assertEquals(test.hit[1], false);
		assertEquals(test.hit[2], false);
		assertEquals(test.hit[3], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckBattleshipIsSunk() {
		Battleship test = new Battleship();
		test.hit[0] = true;
		test.hit[1] = true;
		test.hit[2] = true;
		test.hit[3] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckBattleshipIsNotSunk() {
		Battleship test = new Battleship();
		test.hit[0] = true;
		test.hit[1] = true;
		test.hit[3] = true;
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Battleship"
	}
	@Test
	void CheckBattleShipGetShipType() {
		Battleship test1 = new Battleship();
		assertTrue(test1.getShipType().contains("Battleship"));
	}


	//TESTING CRUISER ================================================================================

	//Tests if Cruiser constructor works and returns length 3
	@Test
	void CreateCruiserAndTest() {
		Cruiser  test = new Cruiser(); 
		assertEquals(test.getLength(), 3);
	}

	//Tests if Cruiser constructor works and returns hit[] all initialized to false
	@Test
	void CheckCruiserHitArray() {
		Battleship test = new Battleship();
		assertEquals(test.hit[0], false);
		assertEquals(test.hit[1], false);
		assertEquals(test.hit[2], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckCruiserIsSunk() {
		Cruiser  test = new Cruiser ();
		test.hit[0] = true;
		test.hit[1] = true;
		test.hit[2] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckCruiserIsNotSunk() {
		Cruiser test = new Cruiser();
		test.hit[0] = true;
		test.hit[1] = true;
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Cruiser"
	}
	@Test
	void CheckCruiserGetShipType() {
		Cruiser test1 = new Cruiser();
		assertTrue(test1.getShipType().contains("Cruiser"));
	}

	//TESTING Destroyer ================================================================================

	//Tests if Destroyer constructor works and returns length 2
	@Test
	void CreateDestroyerAndTest() {
		Destroyer test = new Destroyer(); 
		assertEquals(test.getLength(), 2);
	}

	//Tests if Destroyer constructor works and returns hit[] all initialized to false
	@Test
	void CheckDestroyerHitArray() {
		Destroyer  test = new Destroyer();
		assertEquals(test.hit[0], false);
		assertEquals(test.hit[1], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckDestroyerIsSunk() {
		Destroyer test = new Destroyer();
		test.hit[0] = true;
		test.hit[1] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckDestroyerIsNotSunk() {
		Destroyer  test = new Destroyer();
		test.hit[0] = true;
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Destroyer"
	}
	@Test
	void CheckDestroyerGetShipType() {
		Destroyer test1 = new Destroyer();
		assertTrue(test1.getShipType().contains("Destroyer"));
	}

	//TESTING Submarine ================================================================================

	//Tests if Submarine constructor works and returns length 2
	@Test
	void CreateSubmarineAndTest() {
		Submarine test = new Submarine(); 
		assertEquals(test.getLength(), 1);
	}

	//Tests if Submarine constructor works and returns hit[] all initialized to false
	@Test
	void CheckSubmarineHitArray() {
		Submarine test = new Submarine();
		assertEquals(test.hit[0], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckSubmarineIsSunk() {
		Submarine test = new Submarine();
		test.hit[0] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckSubmarineIsNotSunk() {
		Submarine test = new Submarine();
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Submarine"
	}
	@Test
	void CheckSubmarineGetShipType() {
		Submarine test1 = new Submarine();
		assertTrue(test1.getShipType().contains("Submarine"));
	}

	//TESTING emptySea ================================================================================

	//Tests if EmptySea constructor works and returns length 1
	@Test
	void CreateemptySeaAndTest() {
		EmptySea test = new EmptySea(); 
		assertEquals(test.getLength(), 1);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckEmptySeaIsSunk() {
		EmptySea test = new EmptySea();
		assertFalse(test.isSunk());
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckEmptySeaIsNotSunk() {
		EmptySea test = new EmptySea();
		assertTrue(test.toString().contains("-"));

		//Tests if getShipType will return "Submarine"
	}
	@Test
	void CheckEmptySeaGetShipType() {
		EmptySea test1 = new EmptySea();
		assertTrue(test1.getShipType().contains("empty"));
	}

	//Tests if shootAt emptySea will return false, since there is no ship at location [0][1]
	@Test
	void CheckEmptySeaShootAt() {
		EmptySea test1 = new EmptySea();
		assertFalse(test1.shootAt(0, 1));
	}

	//TESTING SHIP ===Since can't instantiate Ship class, will use Battleship as testing case===============

	//Testing if ship row setters/getters work as expected
	@Test
	void CheckShipSettersGettersRow() {
		Battleship test = new Battleship();
		test.setBowRow(0);
		assertEquals(test.getBowRow(), 0);
	}
	
	//Testing if ship column setters/getters work as expected
	@Test
	void CheckShipSettersGettersColumn() {
		Battleship test = new Battleship();
		test.setBowColumn(0);
		assertEquals(test.getBowColumn(), 0);
	}
	
	//Testing if ship horizontal setters/getters work as expected
	@Test
	void CheckShipSettersGettersHorizontal() {
		Battleship test = new Battleship();
		Battleship test2 = new Battleship();
		test.setHorizontal(false);
		test2.setHorizontal(true);
		assertFalse(test.isHorizontal());
		assertTrue(test2.isHorizontal());
		
	}
	
	//Testing if ship can be placed
	@Test
	void CheckokToPlaceShipAt() {
		//TODO need to test placeships
	}
	
	//TESTING OCEAN ==================================================================
	
	//Testing setShips method TODO TO CHECK IF THIS IS ENOUGH
	@Test
	void CheckSetShip() {
		Battleship test = new Battleship();
		Ocean ocean = new Ocean();
		ocean.setShips(0, 5, test);
	}

	//Test if shotsFired is updated as expected and BOTTOM RIGHT CORNER of grid should mostly return false
	@Test 
	void CheckShotsFired() {
		Ocean ocean = new Ocean();
		ocean.shootAt(0, 5);
		assertEquals(ocean.getShotsFired(), 1);
		assertFalse(ocean.shootAt(9, 9));
		
	}
	
	//Test if shotsFired is updated as expected, this test no shots are fired, so Hitscount(); must be zero
	@Test 
	void CheckgetHitsCount() {
		Ocean ocean = new Ocean();
		assertEquals(ocean.getHitsCount(), 0);
		
	}
	
	
	//Test if shipsSunk getter works as expected
	@Test 
	void CheckShipsSunk() {
		Ocean ocean = new Ocean();
		assertEquals(ocean.getShipsSunk(), 0);
		
	}
	
	//Test if getShipArray() returns as expected and should not be null because it creates emptySea in all cells
	@Test 
	void CheckGetShipArray() {
		Ocean ocean = new Ocean();
		assertNotNull(ocean.getShipArray());
	}
	
	//Test if isOccupied() returns false when the ocean is first instantiated, because all emptySeas are in each location
	@Test 
	void CheckisOccupied() {
		Ocean ocean = new Ocean();
		assertFalse(ocean.isOccupied(0, 2));
	}
	
	//Test if setUserinputs() setter is working as expected
	@Test 
	void CheckUserInputs() {
		Ocean ocean = new Ocean();
		int[] input = {2,4};
		ocean.setUserInputs(input);
		assertNotNull(ocean.userInputs.get(0));
	}
	
	
	
	
	
	
	
}
