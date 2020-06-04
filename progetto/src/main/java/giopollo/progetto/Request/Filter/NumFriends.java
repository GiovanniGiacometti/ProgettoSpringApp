package giopollo.progetto.Request.Filter;

import java.util.List;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

public class NumFriends extends NumericFilters{

	@Override
	public List<Follower> greater(List<Follower> lista, Integer a){
		lista.removeIf(f->(f.getFriends_count()<a)); //rimuove gli utenti con un numero di friends inferiore ad "a"
		if(lista.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lista;
	}

	@Override
	public List<Follower> lower(List<Follower> lista, Integer a) {
		lista.removeIf(f->(f.getFriends_count()>a)); //rimuove gli utenti con un numero di friends superiore ad "a"
		if(lista.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lista;
	}
}
