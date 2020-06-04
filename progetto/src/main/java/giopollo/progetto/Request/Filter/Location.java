package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Follower;

public class Location extends NumericFilters{
	@Override
	public List<Follower> greater(List<Follower> lf, Integer a)
	{
		lf.removeIf(f->(f.getLocation().length()<a));  //rimuove gli utenti con una location minore di "a" caratteri
		if(lf.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;
	}
	
	@Override
	public List<Follower> lower(List<Follower> lf, Integer a)
	{
		lf.removeIf(f->(f.getLocation().length()>a));  //rimuove gli utenti con una location maggiore di "a" caratteri
		if(lf.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;
	}
	
	public List<Follower> word(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().contains(a))); //rimuove gli utenti la cui location non contiene la stringa "a"
		if(lf.isEmpty()) throw new E_wordNotFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;		
	}
	
	public List<Follower> fullLoc(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().equals(a))); //rimuove gli utenti la cui location non sia identica alla stringa "a"
		if(lf.isEmpty()) throw new E_wordNotFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;	
	}
}
