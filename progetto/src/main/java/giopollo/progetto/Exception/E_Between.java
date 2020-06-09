package giopollo.progetto.Exception;

/**
 * Eccezione lanciata se i parametri del filtro between sono errati
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class E_Between extends E_Project{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Ottenere il messaggio da stampare
	 *
	 * @return String
	 */
	@Override
	public String getMessage()
	{
		return "Il primo numero è maggiore del secondo!";
	}
}
