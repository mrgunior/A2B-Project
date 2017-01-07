package Templates;

import java.util.Comparator;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import manager.model.Driver;

public class DriverResult implements Comparator<DriverResult>, Comparable<DriverResult>
{
	private int number = 0;
	private String name = "";
	private double time = 0;
	
	public String getName()
	{
		return name;
	}
	
	public double getTime()
	{
		return time;
	}
	
	public DriverResult()
	{
		
	}
	
	public DriverResult(int number, String name, double time)
	{
		this.number = number;
		this.name = name;
		this.time = time;
	}
	
	public String toString()
	{
		return (name + " (" + number + ") : " + time);
	}

	@Override
	public int compareTo(DriverResult driverResult)
	{
		return (this.name).compareTo(driverResult.getName());
	}

	@Override
	public int compare(DriverResult dR1, DriverResult dR2)
	{
		return (int) (dR1.getTime() - dR2.getTime());
	}
}
