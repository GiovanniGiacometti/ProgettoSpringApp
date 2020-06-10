package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Model.Follower;

/**
 * Interfaccia per i filtri di tipo stringa
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public interface StringFilter {
	
	/**
	 * Filtro che restituisce i follower nella cui location compare la parola inserita dall'utente
	 *
	 * @param lf lista di follower dell'account
	 * @param a numero di caratteri inserito dall'utente
	 * @return List di oggetti Follower filtrati
	 */
	public List<Follower> word(List<Follower> lf, String a);
	
	
	/**
	 * Filtro che restituisce i follower la cui location è uguale alla parola inserita dall'utente
	 *
	 * @param lf lista di follower dell'account
	 * @param a numero di caratteri inserito dall'utente
	 * @return List di oggetti Follower filtrati
	 */
	public List<Follower> fullLoc(List<Follower> lf, String a);
}
