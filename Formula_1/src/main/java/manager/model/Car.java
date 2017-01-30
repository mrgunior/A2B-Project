package main.java.manager.model;

import org.json.simple.JSONObject;

public class Car
{
	private int			speed;
	private int			acceleration;
	private int			handling;
	private int			braking;
	private int			weight;
	private Upgrades	upgrades;
  
	private enum carVar{speed, acceleration, handling, braking, weight, upgrades, other};
	private enum upgradesVar {down, aero, gearbox, engine, susp, tires, weightRed, other};
  
	private int			crashChance;
	private int 		riskMultiplier;
	
	private String upgradesJsonPath = "./data/upgrades.json";

	public Car(int speed, int acceleration, int handling, int braking, int weight, Upgrades upgrades, int crashChance, int riskMultiplier)
	{
		this.speed = speed;
		this.acceleration = acceleration;
		this.handling = handling;
		this.braking = braking;
		this.weight = weight;
		this.upgrades = upgrades;
		this.crashChance = crashChance;
		this.riskMultiplier = riskMultiplier;
	}
	
	public int getCrashChance() {
		return this.crashChance;
	}
	
	public void setCrashChance(int crashChance) {
		this.crashChance = crashChance;
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
	
	public carVar[] getCarVar()
	{
		return carVar.values();
	}

	public void upgrade(String type)
	{
		upgrades.upgrade(type);

		// Getting level
		int curLvl = getCurrentLevel(type);

		if (curLvl <= 5)
		{
			// Getting all the upgrade info of the next level
			JSONObject upgradeSpecs = (JSONObject) GameController.readNestedObject(upgradesJsonPath,
					new String[] { "upgrades", type, "level" + curLvl });
			JSONObject positive = (JSONObject) upgradeSpecs.get("positive");
			JSONObject negative = (JSONObject) upgradeSpecs.get("negative");

			System.out.println("All upgrades:  " + upgradeSpecs);

			int speedAmount = 0, accelerationAmount = 0, handlingAmount = 0, brakingAmount = 0, weightAmount = 0;
			int[] upgradeAmounts = new int[] {speedAmount, accelerationAmount, handlingAmount, brakingAmount, weightAmount};
			
			String[] upgradeTypes = new String[] { "speed", "acceleration", "handling", "braking", "weight" };
			
			for (int i = 0; i < upgradeTypes.length; i++)
			{
				if (positive.get(upgradeTypes[i]) != null)
				{
					int amount = Integer.parseInt(positive.get(upgradeTypes[i]).toString());
					//System.out.println(upgradeTypes[i] + ": " + amount);

					setUpgradeAmounts(amount, upgradeTypes[i], upgradeAmounts);
				}

				if (negative.get(upgradeTypes[i]) != null)
				{
					int amount = Integer.parseInt(negative.get(upgradeTypes[i]).toString());
					//System.out.println(upgradeTypes[i] + ": " + amount);

					setUpgradeAmounts(amount, upgradeTypes[i], upgradeAmounts);
				}

			}

			incrementSpeed(upgradeAmounts[0]);
			incrementAcceleration(upgradeAmounts[1]);
			incrementHandling(upgradeAmounts[2]);
			incrementBraking(upgradeAmounts[3]);
			incrementWeight(upgradeAmounts[4]);
		}
	}
	
	/**
	 * Used only to split up the upgrade method
	 * @param type - The type that needs to be upgraded
	 * @return int - The current level of the upgrade type
	 */
	public int getCurrentLevel(String type)
	{
		switch (upgradesVar.valueOf(type))
		{
		case aero:
			return upgrades.getAero();
		case down:
			return upgrades.getDown();
		case engine:
			return upgrades.getEngine();
		case gearbox:
			return upgrades.getGearbox();
		case susp:
			return upgrades.getSusp();	
		case tires:
			return upgrades.getTires();
		case weightRed:
			return upgrades.getWeightRed();
		default:
			return 0;
		}
	}

	public void setUpgradeAmounts(int amount, String upgradeType, int[] upgradeAmounts)
	{
		switch (carVar.valueOf(upgradeType))
		{
		case speed:
			upgradeAmounts[0] = amount;
			break;
		case acceleration:
			upgradeAmounts[1] = amount;
			break;
		case handling:
			upgradeAmounts[2] = amount;
			break;
		case braking:
			upgradeAmounts[3] = amount;
			break;
		case weight:
			upgradeAmounts[4] = amount;
			break;
		default:
			break;
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

	public void setRiskMultiplier(int riskMultiplier) {
		this.riskMultiplier = riskMultiplier;		
	}
	
	public int getRiskMultiplier() {
		return riskMultiplier;
	}
}
