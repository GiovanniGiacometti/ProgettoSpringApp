package giopollo.progetto.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Database.Parsing;
import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Stats.Function;

public class StatsService {

	public static List<HashMap<String, Float>> calculate(List<Follower> lf) {
		List<HashMap<String, Float>> stats = new ArrayList<HashMap<String, Float>>();
		HashMap<String, Float> buffer = new HashMap<String, Float>();
		buffer.put("La location dei follower selezionati ha in media questo numero di caratteri", Function.media(lf));
		stats.add(buffer);
		stats.add(Function.allOccurrences(lf));
		return stats;
	}

	
	

}
