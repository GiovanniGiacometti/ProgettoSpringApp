package giopollo.progetto.Model;

public class Follower {
	
	private String name;
	private String location;
	private int followers_count;
	private int friends_count;
	
	public Follower() {
	}
	
	public Follower(String name, String location, int followers_count, int friends_count) {
		super();
		this.name = name;
		this.location = location;
		this.followers_count = followers_count;
		this.friends_count = friends_count;
	}
	
	public int getFollowers_count() {
		return followers_count;
	}
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	public int getFriends_count() {
		return friends_count;
	}
	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}
	
	/**
	 * @param name
	 * @param location
	 */

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
