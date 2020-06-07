package giopollo.progetto.Request.Filter;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Exception.E_Between;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

// TODO: Auto-generated Javadoc
/**
 * The Class NumericFilters.
 */
public abstract class NumericFilters {
	
	/**
	 * Greater.
	 *
	 * @param lista the lista
	 * @param a the a
	 * @return the list
	 */
	protected abstract List<Follower> greater(List<Follower> lista, Integer a);

	/**
	 * Lower.
	 *
	 * @param lista the lista
	 * @param a the a
	 * @return the list
	 */
	protected abstract List<Follower> lower(List<Follower> lista, Integer a);

	/**
	 * Between.
	 *
	 * @param lista the lista
	 * @param extremes the extremes
	 * @return the list
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
