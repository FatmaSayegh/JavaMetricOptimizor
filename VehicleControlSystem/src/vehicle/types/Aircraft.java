package vehicle.types;

public abstract class Aircraft extends CraftVehicle {

	public Aircraft(String name) {
		super(name, Type.SKIED, "km/hr");
	}
}
