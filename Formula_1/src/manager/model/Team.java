package manager.model;

public class Team {
	
	private String name;
	private int teamID, balance;
	private Driver driver1, driver2;
	private Car car;

	public Team(String name, int teamID, int balance, Driver driver1, Driver driver2, Car car) {

		this.setName(name);
		this.setBalance(balance);
		this.setTeamID(teamID);
		this.setDriver1(driver1);
		this.setDriver2(driver2);
		this.setCar(car);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Driver getDriver2() {
		return driver2;
	}

	public void setDriver2(Driver driver2) {
		this.driver2 = driver2;
	}

	public Driver getDriver1() {
		return driver1;
	}

	public void setDriver1(Driver driver1) {
		this.driver1 = driver1;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean equals(Team obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Team)) {
			return false;
		}
		Team other = (Team) obj;
		if (!(name.equals(other.name))) {
			return false;
		}
		if (balance != other.balance) {
			return false;
		}
		if (teamID != other.teamID) {
			return false;
		}
		if (!(driver1.equals(other.driver1))) {
			return false;
		}
		if (!(driver2.equals(other.driver2))) {
			return false;
		}
		if (!(car.equals(other.car))) {
			return false;
		}
		return true;
	}
	
}
