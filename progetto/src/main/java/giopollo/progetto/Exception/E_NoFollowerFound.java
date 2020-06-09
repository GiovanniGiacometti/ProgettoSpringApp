package giopollo.progetto.Exception;

/**
 * Eccezione lanciata se non ci sono follower che rispettano i filtri
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class E_NoFollowerFound extends E_Project {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare.
	 *
	 * @return String
	 */
	@Override
	public String getMessage() {
		return "Nessun follower rispetta questi filtri!";
	}

}
