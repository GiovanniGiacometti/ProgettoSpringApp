package giopollo.progetto.Request.Filter;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Database.Parsing;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Follower;

public class F_FullLocation {

	public static List<Follower> apply(List<Follower> lista, String word, Parsing p) {	
		for(int i=0; i<p.users.size();i++)
				if(word.equals(p.users.get(i).get("location")))
				{
					Follower f = new Follower(p.users.get(i).get("name"),p.users.get(i).get("location"));
					lista.add(f);
				}
		if(lista.isEmpty()) throw new E_wordNotFound("Nessun follower ha questa parola nella descrizione!");
		return lista;
	}
}