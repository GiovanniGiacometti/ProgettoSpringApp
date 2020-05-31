package giopollo.progetto.Request.Filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import giopollo.progetto.Exception.E_Between;
import giopollo.progetto.Model.Follower;

public class Number implements Filter{
	
	public List<Follower> greater(List<Follower> lista, Integer a)
	{
		lista.removeIf(f->(f.getLocation().length()<a));
		return lista;
	}
	
	public List<Follower> lower (List<Follower> lista, Integer a)
	{
		lista.removeIf(f->(f.getLocation().length()>a));
		return lista;
	}
	
	public List<Follower> between(List<Follower> lista, ArrayList<Integer> b) throws E_Between {
		
		if(b.get(0)>b.get(1)) throw new E_Between();
		
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
