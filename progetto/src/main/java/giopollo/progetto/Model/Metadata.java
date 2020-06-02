package giopollo.progetto.Model;

import java.util.ArrayList;
import java.util.List;


public class Metadata {
	public static List<String> getMetadata() 
	{
		List<String> l = new ArrayList<String> ();
		l.add("name: nome dell'utente");
		l.add("location: location dell'utente");
		l.add("followers_count: numero dei follower dell'utente");
		l.add("friends_count: numero degli account seguiti dall'utente");
		
		return l;
	}
}
