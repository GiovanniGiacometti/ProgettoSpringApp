package giopollo.progetto.Request.Filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import giopollo.progetto.Exception.E_Between;
import giopollo.progetto.Exception.E_NoFollowerFound;
import giopollo.progetto.Model.Follower;

public class NumChar implements Filter{
	
	public List<Follower> greater(List<Follower> lista, Integer a) throws E_NoFollowerFound
	{
		lista.removeIf(f->(f.getLocation().length()<a));
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}
	
	
	//unica funzione
	
	
	public List<Follower> lower  (List<Follower> lista, Integer a) throws E_NoFollowerFound
	{
		lista.removeIf(f->(f.getLocation().length()>a));
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}
	
	public List<Follower> between(List<Follower> lista, ArrayList<Integer> b) throws E_Between,E_NoFollowerFound {
		
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
		
		if(lista.isEmpty()) throw new E_NoFollowerFound();
		return lista;
	}


}
