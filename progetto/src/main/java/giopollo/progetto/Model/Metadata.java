package giopollo.progetto.Model;

import java.util.HashMap;

/**
 * Classe che restituisce i metadati
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class Metadata {
	
	/**
	 * Ottiene i metadata di un follower 
	 *
	 * @return HashMap<String,String>
	 */
	public static HashMap<String,String> getFollowerMetadata() 
	{
		HashMap<String,String> metadata = new HashMap<String,String> (); //HashMap in cui le chiavi sono i metadati, i valori la descrizione
		metadata.put("name","nome dell'utente");
		metadata.put("location","location dell'utente");
		metadata.put("followers_count","numero dei follower dell'utente");
		metadata.put("friends_count","numero degli account seguiti dall'utente");
		return metadata;
	}
}
