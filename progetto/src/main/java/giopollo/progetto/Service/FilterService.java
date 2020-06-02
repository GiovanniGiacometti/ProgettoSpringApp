package giopollo.progetto.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import giopollo.progetto.Model.Follower;

public class FilterService {
	
	public static List<Follower> apply(List<Follower> lf, String filter) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		ObjectMapper obj = new ObjectMapper();
		
		try {
			hm = obj.readValue(filter, HashMap.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		String field = (String) hm.keySet().toArray()[0];
		Object body = hm.get(field);
		HashMap<String,Object> hmBody = new HashMap<String,Object>();
		hmBody = obj.convertValue(body, HashMap.class);
		
		
		try {
			Class<?> typeClass;
			typeClass = Class.forName("giopollo.progetto.Request.Filter."+field);
			Constructor<?> constructor = typeClass.getConstructor();
			Object typeFilter = constructor.newInstance();
			if(typeFilter instanceof Object) 
			{
				lf = decode(hmBody, typeFilter, lf );
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




