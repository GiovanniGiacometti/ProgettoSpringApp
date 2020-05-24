package giopollo.progetto.Filter;


import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Model.Follower;
import giopollo.progetto.Model.Parsing;

public class F_AllFollower {

	public static List<Follower> apply(Parsing p) {
		
		Follower f = null;
		List<Follower> lf = new ArrayList<Follower>();
		if ( p.users.size() > 0)
			for(int i=0; i<p.users.size();i++)
			{
				f = new Follower("","");
				f.setLocation(p.users.get(i).get("location"));
				f.setName(p.users.get(i).get("name")); 
				lf.add(f);
			}	
		return lf;
	}
	
	

}