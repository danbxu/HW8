
public class Submarine extends Ship {

	//TODO constructor 
	
	//create an constructor to override
	// one space
	
	Submarine() {
		this.length = 1;
	}
	
	@Override 
	public int getLength() {
		return length;
	}
	
	@Override
	String getShipType() {
		return "Submarine";
	}
	
}
