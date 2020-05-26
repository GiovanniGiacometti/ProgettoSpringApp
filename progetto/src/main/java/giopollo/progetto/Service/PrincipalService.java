package giopollo.progetto.Service;
import java.util.HashMap;
import java.util.List;
import giopollo.progetto.Database.Database;
import giopollo.progetto.Model.*;
import giopollo.progetto.Request.*;
import giopollo.progetto.Request.Macro.M_Follower;
import giopollo.progetto.Request.Macro.M_Metadata;
import giopollo.progetto.Request.Macro.M_Occurrences;


@org.springframework.stereotype.Service
public class PrincipalService implements Service {
	/*
	public List<Follower> getFollower (String url) 
	{
		return M_Follower.apply( Database.apiDownload(url));
	}*/

	public HashMap<String, Integer> getOcc(String url) {
		return M_Occurrences.apply(Database.apiDownload(url));
	}


	public List<String> getMetadata(String url) {
		return M_Metadata.getMetadata(Database.apiDownload(url));
	}	
	

	public List<String> getWord(String url, String word)
	{
		return F_Word_in_Location.apply( Database.apiDownload(url), word);
	}

	public List<Follower> getFilter(String url, String filter) {
		if(filter=="") return M_Follower.apply( Database.apiDownload(url)); 
		return FilterService.apply(Database.apiDownload(url), filter);
	}
	
	
}
