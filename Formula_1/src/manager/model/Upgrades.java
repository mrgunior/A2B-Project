package manager.model;

public class Upgrades {
	
	private int down, aero, gearbox, engine, susp, tires, weightRed;
	
	public Upgrades (int down, int aero, int gearbox, int engine, int susp, int tires, int weightRed) {
		
		this.setAero(aero);
		this.setDown(down);
		this.setEngine(engine);
		this.setGearbox(gearbox);
		this.setSusp(susp);
		this.setTires(tires);
		this.setWeightRed(weightRed);
		
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getAero() {
		return aero;
	}

	public void setAero(int aero) {
		this.aero = aero;
	}

	public int getGearbox() {
		return gearbox;
	}

	public void setGearbox(int gearbox) {
		this.gearbox = gearbox;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public int getSusp() {
		return susp;
	}

	public void setSusp(int susp) {
		this.susp = susp;
	}

	public int getWeightRed() {
		return weightRed;
	}

	public void setWeightRed(int weightRed) {
		this.weightRed = weightRed;
	}

	public int getTires() {
		return tires;
	}

	public void setTires(int tires) {
		this.tires = tires;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Upgrades))
		{
			return false;
		}
		Upgrades other = (Upgrades) obj;
		if (aero != other.aero)
		{
			return false;
		}
		if (down != other.down)
		{
			return false;
		}
		if (engine != other.engine)
		{
			return false;
		}
		if (gearbox != other.gearbox)
		{
			return false;
		}
		if (susp != other.susp)
		{
			return false;
		}
		if (tires != other.tires)
		{
			return false;
		}
		if (weightRed != other.weightRed)
		{
			return false;
		}
		return true;
	}
}
