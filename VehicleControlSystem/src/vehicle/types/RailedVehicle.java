package vehicle.types;

public abstract class RailedVehicle extends DrivableVehicle{
	
	public RailedVehicle(String name, int noObjects) {
		super(name, Type.RAILED, noObjects);
	}
	/*
	public int getNocarriages() {
		return getNoObjects();
	}

	public void setNocarriages(int nowheels) {
		setNoObjects(nowheels);
	}
*/
}
