package giopollo.progetto.Model;

/**
 * Classe che crea l'oggetto Follower e i relativi metodi
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class Follower {
	
	/** The name. */
	private String name; //nome dell'utente 
	
	/** The location. */
	private String location; // location dell'utente 
	
	/** The followers count. */
	private int followers_count; //numero degli account che seguono l'utente
	
	/** The friends count. */
	private int friends_count; //numero degli account seguiti dall'utente
	
	/**
	 * Costruttore di un Follower
	 */
	public Follower() {
	}
	
	/**
	 * Costruttore di un Follower con "parametri"
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
	 * Ottenere il numero dei follower dell'account
	 *
	 * @return int numero intero
	 */
	public int getFollowers_count() {
		return followers_count;
	}
	
	/**
	 * Settare il numero dei follower dell'account
	 *
	 * @param followers_count
	 */
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	
	/**
	 * Ottenere il numero degli amici dell'account
	 *
	 * @return int numero intero
	 */
	public int getFriends_count() {
		return friends_count;
	}
	
	/**
	 * Settare il numero degli amici dell'account
	 *
	 * @param friends_count
	 */
	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}
	
	/**
	 * Ottnere il nome dell'account
	 *
	 * @return String
	 */

	public String getName() {
		return name;
	}

	/**
	 * Settare il nome dell'account
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Ottenere la location
	 *
	 * @return String 
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Settare la location
	 *
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
