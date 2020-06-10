package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Follower;

/**
 * Classe per filtrare la location
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class Location extends BetweenFilter implements StringFilter{
	
	/**
	 * Filtro che restituisce i follower la cui location ha più caratteri rispetto al numero inserito dall'utente
	 *
	 * @param lf lista di follower dell'account
	 * @param a numero di caratteri inserito dall'utente
	 * @return List di oggetti Follower filtrati
	 */
	@Override
	public List<Follower> greater(List<Follower> lf, Integer a)
	{
		lf.removeIf(f->(f.getLocation().length()<a));  //rimuove gli utenti con una location minore di "a" caratteri
		if(lf.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;
	}
	
	/**
	 * Filtro che restituisce i follower la cui location ha meno caratteri rispetto al numero inserito dall'utente
	 *
	 * @param lf lista di follower dell'account
	 * @param a numero di caratteri inserito dall'utente
	 * @return List di oggetti Follower filtrati
	 */
	@Override
	public List<Follower> lower(List<Follower> lf, Integer a)
	{
		lf.removeIf(f->(f.getLocation().length()>a));  //rimuove gli utenti con una location maggiore di "a" caratteri
		if(lf.isEmpty()) throw new E_NoFollowerFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;
	}
	
	
	/**
	 * Filtro che restituisce i follower nella cui location compare la parola inserita dall'utente
	 *
	 * @param lf lista di follower dell'account
	 * @param a numero di caratteri inserito dall'utente
	 * @return List di oggetti Follower filtrati
	 */
	@Override
	public List<Follower> word(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().contains(a))); //rimuove gli utenti la cui location non contiene la stringa "a"
		if(lf.isEmpty()) throw new E_wordNotFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;		
	}
	

	/**
	 * Filtro che restituisce i follower la cui location è uguale alla parola inserita dall'utente
	 *
	 * @param lf lista di follower dell'account
	 * @param a numero di caratteri inserito dall'utente
	 * @return List di oggetti Follower filtrati
	 */
	@Override
	public List<Follower> fullLoc(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().equals(a))); //rimuove gli utenti la cui location non sia identica alla stringa "a"
		if(lf.isEmpty()) throw new E_wordNotFound(); //lancia un'eccezione se la lista filtrata è vuota
		return lf;	
	}
}
