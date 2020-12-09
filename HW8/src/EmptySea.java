
public class EmptySea extends Ship {

	
	EmptySea() {
		this.length = 1;
	}
	
	@Override
	String getShipType() {
		return "empty";
	}
	
	//also need to override isSunk, shootAt, toString

}
