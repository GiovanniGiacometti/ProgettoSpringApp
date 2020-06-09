package giopollo.progetto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Database.ApiParsing;

/**
 * Classe che ottiene i dati richiesti di ogni follower
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

	public class Data {

		/**
		 * Metodo che estrae i dati richiesti a partire dall'api e li inserisce in una lista di follower
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
					f = new Follower();
					f.setLocation((String)hm.get("location"));
					f.setName((String)hm.get("name")); 
					f.setFollowers_count((int)hm.get("followers_count"));
					f.setFriends_count((int)hm.get("friends_count"));
					lf.add(f);
				}	
			return lf;
		}
}

