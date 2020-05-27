package giopollo.progetto.Service;
import java.util.HashMap;
import java.util.List;
import giopollo.progetto.Database.Database;
import giopollo.progetto.Model.*;
import giopollo.progetto.Request.*;
import giopollo.progetto.Request.Macro.M_Follower;
import giopollo.progetto.Request.Macro.M_Metadata;



@org.springframework.stereotype.Service
public class PrincipalService implements Service {
	
	public List<Follower> getFollower (String url) 
	{
		return M_Follower.apply( Database.apiDownload(url));
	}

	public List<String> getMetadata(String url) {
		return M_Metadata.getMetadata(Database.apiDownload(url));
	}	

	public List<Follower> getFilter(String url, String filter) {
		return FieldService.apply(Database.apiDownload(url), filter);
	}

	public List<HashMap<String, Float>> getStats(String url, String filter) {
		return StatsService.calculate(FieldService.apply(Database.apiDownload(url),filter));
	}
	
	
}
