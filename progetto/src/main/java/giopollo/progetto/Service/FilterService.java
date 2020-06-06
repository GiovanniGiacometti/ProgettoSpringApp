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
import giopollo.progetto.Exception.E_IncorrectNumber;
import giopollo.progetto.Exception.IncorrectFilterNumber;
import giopollo.progetto.Model.Follower;

public class FilterService {
	
	public static List<Follower> decodeFilter(List<Follower> lf, String RequestBody) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException{
		
			HashMap<String,Object> body = null; //HashMap in cui andrò ad inserire il body della richiesta POST
			ObjectMapper obj = new ObjectMapper(); 
			
			try {
				body = obj.readValue(RequestBody, HashMap.class); //parsing del json (ovvero RequestBody) in body
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			int numFilt = 0;
			String numFiltStr = (String) body.keySet().toArray()[0]; //numero di filtri da applicare, preso come stringa
			
			try {
				numFilt = Integer.parseInt(numFiltStr); //converto in intero il numero di filtri
			}
				catch(NumberFormatException e)
				{
					throw new E_IncorrectNumber(); // lancio eccezione se il cast non va a buon fine
				}
		
			HashMap<String,Object> filters = (HashMap<String,Object>) body.get(numFiltStr); //Filters contiene i filtri da applicare; le chiavi sono i campi, i valori i metodi da eseguire
			
			if(filters.size() != numFilt) throw new IncorrectFilterNumber(); //lancia un'eccezione se il numero di filtri effettivamente presenti è diverso da quello indicato nella richiesta, ovvero numFilt
			
			Object[] ListFields = filters.keySet().toArray(); //lista con i campi da filtrare
			
			for(int i=0; i<numFilt; i++) //itero sui filtri presenti nella richiesta
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




