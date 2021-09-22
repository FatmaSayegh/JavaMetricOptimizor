package vehicle.types;

public abstract class DrivableVehicle extends Vehicle {

	private int noObjects;

	public DrivableVehicle(String name, Type type, int noObjects) {
		super(name, type, "miles/hr");
		this.noObjects = noObjects;
	}

	protected int getNoObjects() {
		return noObjects;
	}

	public void drive(Direction direction, double speed) {
		stopped = false;
		this.direction = direction;
		this.currentSpeed = speed;
	}

}
