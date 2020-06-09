package giopollo.progetto.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import giopollo.progetto.Database.Download;
import giopollo.progetto.Model.*;

/**
 * Service principale 
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

@org.springframework.stereotype.Service
public class PrincipalService {
	
	/**
	 * Metodo per ottenere i follower dell'account.
	 *
	 * @param url 
	 * @return lista dei follower dell'account
	 */
	public List<Follower> getFollower (String url) 
	{
		return Download.apiDownload(url);
	}

	/**
	 * Metodo per ottenere i metadati.
	 *
	 * @return List di stringhe
	 */
	public HashMap<String, String> getMetadata() {
		return Metadata.getFollowerMetadata();
	}	

	/**
	 * Metodo per ottenere i follower filtrati.
	 *
	 * @param url 
	 * @param filter
	 * @return lista dei follower dell'account
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 */
	public List<Follower> getFilter(String url, String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
		return FilterService.decodeFilter(Download.apiDownload(url), filter);
	}
	
	/**
	 * Metodo per ottenere le statistiche.
	 *
	 * @param url
	 * @param stats
	 * @return HashMap di stringhe e numeri
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 */
	public HashMap<String, Number> getStats(String url,List<String> stats) throws NoSuchMethodException, InvocationTargetException{
		return StatsService.calculate(Download.apiDownload(url),stats);
	}
	
	
	/**
	 * Metodo per ottenere le statistiche su follower già filtrati
	 *
	 * @param url
	 * @param stats
	 * @param filter
	 * @return HashMap di stringhe e numeri
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 */
	public HashMap<String, Number> getStats(String url, List<String> stats, String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
		
		return StatsService.calculate(FilterService.decodeFilter(Download.apiDownload(url),filter),stats);
	}
	
	
}
