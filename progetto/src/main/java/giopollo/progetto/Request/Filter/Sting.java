package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Follower;

public class Sting implements Filter {
	
	public List<Follower> word(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().contains(a)));
		if(lf.isEmpty()) throw new E_wordNotFound("Nessun follower ha questa parola nella descrizione!");
		return lf;		
	}
	
	public List<Follower> full(List<Follower> lf, String a){
		lf.removeIf(f->(!f.getLocation().equals(a)));
		if(lf.isEmpty()) throw new E_wordNotFound("Nessun follower ha questa parola nella descrizione!");
		return lf;	
	}
}
