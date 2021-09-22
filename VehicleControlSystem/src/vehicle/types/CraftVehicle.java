package vehicle.types;

public abstract class CraftVehicle extends Vehicle {
	private double steering;
	public CraftVehicle(String name, Type type, String speedUnit) {
		super(name, type, speedUnit);
	}

	public void streer(double degree, double speed) {
		this.currentSpeed = speed;
		this.steering = degree;
	}

	public double getSteering() {
		return steering;
	}

	public void setSteering(double degrees) {
		this.steering = degrees;
	}

}
