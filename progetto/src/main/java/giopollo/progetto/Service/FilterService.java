package giopollo.progetto.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import giopollo.progetto.Exception.E_IncorrectFilterBody;
import giopollo.progetto.Exception.E_IncorrectNumber;
import giopollo.progetto.Exception.IncorrectFilterNumber;
import giopollo.progetto.Model.Follower;

public class FilterService {
	
	public static List<Follower> apply(List<Follower> lf, String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException{
		
			HashMap<String,Object> totalFilter = new HashMap<String,Object>();
			ObjectMapper obj = new ObjectMapper();
			
			try {
				totalFilter = obj.readValue(filter, HashMap.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			int numFilt = 0;
			String numFiltStr = (String) totalFilter.keySet().toArray()[0];
			
			try {
				numFilt = Integer.parseInt(numFiltStr);
			}
				catch(NumberFormatException e)
				{
					throw new E_IncorrectNumber();
				}
			
			
			Object totalBodyObj = totalFilter.get(numFiltStr);
		
			HashMap<String,Object> totalBody = new HashMap<String,Object>();
			totalBody = obj.convertValue(totalBodyObj, HashMap.class);
			
			if(totalBody.size() != numFilt) throw new IncorrectFilterNumber();
			
			for(int i=0; i<numFilt; i++)
			{
					String field = (String) totalBody.keySet().toArray()[i];
					
					HashMap<String,Object> bufferFilter = new HashMap<String,Object>();
					bufferFilter.put(field, totalBody.get(field));
					
					HashMap<String,Object> method = null;
					
					if(bufferFilter.get(field) instanceof HashMap<?,?>) method = (HashMap<String,Object>) bufferFilter.get(field);
					else throw new E_IncorrectFilterBody();
					
					try {
						Class<?> typeClass;
						typeClass = Class.forName("giopollo.progetto.Request.Filter."+field);
						Constructor<?> constructor = typeClass.getConstructor();
						Object typeFilter = constructor.newInstance();
						if(typeFilter instanceof Object) 
						{
							lf = decode(method, typeFilter, lf );
						}
						
						
						
					} catch (SecurityException e) {
						
						e.printStackTrace();
					} catch (InstantiationException e) {
						
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						
						e.printStackTrace();
					} 
			}
		return lf;
	}
	
	private static  List<Follower> decode(HashMap<String, Object> hmBody, Object typeFilter, List<Follower> lf) throws NoSuchMethodException, InvocationTargetException {
		
		String s = (String) hmBody.keySet().toArray()[0]; 
		
		Method method = null;
		try {
			method = typeFilter.getClass().getMethod(s,List.class, hmBody.get(s).getClass());
			lf= (List<Follower>) method.invoke(typeFilter, lf, hmBody.get(s));
			
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




