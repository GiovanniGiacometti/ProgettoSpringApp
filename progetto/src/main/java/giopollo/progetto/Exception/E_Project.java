package giopollo.progetto.Exception;

/**
 * Classe 
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public abstract class E_Project extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Ottenere il messaggio da stampare
	 *
	 * @return String
	 */
	public abstract String getMessage();
}
