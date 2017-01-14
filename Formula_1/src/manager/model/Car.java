package manager.model;

import org.json.simple.JSONObject;

import manager.controller.GameController;

public class Car
{

	private int			speed;
	private int			acceleration;
	private int			handling;
	private int			braking;
	private int			weight;
	private Upgrades	upgrades;
	
	private String upgradesJsonPath = "./data/upgrades.json";

	public Car(int speed, int acceleration, int handling, int braking, int weight, Upgrades upgrades)
	{

		this.speed = speed;
		this.acceleration = acceleration;
		this.handling = handling;
		this.braking = braking;
		this.weight = weight;
		this.upgrades = upgrades;
	}

	public Car()
	{
		// TODO Set all the default values of the car
	}

	public int getSpeed()
	{
		return this.speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public int getAcceleration()
	{
		return this.acceleration;
	}

	public void setAcceleration(int acceleration)
	{
		this.acceleration = acceleration;
	}

	public int getHandling()
	{
		return this.handling;
	}

	public void setHandling(int handling)
	{
		this.handling = handling;
	}

	public int getBraking()
	{
		return this.braking;
	}

	public void setBraking(int braking)
	{
		this.braking = braking;
	}

	public int getWeight()
	{
		return this.weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public Upgrades getUpgrades()
	{
		return this.upgrades;
	}

	public void setUpgrades(Upgrades upgrades)
	{
		this.upgrades = upgrades;
	}

	public void incrementSpeed(int amount)
	{
		this.speed += amount;
	}

	public void incrementAcceleration(int amount)
	{
		this.acceleration += amount;
	}

	public void incrementHandling(int amount)
	{
		this.handling += amount;
	}

	public void incrementBraking(int amount)
	{
		this.braking += amount;
	}

	public void incrementWeight(int amount)
	{
		this.weight += amount;
	}

	public void upgrade(String type)
	{
		upgrades.upgrade(type);

		// Getting level
		int curLvl = 0;
		switch (type)
		{
		case "aero":
			curLvl = upgrades.getAero();
			break;
		case "down":
			curLvl = upgrades.getDown();
			break;
		case "engine":
			curLvl = upgrades.getEngine();
			break;
		case "gearbox":
			curLvl = upgrades.getGearbox();
			break;
		case "susp":
			curLvl = upgrades.getSusp();
			break;
		case "tires":
			curLvl = upgrades.getTires();
			break;
		case "weightRed":
			curLvl = upgrades.getWeightRed();
			break;
		default:
			break;
		}
		
		if (curLvl <= 5)
		{
			// Getting all the upgrade info of the next level
			JSONObject upgradeSpecs = (JSONObject) GameController.readNestedObject(upgradesJsonPath,
					new String[] { "upgrades", type, "level" + curLvl });
			JSONObject positive = (JSONObject) upgradeSpecs.get("positive");
			JSONObject negative = (JSONObject) upgradeSpecs.get("negative");

			System.out.println("All upgrades:  " + upgradeSpecs);

			int speedAmount = 0, accelerationAmount = 0, handlingAmount = 0, brakingAmount = 0, weightAmount = 0;
			String[] upgradeTypes = new String[] { "speed", "acceleration", "handling", "braking", "weight" };
			for (int i = 0; i < upgradeTypes.length; i++)
			{
				if (positive.get(upgradeTypes[i]) != null)
				{
					int amount = Integer.parseInt(positive.get(upgradeTypes[i]).toString());
					System.out.println(upgradeTypes[i] + ": " + amount);

					switch (upgradeTypes[i])
					{
					case "speed":
						speedAmount = amount;
						break;
					case "acceleration":
						accelerationAmount = amount;
						break;
					case "handling":
						handlingAmount = amount;
						break;
					case "braking":
						brakingAmount = amount;
						break;
					case "weightRed":
						weightAmount = amount;
						break;
					default:
						break;
					}
				}

				if (negative.get(upgradeTypes[i]) != null)
				{

					int amount = Integer.parseInt(negative.get(upgradeTypes[i]).toString());
					System.out.println(upgradeTypes[i] + ": " + amount);

					switch (upgradeTypes[i])
					{
					case "speed":
						speedAmount = amount;
						break;
					case "acceleration":
						accelerationAmount = amount;
						break;
					case "handling":
						handlingAmount = amount;
						break;
					case "braking":
						brakingAmount = amount;
						break;
					case "weightRed":
						weightAmount = amount;
						break;
					default:
						break;
					}
				}

			}

			incrementSpeed(speedAmount);
			incrementAcceleration(accelerationAmount);
			incrementHandling(handlingAmount);
			incrementBraking(brakingAmount);
			incrementWeight(weightAmount);
		}
	}

	public void upgradeAero()
	{
		upgrades.upgradeAero();
	}

	public void upgradeDown()
	{
		upgrades.upgradeDown();
	}

	public void upgradeEngine()
	{
		upgrades.upgradeEngine();
	}

	public void upgradeGearbox()
	{
		upgrades.upgradeGearbox();
	}

	public void upgradeSusp()
	{
		upgrades.upgradeSusp();
	}

	public void upgradeTires()
	{
		upgrades.upgradeTires();
	}

	public void upgradeWeightRed()
	{
		upgrades.upgradeWeightRed();
	}

	public String toString()
	{
		return "<Car[speed: " + this.speed + ", braking: " + this.braking + ", acceleration: " + this.acceleration + ", weight: "
				+ this.weight + ", handling: " + this.handling + ", Upgrades[" + this.upgrades.toString() + "]>]>";
	}
}
