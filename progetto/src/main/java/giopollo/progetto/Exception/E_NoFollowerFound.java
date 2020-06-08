package giopollo.progetto.Exception;

/**
 * Classe 
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class E_NoFollowerFound extends E_Project {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Ottenere il messaggio da stampare.
	 *
	 * @return String
	 */
	@Override
	public String getMessage() {
		return "Nessun follower trovato!";
	}

}
