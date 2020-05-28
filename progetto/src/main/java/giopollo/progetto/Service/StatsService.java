package giopollo.progetto.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Stats.Function;


public class StatsService {

	public static List<HashMap<String, Float>> calculate(List<Follower> lf ,List<String> stats) {
		
		List<HashMap<String, Float>> statistiche = new ArrayList<HashMap<String, Float>>();
		
		for(String s : stats )
		{
			HashMap<String,Float> buffer = new HashMap<String,Float>();
			Function f = new Function();
			Method method = null;
			try {
				method = f.getClass().getMethod(s,List.class);
				buffer.put(s, (Float) method.invoke(f,lf) );
				statistiche.add(buffer);
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return statistiche;
		
		
	}
		
	

	
	

}

/*List<HashMap<String, Float>> stats = new ArrayList<HashMap<String, Float>>();
HashMap<String, Float> buffer = new HashMap<String, Float>();
buffer.put("La location dei follower selezionati ha in media questo numero di caratteri", Function.media(lf));
stats.add(buffer);
stats.add(Function.allOccurrences(lf));
return stats;*/