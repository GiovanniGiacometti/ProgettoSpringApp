package giopollo.progetto.Service;

import java.util.HashMap;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Stats.Stats;


public class StatsService {

	public static HashMap<String, Float> calculate(List<Follower> lf ,List<String> stats) throws NoSuchMethodException, InvocationTargetException {
		
		HashMap<String, Float> statistiche = new HashMap<String, Float>(); //HashMap in cui inserire i valori delle statistiche richieste
		
		if(stats.size()==0) 
		{
			stats.add("media");stats.add("max");stats.add("min"); //se la lista è vuota, vengono fornite tutte le statistiche disponibili
		}
		
		Stats f = new Stats(); //la classe in cui sono contenuti i metodi per il calcolo delle statistiche
		
		for(String s : stats ) //itero su tutte le statistiche richieste
		{ 
			Method method = null;
			try {
				method = f.getClass().getMethod(s,List.class); //definisco il metodo 
				
				statistiche.put(s, (Float) method.invoke(f,lf) ); //inseriscola statistica e il valore calcolato tramite l'invocazione del metodo richiesto
			
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

