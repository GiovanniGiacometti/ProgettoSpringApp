package giopollo.progetto.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import giopollo.progetto.Exception.E_IncorrectFilterMethod;
import giopollo.progetto.Model.Follower;

/**
 * Classe che gestisce i filtraggi del dataset
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class FilterService {
	
	/**
	 * Metodo che decodifica il filtro passato dall'utente
	 *
	 * @param lf lista dei follower dell'account
	 * @param RequestBody body della POST
	 * @return List di oggetti Follower filtrata
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws ClassNotFoundException 
	 */
	public static List<Follower> decodeFilter(List<Follower> lf, String RequestBody) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException{
		
			HashMap<String,Object> filters = null; //HashMap in cui andrò ad inserire i filtri della POST
			ObjectMapper obj = new ObjectMapper(); 
			
			try {
				filters = obj.readValue(RequestBody, HashMap.class); //parsing del json (ovvero RequestBody) in filters
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			Object[] ListFields = filters.keySet().toArray(); //lista con i campi da filtrare
			
			for(int i=0; i<filters.size(); i++) //itero sui filtri presenti nella richiesta
			{
					String field = (String) ListFields[i]; //campo da filtrare (es "Location")
					
					HashMap<String,Object> method = null; //inizializzo una HashMap in cui inserire il metodo del filtro 
					
					if(filters.get(field) instanceof HashMap<?,?> ) { //verifico la correttezza del metodo del filtro  
						method = (HashMap<String,Object>) filters.get(field); // inserisco il metodo del filtro (es "greater" : 100)
						if(method.isEmpty()) throw new E_IncorrectFilterMethod();//lancio un'eccezione se il metodo del filtro è vuoto
							
					} else throw new E_IncorrectFilterMethod(); //lancio un'eccezione se il metodo del filtro non è corretto
					
					try {
						Class<?> typeClass;
						typeClass = Class.forName("giopollo.progetto.Request.Filter."+field); 
						Constructor<?> constructor = typeClass.getConstructor(); 
						Object typeFilter = constructor.newInstance(); //inizializzo la classe a partire dal campo su cui effettuare il filtro (package Filter)
						lf = apply(method, typeFilter, lf ); //filtro la lista, passando il metodo del filtro, la classe su cui chiamare tale metodo e la lista da filtrare
					
					} catch (SecurityException e) {
						
						e.printStackTrace();
					} catch (InstantiationException e) {
						
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						
						e.printStackTrace();
					} 
			}
		return lf; //lista filtrata
	}
	
	/**
	 * Metodo che applica il filtro passato dall'utente.
	 *
	 * @param hmBody metodo da eseguire
	 * @param typeFilter campo su cui eseguire il filtro
	 * @param lf lista dei follower dell'account
	 * @return List di oggetti Follower filtrata
	 * @throws NoSuchMethodException the no such method exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	private static  List<Follower> apply(HashMap<String, Object> hmBody, Object typeFilter, List<Follower> lf) throws NoSuchMethodException, InvocationTargetException {
		
		String s = (String) hmBody.keySet().toArray()[0]; //nome del metodo da eseguire
		
		Method method = null;
		try {
			method = typeFilter.getClass().getMethod(s,List.class, hmBody.get(s).getClass()); 
			lf= (List<Follower>) method.invoke(typeFilter, lf, hmBody.get(s)); //invoco il metodo e filtro la lista
			
		}  catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} 
		
		return lf;
	}
}




