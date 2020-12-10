
public class Destroyer extends Ship {

	
	
	Destroyer() {
		this.length = 2;
	}
	
	@Override 
	public int getLength() {
		return length;
	}
	
	@Override
	String getShipType() {
		return "Destroyer";
	}

}
