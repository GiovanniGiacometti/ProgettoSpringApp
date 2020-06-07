package giopollo.progetto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Database.ApiParsing;

/**
 * Classe che ottiene tutti i data di ogni follower
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

	public class Data {

		/**
		 * Metodo ottiene i data e li inserisce dentro ogni follower
		 *
		 * @param p follower parsati
		 * @return List di oggetti Follower
		 */
		public static List<Follower> getData(ApiParsing p) {
			
			Follower f = null;
			List<Follower> lf = new ArrayList<Follower>();
			if ( p.users.size() > 0)
				for(HashMap<String,Object> hm : p.users)
				{
					f = new Follower("","", 0, 0);
					f.setLocation((String)hm.get("location"));
					f.setName((String)hm.get("name")); 
					f.setFollowers_count((int)hm.get("followers_count"));
					f.setFriends_count((int)hm.get("friends_count"));
					lf.add(f);
				}	
			return lf;
		}
}

