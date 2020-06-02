package giopollo.progetto.Request.Filter;

import java.util.List;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

public class NumFriends extends NumericFilters{

	@Override
	public List<Follower> greater(List<Follower> lista, Integer a) throws E_NoFollowerFound {
		lista.removeIf(f->(f.getFriends_count()<a));
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}

	@Override
	public List<Follower> lower(List<Follower> lista, Integer a) throws E_NoFollowerFound {
		lista.removeIf(f->(f.getFriends_count()>a));
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}
}
