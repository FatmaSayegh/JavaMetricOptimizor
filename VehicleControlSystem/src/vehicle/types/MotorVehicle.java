package vehicle.types;

public abstract class MotorVehicle extends DrivableVehicle{
		
	public MotorVehicle(String name, int noObjects) {
		super(name, Type.WHEELED, noObjects);
	}
	/*
	public int getNowheels() {
		return getNoObjects();
	}

	public void setNowheels(int nowheels) {
		setNoObjects(nowheels);
	}
		*/	
}
