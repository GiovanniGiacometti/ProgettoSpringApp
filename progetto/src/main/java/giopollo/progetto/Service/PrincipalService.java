package giopollo.progetto.Service;

import java.util.HashMap;
import java.util.List;
import giopollo.progetto.Database.Download;
import giopollo.progetto.Model.*;

@org.springframework.stereotype.Service
public class PrincipalService {
	
	public List<Follower> getFollower (String url) 
	{
		return Download.apiDownload(url);
	}

	public List<String> getMetadata() {
		return Metadata.getMetadata();
	}	

	public List<Follower> getFilter(String url, String filter) {
		return FieldService.apply(Download.apiDownload(url), filter);
	}
	
	public List<HashMap<String, Float>> getStats(String url,List<String> stats){
		return StatsService.calculate(Download.apiDownload(url),stats);
	}
	
	
	public List<HashMap<String, Float>> getStats(String url, List<String> stats, String filter) {
		
		return StatsService.calculate(FieldService.apply(Download.apiDownload(url),filter),stats);
	}
	
	
}
