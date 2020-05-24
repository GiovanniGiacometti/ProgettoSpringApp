package giopollo.progetto.Service;
import java.util.HashMap;
import java.util.List;
import giopollo.progetto.Database.Database;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Filter.*;
import giopollo.progetto.Model.*;


@org.springframework.stereotype.Service
public class Service {
	
	public static List<Follower> getFollower (String url) 
	{
		Parsing p = Database.apiDownload(url);
		return F_AllFollower.apply(p);
	}

	
	public static List<String> getWord(String url, String word)
	{
		Parsing p = Database.apiDownload(url);
		List<String> l = null;
		try
		{
			l =  F_Word_in_Location.apply(p, word);
			return l;
		}
		catch(E_wordNotFound e)
		{
			System.out.print(e.getMessage());
			return null;
		}
	}


	public static HashMap<String, Integer> getOcc(String url) {
		Parsing p = Database.apiDownload(url);
		return F_requency.apply(p);
	}	
}
