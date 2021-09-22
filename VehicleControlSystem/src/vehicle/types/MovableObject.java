package vehicle.types;

public abstract class MovableObject {

	protected Direction direction;
	protected boolean stopped;
	protected double currentSpeed = 0;
	private String speedUnit;

	public MovableObject(String unit) {
		this.speedUnit = unit;
	}

	public Direction getDirection() {
		return direction;
	}

	public boolean isStopped() {
		return stopped;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public void stop() {
		this.currentSpeed = 0;
		this.direction = Direction.STATIONARY;
		this.stopped = true;
	}

	public String printSpeed() {
		return String.valueOf(this.currentSpeed) + this.speedUnit;
	}

}

enum Direction {
	FORWARD, BACKWARD, LEFT, RIGHT, STATIONARY
}
