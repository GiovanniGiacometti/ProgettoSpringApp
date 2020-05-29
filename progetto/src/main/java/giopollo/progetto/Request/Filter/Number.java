package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Model.Follower;

public class Number implements Filter{
	public static List<Follower> greater(List<Follower> lista, Integer a)
	{
		lista.removeIf(f->(f.getLocation().length()<a));
		return lista;
	}
	
	public static List<Follower> lower (List<Follower> lista, Integer a)
	{
		lista.removeIf(f->(f.getLocation().length()>a));
		return lista;
	}
	
public static List<Follower> between(List<Follower> lista, List<Integer> b) {
		
		for(Follower f : lista) 
		{
			String s = f.getLocation();
			if(!(s.length()>b.get(0) && s.length()<b.get(1))) 
			{
				lista.remove(f);
			}			
		}
		return lista;
	}


}
