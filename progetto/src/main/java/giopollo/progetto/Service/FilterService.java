package giopollo.progetto.Service;

import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Filter.F_Between;
import giopollo.progetto.Request.Filter.F_Greater;
import giopollo.progetto.Request.Filter.F_Lower;
import giopollo.progetto.Request.Filter.F_Word;
import giopollo.progetto.Request.Filter.F_FullLocation;

public class FilterService {

	
	public static List<Follower> number(List<Follower> lista, List<Follower> lf, HashMap<String,Object> hmBody) throws RuntimeException {
		
		String operator = (String) hmBody.keySet().toArray()[0];
		switch(operator)
		{
			case("$gt"):
			{
				if(hmBody.get(operator) instanceof Integer) {
					int a = (int) hmBody.get(operator);
					lista =  F_Greater.apply(lista, a, lf);
				} else throw new RuntimeException();
				break;
			}
			case("$bt"):
			{
				if(hmBody.get(operator) instanceof List<?>) { 
					List<Integer> b = (List<Integer>) hmBody.get(operator);
					lista = F_Between.apply(lista, b, lf);
				} else throw new RuntimeException();
				break;
			}
			case("$lt"):
			{
				if(hmBody.get(operator) instanceof Integer) {
					int a = (int) hmBody.get(operator);
					lista = F_Lower.apply(lista, a, lf);
				} else throw new RuntimeException();
				break;
			}
		}
		
		
		return lista;
	}
	
public static List<Follower> word(List<Follower> lista, List<Follower> lf, HashMap<String,Object> hmBody) throws RuntimeException {
		
		String operator = (String) hmBody.keySet().toArray()[0];
		switch(operator)
		{
			case("$word"):
			{
				if(hmBody.get(operator) instanceof String) {
					String a = (String) hmBody.get(operator);
					lista = F_Word.apply(lista, a, lf);
				} else throw new RuntimeException();
				break;
			}
			case("$full"):
			{
				if(hmBody.get(operator) instanceof String) {
					String a = (String) hmBody.get(operator);
					lista = F_FullLocation.apply(lista, a, lf);
				} else throw new RuntimeException();
				break;
			}
		
		}
		
		
		return lista;
	}

	
}
