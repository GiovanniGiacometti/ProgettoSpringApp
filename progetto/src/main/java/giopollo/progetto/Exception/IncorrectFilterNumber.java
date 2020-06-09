package giopollo.progetto.Exception;

/**
 * Eccezione lanciata se il numero dei filtri non corrisponde con i filtri passati
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class IncorrectFilterNumber extends E_Project {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	@Override
	public String getMessage() {
		return "Numero incorretto!";
	}

}
