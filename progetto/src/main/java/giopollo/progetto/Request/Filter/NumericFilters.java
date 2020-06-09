package giopollo.progetto.Request.Filter;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Exception.E_Between;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

/**
 * Classe astratta per i filtri di tipo numerico
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public abstract class NumericFilters {
	
	/**
	 * Metodo Greater.
	 *
	 * @param lista lista dei follower dell'account
	 * @param a numero intero
	 * @return List di oggetti Follower filtrati
	 */
	protected abstract List<Follower> greater(List<Follower> lista, Integer a);

	/**
	 * Metodo Lower.
	 *
	 * @param lista lista dei follower dell'account
	 * @param a numero intero
	 * @return List di oggetti Follower filtrati
	 */
	protected abstract List<Follower> lower(List<Follower> lista, Integer a);

	/**
	 * Metodo Between.
	 *
	 * @param lista lista dei follower dell'account
	 * @param extremes ArrayList di numeri interi
	 * @return List di oggetti Follower filtrati
	 */
	public List<Follower> between(List<Follower> lista, ArrayList<Integer> extremes)
	{
		if(extremes.get(0)>extremes.get(1)) throw new E_Between(); //lancia un'eccezione se il primo numero è maggiore del secondo
		lista = greater(lista, extremes.get(0)); // applica il filtro greater, passando il primo estremo 
		lista = lower(lista, extremes.get(1)); //applica il filtro lower, passando il secondo estremo
		if(lista.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lista;
	}
	

}
