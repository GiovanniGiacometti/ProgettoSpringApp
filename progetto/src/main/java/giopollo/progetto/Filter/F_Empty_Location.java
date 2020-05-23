package giopollo.progetto.Filter;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Model.Parsing;

public class F_Empty_Location {
	public static List<String> apply(Parsing p){
		List<String> lempty = new ArrayList<String>();
		if ( p.users.size() > 0)
			for(int i=0; i<p.users.size();i++)
				if(p.users.get(i).get("location")==null)
					lempty.add(p.users.get(i).get("name"));
		
		return lempty;
	}

}