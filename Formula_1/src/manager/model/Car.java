package manager.model;

public class Car {
	private int speed;
	private int acceleration;
	private int handling;
	private int braking;
	private int weight;
	
	public Car(int speed, int acceleration, int handling, int braking, int weight) {
		
		this.setSpeed(speed);
		this.setAcceleration(acceleration);
		this.setHandling(handling);
		this.setBraking(braking);
		this.setWeight(weight);
		
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public int getHandling() {
		return handling;
	}

	public void setHandling(int handling) {
		this.handling = handling;
	}

	public int getBraking() {
		return braking;
	}

	public void setBraking(int braking) {
		this.braking = braking;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
