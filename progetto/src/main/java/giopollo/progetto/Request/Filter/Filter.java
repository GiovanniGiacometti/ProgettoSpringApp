package giopollo.progetto.Request.Filter;

import java.util.List;
import giopollo.progetto.Database.Parsing;
import giopollo.progetto.Model.Follower;

public interface Filter<T> {
	
	public List<Follower> apply(List<Follower> lista, T b, Parsing p);
	
}
