package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Model.Follower;

public class F_Lower{

	public static List<Follower> apply (List<Follower> lista, Integer a , List<Follower> lf)
	{
		for(Follower f : lf) 
		{
			String s = f.getLocation();
			if(s.length()<a) 
			{
				Follower nf = new Follower(f.getName(), s);
				lista.add(nf);
			}			
		}
		return lista;
	}



}
