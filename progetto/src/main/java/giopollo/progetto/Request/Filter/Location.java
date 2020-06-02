package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Follower;

public class Location extends NumericFilters{
	@Override
	public List<Follower> greater(List<Follower> lista, Integer a) throws E_NoFollowerFound
	{
		lista.removeIf(f->(f.getLocation().length()<a));
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}
	
	@Override
	public List<Follower> lower(List<Follower> lista, Integer a) throws E_NoFollowerFound
	{
		lista.removeIf(f->(f.getLocation().length()>a));
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}
	
	public List<Follower> word(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().contains(a)));
		if(lf.isEmpty()) throw new E_wordNotFound();
		return lf;		
	}
	
	public List<Follower> fullLoc(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().equals(a)));
		if(lf.isEmpty()) throw new E_wordNotFound();
		return lf;	
	}
}
