package giopollo.progetto.Request.Stats;

import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Model.Follower;

/**
 * Classe che calcola le statistiche
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */

public class Stats {
	
	/**
	 * Metodo Media.
	 *
	 * @param u lista dei follower dell'account
	 * @return float media della lunghezza della location
	 */
	public static float media(List<Follower> u)
	{
		float media=0;
		int sum41=0;
		for(Follower f : u) 
		{
			String blink182 = f.getLocation();
			sum41+= blink182.length();
		}
		media = (float)sum41/u.size(); //calcolo media 
		return media;
	}

	/**
	 * Metodo Max.
	 *
	 * @param u lista dei follower dell'account
	 * @return int massimo della lunghezza della location
	 */
	public static int max(List<Follower> u)
	{
		int max=0;
		for(Follower f : u) 
		{
			String s = f.getLocation();
			if(s.length()>max) max = s.length(); 
		}
	
		return max;
	}
	
	/**
	 * Metodo Min.
	 *
	 * @param u lista dei follower dell'account
	 * @return int minimo della lunghezza della location
	 */
	public static int min(List<Follower> u)
	{
		int min=u.get(0).getLocation().length();
		for(Follower f : u) 
		{
			String s = f.getLocation();
			if(s.length()<min) min = s.length();
		}
		return min;
	}
}
