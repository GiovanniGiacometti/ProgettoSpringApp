package giopollo.progetto.Request.Filter;

import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Database.Parsing;
import giopollo.progetto.Model.Follower;


public class F_Between implements Filter<List<Integer>>{

	public List<Follower> apply(List<Follower> lista, List<Integer> b, Parsing p) {
		for(HashMap<String,String> hm : p.users) 
		{
			String s = hm.get("location");
			if(s.length()>b.get(0) && s.length()<b.get(1)) 
			{
				Follower f = new Follower(hm.get("name"), s);
				lista.add(f);
			}			
		}
		return lista;
	}

	
	}
