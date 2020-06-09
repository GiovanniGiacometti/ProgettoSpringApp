package giopollo.progetto.Exception;

/**
 * Classe astratta da cui ereditano le eccezioni del progetto
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public abstract class E_Project extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	public abstract String getMessage();
}
