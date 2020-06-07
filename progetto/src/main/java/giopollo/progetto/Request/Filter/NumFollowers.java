package giopollo.progetto.Request.Filter;

import java.util.List;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

// TODO: Auto-generated Javadoc
/**
 * The Class NumFollowers.
 */
public class NumFollowers extends NumericFilters{

	/**
	 * Greater.
	 *
	 * @param lista the lista
	 * @param a the a
	 * @return the list
	 */
	@Override
	public List<Follower> greater(List<Follower> lista, Integer a){
		lista.removeIf(f->(f.getFollowers_count()<a)); //rimuove gli utenti con un numero di follower inferiore ad "a"
		if(lista.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lista;
	}

	/**
	 * Lower.
	 *
	 * @param lista the lista
	 * @param a the a
	 * @return the list
	 */
	@Override
	public List<Follower> lower(List<Follower> lista, Integer a) {
		lista.removeIf(f->(f.getFollowers_count()>a)); //rimuove gli utenti con un numero di follower superiore ad "a"
		if(lista.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lista;
	}
}
