package giopollo.progetto.Request.Filter;

import java.util.List;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

/**
 * Classe che estende NumericFilters
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class NumFollowers extends NumericFilters{

	/**
	 * Metodo Greater.
	 *
	 * @param lista lista dei follower dell'account
	 * @param a numero intero
	 * @return List di oggetti Follower
	 */
	@Override
	public List<Follower> greater(List<Follower> lista, Integer a){
		lista.removeIf(f->(f.getFollowers_count()<a)); //rimuove gli utenti con un numero di follower inferiore ad "a"
		if(lista.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lista;
	}

	/**
	 * Metodo Lower.
	 *
	 * @param lista lista dei follower dell'account
	 * @param a numero intero
	 * @return List di oggetti Follower
	 */
	@Override
	public List<Follower> lower(List<Follower> lista, Integer a) {
		lista.removeIf(f->(f.getFollowers_count()>a)); //rimuove gli utenti con un numero di follower superiore ad "a"
		if(lista.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lista;
	}
}
