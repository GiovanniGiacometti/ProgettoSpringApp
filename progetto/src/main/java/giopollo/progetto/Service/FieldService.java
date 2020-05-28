package giopollo.progetto.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import giopollo.progetto.Database.ApiParsing;
import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Filter.F_Greater;

public class FieldService {

	
	public static List<Follower> apply(List<Follower> lf, String filter) {
		
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		ObjectMapper obj = new ObjectMapper();
		
		try {
			hm = obj.readValue(filter, HashMap.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		List<Follower> lista = new ArrayList<Follower>();
		String field = (String) hm.keySet().toArray()[0];
		Object body = hm.get(field);
		HashMap<String,Object> hmBody = new HashMap<String,Object>();
		hmBody = obj.convertValue(body, HashMap.class);
		
		switch(field)
		{
			case("number"):
			{	
				lista = FilterService.number(lista, lf, hmBody);
				break;
			}
			case("string"):
			{
				lista = FilterService.word(lista, lf, hmBody);
				break;
			}
			default :
				lista = null;
		}
		return lista;
	}
}




