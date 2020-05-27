package giopollo.progetto.Service;
import java.util.HashMap;
import java.util.List;
import giopollo.progetto.Database.Download;
import giopollo.progetto.Model.*;
import giopollo.progetto.Request.*;
import giopollo.progetto.Request.Macro.M_Follower;
import giopollo.progetto.Request.Macro.M_Metadata;



@org.springframework.stereotype.Service
public class PrincipalService implements Service {
	
	public List<Follower> getFollower (String url) 
	{
		return M_Follower.apply( Download.apiDownload(url));
	}

	public List<String> getMetadata(String url) {
		return M_Metadata.getMetadata(Download.apiDownload(url));
	}	

	public List<Follower> getFilter(String url, String filter) {
		return FieldService.apply(Download.apiDownload(url), filter);
	}

	public List<HashMap<String, Float>> getStats(String url, String filter) {
		return StatsService.calculate(FieldService.apply(Download.apiDownload(url),filter));
	}
	
	
}
