package manager.model;

public class Car {
	
	private int speed;
	private int acceleration;
	private int handling;
	private int braking;
	private int weight;
	private Upgrades upgrades;
	
	public Car(int speed, int acceleration, int handling, int braking, int weight, Upgrades upgrades) {
		
		this.setSpeed(speed);
		this.setAcceleration(acceleration);
		this.setHandling(handling);
		this.setBraking(braking);
		this.setWeight(weight);
		this.setUpgrades(upgrades);
		
	}
	
	public Car()
	{
		//TODO Set all the default values of the car
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

	public Upgrades getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(Upgrades upgrades) {
		this.upgrades = upgrades;
	}	
}
