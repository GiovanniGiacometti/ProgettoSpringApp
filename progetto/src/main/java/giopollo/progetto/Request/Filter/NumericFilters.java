package giopollo.progetto.Request.Filter;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Exception.E_Between;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

public abstract class NumericFilters {
	protected abstract List<Follower> greater(List<Follower> lista, Integer a) throws E_NoFollowerFound;

	protected abstract List<Follower> lower(List<Follower> lista, Integer a) throws E_NoFollowerFound;

	public List<Follower> between(List<Follower> lista, ArrayList<Integer> b) throws E_Between, E_NoFollowerFound
	{
		if(b.get(0)>b.get(1)) throw new E_Between();
		lista = greater(lista, b.get(0));
		lista = lower(lista, b.get(1));
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}
	

}
