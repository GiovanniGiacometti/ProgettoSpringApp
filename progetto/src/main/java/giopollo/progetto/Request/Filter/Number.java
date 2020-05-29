package giopollo.progetto.Request.Filter;

import java.util.ArrayList;
import java.util.Iterator;
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
	
public static List<Follower> between(List<Follower> lista, ArrayList<Integer> b) {
		
			Iterator<Follower> it = lista.iterator();
			
			while (it.hasNext())
			{
				Follower f = it.next();
				if(!(f.getLocation().length() < b.get(1) && f.getLocation().length()>b.get(0)))
				{
					it.remove();
				}
			}		
		
		return lista;
	}


}
