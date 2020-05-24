package giopollo.progetto.Filter;

import java.util.HashMap;
import giopollo.progetto.Model.Parsing;

public class F_requency {
	public static HashMap<String,Integer> apply(Parsing p)
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		if(p.users.size()>0)
		{
			for(int i=0;i<p.users.size();i++)
			{
				String s = p.users.get(i).get("location").toUpperCase();
				if (map.containsKey(s))	
				{
					int occ = map.get(s);
					map.put(s, occ+1);
				}
				else 
				{
					map.put(s, 1);
				}
			}
			
			return map;
		}
		
		return null;
	}
}
