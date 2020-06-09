package giopollo.progetto.Request.Stats;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Model.Follower;

/**
 * Classe che calcola le statistiche
 * @author Giovanni Giacometti
 * @author Lorenzo Pollonara
 */


public class Stats {
	
	public static List<String> allStats = new ArrayList<String>();
	
	/**
	 * Costruttore Stats.
	 */
	
	public Stats()
	{
		 allStats.add("media"); allStats.add("min"); allStats.add("max"); allStats.add("devStd"); allStats.add("var");
	}

	/**
	 * Metodo per calcolare la media del numero di caratteri della location dei follower
	 *
	 * @param lf lista dei follower dell'account
	 * @return float media della lunghezza della location
	 */
	public static float media(List<Follower> lf)
	{
		float media=0;
		int sum41=0;
		for(Follower f : lf) 
		{
			String blink182 = f.getLocation();
			sum41+= blink182.length();
		}
		media = (float)sum41/lf.size(); //calcolo media 
		return media;
	}

	/**
	 * Metodo per calcolare il numero massimo di caratteri della location dei follower
	 *
	 * @param lf lista dei follower dell'account
	 * @return int massimo della lunghezza della location
	 */
	public static int max(List<Follower> lf)
	{
		int max=0;
		for(Follower f : lf) 
		{
			String s = f.getLocation();
			if(s.length()>max) max = s.length(); 
		}
	
		return max;
	}
	
	/**
	 * Metodo per calcolare il numero minimo di caratteri della location dei follower
	 *
	 * @param lf lista dei follower dell'account
	 * @return int minimo della lunghezza della location
	 */
	public static int min(List<Follower> lf)
	{
		int min=lf.get(0).getLocation().length();
		for(Follower f : lf) 
		{
			String s = f.getLocation();
			if(s.length()<min) min = s.length();
		}
		return min;
	}
	
	/**
     * Metodo per calcolare la varianza sul numero dei caratteri della location dei follower
     *
     * @param lista lista dei follower dell'account
     * @return double varianza 
     */
    public static double var(List<Follower> lista) {
        double media = media(lista);
        double varianza = 0;
        for (Follower f : lista) {
            varianza += Math.pow(f.getLocation().length() - media, 2);
        }
        return varianza;
    }
    
	 /**
     * Metodo per calcolare la deviazione standard sul numero dei caratteri della location dei follower
     *
     * @param lista lista dei follower dell'account
     * @return double deviazione standard 
     */
    public static double devStd(List<Follower> lista) {
        return Math.sqrt(var(lista));
    }
}
