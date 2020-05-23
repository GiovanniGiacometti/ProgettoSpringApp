package giopollo.progetto.Service;
import java.util.List;
import giopollo.progetto.Database.Database;
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
		if (word == "") return F_Empty_Location.apply(p);
		return F_Word_in_Location.apply(p, word);
		
	}	
}
