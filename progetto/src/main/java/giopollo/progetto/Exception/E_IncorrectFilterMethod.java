package giopollo.progetto.Exception;

/**
 * Eccezione lanciata se i metodi dei filtri sono errati
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class E_IncorrectFilterMethod extends E_Project {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	@Override
	public String getMessage() {
		return "Il body del filtro non è valido! ";
	}

}
