package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Model.Follower;


/**
 * Interfaccia per i filtri di tipo numerico
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public interface NumericFilter {
	
	/**
	 * Metodo Greater.
	 *
	 * @param lista lista dei follower dell'account
	 * @param a numero intero
	 * @return List di oggetti Follower filtrati
	 */
	public List<Follower> greater(List<Follower> lista, Integer a);
	
	/**
	 * Metodo Lower.
	 *
	 * @param lista lista dei follower dell'account
	 * @param a numero intero
	 * @return List di oggetti Follower filtrati
	 */
	public List<Follower> lower(List<Follower> lista, Integer a);
	
}
