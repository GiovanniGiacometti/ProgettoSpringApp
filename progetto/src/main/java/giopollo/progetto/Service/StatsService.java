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
		
		List<HashMap<String, Float>> statistiche = new ArrayList<HashMap<String, Float>>(); //lista in cui inserire i valori delle statistiche richieste
		
		if(stats.size()==0) 
		{
			stats.add("media");stats.add("max");stats.add("min"); //se la lista è vuota, vengono fornite tutte le statistiche disponibili
		}
		
		
		for(String s : stats ) //itero su tutte le statistiche richieste
		{
			HashMap<String,Float> buffer = new HashMap<String,Float>(); //hashmap di buffer in cui inserire statistica e valore corrispondente 
			Stats f = new Stats(); //la classe in cui sono contenuti i metodi per il calcolo delle statistiche
			Method method = null;
			try {
				method = f.getClass().getMethod(s,List.class); //definisco il metodo 
				
				buffer.put(s, (Float) method.invoke(f,lf) ); //inserisco nel buffer la statistica e il valore calcolato tramite l'invocazione del metodo richiesto
				
				statistiche.add(buffer); //aggiungo il contenuto del buffer, ovvero la statistica calcolata nell'iterazione, alla lista di tutte le statistiche
			
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

