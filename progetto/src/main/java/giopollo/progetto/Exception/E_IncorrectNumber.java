package giopollo.progetto.Exception;

/**
 * Eccezione lanciata se il numero dei filtri indicato non è scritto correttamente
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class E_IncorrectNumber extends E_Project {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	public String getMessage() {
		return "Impossibile convertire. Inserisci un numero corretto!";
	}

}
