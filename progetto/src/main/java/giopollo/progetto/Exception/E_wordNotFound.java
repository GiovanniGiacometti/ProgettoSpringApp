package giopollo.progetto.Exception;

/**
 * Eccezione lanciata se la parola da ricercare non viene trovata nelle location
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class E_wordNotFound extends E_Project {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	@Override
	public String getMessage()
	{
		return "Nessun follower ha questa parola nella descrizione!";
	}

}
