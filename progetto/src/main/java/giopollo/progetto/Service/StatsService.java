package giopollo.progetto.Service;

import java.util.HashMap;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Stats.Stats;

/**
 * Classe che gestisce le statistiche 
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class StatsService {

	/**
	 * Metodo che calcola le statistiche
	 *
	 * @param lf lista dei follower dell'account
	 * @param stats 
	 * @return HashMap di stringhe e numeri
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	public static HashMap<String, Number> calculate(List<Follower> lf ,List<String> stats) throws NoSuchMethodException, InvocationTargetException {
		
		HashMap<String, Number> statistiche = new HashMap<String, Number>(); //HashMap in cui inserire i valori delle statistiche richieste
		
		statistiche.put("Follower analizzati: ", lf.size());
		
		Stats f = new Stats(); //la classe in cui sono contenuti i metodi per il calcolo delle statistiche 
		
		if(stats.size()==0) 
		{
			stats.addAll(Stats.allStats);  //se la lista è vuota, vengono fornite tutte le statistiche disponibili
		}
		

		for(String s : stats ) //itero su tutte le statistiche richieste
		{ 
			Method method = null;
			try {
				method = f.getClass().getMethod(s,List.class); //definisco il metodo 
				
				statistiche.put(s, (Number) method.invoke(f,lf) ); //inseriscola statistica e il valore calcolato tramite l'invocazione del metodo richiesto
			
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

