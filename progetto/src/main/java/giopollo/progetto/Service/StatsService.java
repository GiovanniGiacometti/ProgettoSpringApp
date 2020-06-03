package giopollo.progetto.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Stats.Stats;


public class StatsService {

	public static List<HashMap<String, Float>> calculate(List<Follower> lf ,List<String> stats) throws NoSuchMethodException, InvocationTargetException {
		
		List<HashMap<String, Float>> statistiche = new ArrayList<HashMap<String, Float>>();
		
		if(stats.size()==0) 
		{
			stats.add("media");stats.add("max");stats.add("min");
		}
		
		
		for(String s : stats )
		{
			HashMap<String,Float> buffer = new HashMap<String,Float>();
			Stats f = new Stats();
			Method method = null;
			try {
				method = f.getClass().getMethod(s,List.class);
				buffer.put(s, (Float) method.invoke(f,lf) );
				statistiche.add(buffer);
				
			
			} catch (SecurityException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} 
			
		}
		return statistiche;
	}
		
	

	
	

}

