package vehicle.types;

public abstract class Watercraft extends CraftVehicle{
	
	public Watercraft(String name) {
		super(name, Type.FLOATED, "knots");
	}

}

