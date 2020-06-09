package giopollo.progetto.Model;

/**
 * Classe che crea l'oggetto Follower e i relativi metodi
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class Follower {
	
	private String name; //nome dell'utente 
	
	private String location; // location dell'utente 
	
	private int followers_count; //numero degli account che seguono l'utente
	
	private int friends_count; //numero degli account seguiti dall'utente
	
	/**
	 * Costruttore di Follower
	 */
	public Follower() {
	}
	
	/**
	 * Costruttore di Follower con "parametri"
	 *
	 * @param name nome dell'account
	 * @param location
	 * @param followers_count numero di follower dell'account
	 * @param friends_count numero di amici dell'account
	 */
	public Follower(String name, String location, int followers_count, int friends_count) {
		super();
		this.name = name;
		this.location = location;
		this.followers_count = followers_count;
		this.friends_count = friends_count;
	}
	
	/**
	 * Ottiene il numero dei follower dell'account
	 *
	 * @return int
	 */
	public int getFollowers_count() {
		return followers_count;
	}
	
	/**
	 * Setta il numero dei follower dell'account
	 *
	 * @param followers_count
	 */
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	
	/**
	 * Ottiene il numero degli amici dell'account
	 *
	 * @return int
	 */
	public int getFriends_count() {
		return friends_count;
	}
	
	/**
	 * Setta il numero degli amici dell'account
	 *
	 * @param friends_count
	 */
	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}
	
	/**
	 * Ottiene il nome dell'account
	 *
	 * @return String
	 */

	public String getName() {
		return name;
	}

	/**
	 * Setta il nome dell'account
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Ottiene la location
	 *
	 * @return String 
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Setta la location
	 *
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
