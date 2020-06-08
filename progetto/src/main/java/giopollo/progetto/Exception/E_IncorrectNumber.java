package giopollo.progetto.Exception;

/**
 * Classe 
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class E_IncorrectNumber extends E_Project {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Ottenere il messaggio da stampare
	 *
	 * @return String
	 */
	public String getMessage() {
		return "Impossibile convertire. Inserisci un numero corretto!";
	}

}
