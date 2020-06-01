package giopollo.progetto.Model;

public class Follower {
	
	private String name;
	private String location;
	
	public Follower() {
	}
	/**
	 * @param name
	 * @param location
	 */
	public Follower(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
