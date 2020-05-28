package giopollo.progetto.Request.Filter;

import java.util.List;
import giopollo.progetto.Database.ApiParsing;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Follower;

public class F_FullLocation {

	public static List<Follower> apply(List<Follower> lista, String word, List<Follower> lf) {	
		
			for(Follower f : lf)
			{
				if(word.equals(f.getLocation()))
				{
					Follower nf = new Follower(f.getName(),f.getLocation());
					lista.add(nf);
				}
			}
		if(lista.isEmpty()) throw new E_wordNotFound("Nessun follower ha questa parola nella descrizione!");
		return lista;
	}
}
