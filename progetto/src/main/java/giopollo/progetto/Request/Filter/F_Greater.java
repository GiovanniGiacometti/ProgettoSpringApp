package giopollo.progetto.Request.Filter;

import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Model.Follower;
import giopollo.progetto.Model.Parsing;

public class F_Greater {
	
	
	public static List<Follower> apply(List<Follower> lista, int a , Parsing p)
	{
		return contaCaratteri(lista,a,p);
	}
	
	
	public static List<Follower> contaCaratteri(List<Follower> lista, int a,Parsing p)
	{
		
		for(HashMap<String,String> hm : p.users )
		{
			String location = hm.get("location");
			int count = 0;
			for (int i = 0; i < location.length(); i++) {
				   if (Character.isLetter(location.charAt(i)))
				      count++;
			}
			
			if (count > a) 
			{
				Follower f = new Follower(hm.get("name"),location);
				lista.add(f);
			}
		}
		
		return lista;
	}
}
