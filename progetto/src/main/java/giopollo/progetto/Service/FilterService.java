package giopollo.progetto.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import giopollo.progetto.Model.Follower;
import giopollo.progetto.Model.Parsing;
import giopollo.progetto.Request.Filter.F_Greater;

public class FilterService {

	
	public static List<Follower> apply(Parsing p, String filter) {
		
		
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		ObjectMapper obj = new ObjectMapper();
		
		try {
			hm = obj.readValue(filter, HashMap.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		List<Follower> lista = new ArrayList<Follower>();
		
		String operator = (String) hm.keySet().toArray()[0];
		
		switch(operator)
		{
			case("$gt"):
			{	
				lista = F_Greater.apply(lista,hm.get("$gt"),p);
				break;
			}
			
			default :
				lista = null;
		}
		
		return lista;
		
		

	}

	
	
}




