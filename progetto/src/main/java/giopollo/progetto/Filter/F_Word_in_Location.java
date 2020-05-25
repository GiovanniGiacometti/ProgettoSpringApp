package giopollo.progetto.Filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Parsing;

public class F_Word_in_Location {
	
	public static List<String> apply (Parsing p, String word) throws E_wordNotFound{
		List<String> lloc = new ArrayList<String>();
		if ( p.users.size() > 0)
			for(int i=0; i<p.users.size();i++)
				if(word.equals(p.users.get(i).get("location")))
					lloc.add(p.users.get(i).get("name"));
		
		if(lloc.isEmpty()) throw new E_wordNotFound("Nessun follower ha questa parola nella descrizione!");
		return lloc;
	}

}