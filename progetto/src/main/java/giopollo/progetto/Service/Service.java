package giopollo.progetto.Service;
import java.util.HashMap;
import java.util.List;
import giopollo.progetto.Database.Database;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Filter.*;
import giopollo.progetto.Model.*;


@org.springframework.stereotype.Service
public class Service {
	
	public List<Follower> getFollower (String url) 
	{
		return F_AllFollower.apply( Database.apiDownload(url));
	}

	
	public List<String> getWord(String url, String word)
	{
		return F_Word_in_Location.apply( Database.apiDownload(url), word);
	}


	public HashMap<String, Integer> getOcc(String url) {
		return F_requency.apply(Database.apiDownload(url));
	}


	public List<String> getMetadata(String url) {
		Parsing p = Database.apiDownload(url);
		return p.getMetadata();
	}	
}
