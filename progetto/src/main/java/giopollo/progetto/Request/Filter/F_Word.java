package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Model.Follower;

public class F_Word {

	public static List<Follower> apply(List<Follower> lista, String a, List<Follower> lf) {
		for(Follower f : lf) 
		{
			String s = f.getLocation();
			if(s.contains(a))
			{
				Follower nf = new Follower(f.getName(), s);
				lista.add(nf);
			}	
		}
		return lista;		
	}

}
