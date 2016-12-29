package manager.model;

public class Car {
	private Engine engine;
	
	/**
	 * 
	 * @param engine
	 */
	public Car(Engine engine)
	{
		this.engine = engine;
	}
	
	/**
	 * 
	 * @return engine
	 */
	public Engine getEngine(){
		return this.engine;
	}
	
	/**
	 * 
	 * @param engine
	 */
	public void setEngine(Engine engine){
		this.engine = engine;
	}
}
