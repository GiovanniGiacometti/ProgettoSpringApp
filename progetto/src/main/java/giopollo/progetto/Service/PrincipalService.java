package giopollo.progetto.Service;

import java.lang.reflect.InvocationTargetException;
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
		return Metadata.getFollowerMetadata();
	}	

	public List<Follower> getFilter(String url, String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
		return FilterService.decodeFilter(Download.apiDownload(url), filter);
	}
	
	public HashMap<String, Number> getStats(String url,List<String> stats) throws NoSuchMethodException, InvocationTargetException{
		return StatsService.calculate(Download.apiDownload(url),stats);
	}
	
	
	public HashMap<String, Number> getStats(String url, List<String> stats, String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
		
		return StatsService.calculate(FilterService.decodeFilter(Download.apiDownload(url),filter),stats);
	}
	
	
}
