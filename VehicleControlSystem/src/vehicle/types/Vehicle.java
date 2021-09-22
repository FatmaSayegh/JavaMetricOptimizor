package vehicle.types;

public abstract class Vehicle extends MovableObject {

	private String name;
	private Type type;

	
	public Vehicle(String name, Type type, String speedUnit) {
		super(speedUnit);
		this.name = name;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

enum Type {
	WHEELED, TRACKED, RAILED, SKIED, FLOATED
}
