package giopollo.progetto.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che restituisce i metadati
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class Metadata {
	
	/**
	 * Ottiene i metadata di un follower 
	 *
	 * @return List di String
	 */
	public static List<String> getFollowerMetadata() 
	{
		List<String> l = new ArrayList<String> ();
		l.add("name: nome dell'utente");
		l.add("location: location dell'utente");
		l.add("followers_count: numero dei follower dell'utente");
		l.add("friends_count: numero degli account seguiti dall'utente");
		
		return l;
	}
}
