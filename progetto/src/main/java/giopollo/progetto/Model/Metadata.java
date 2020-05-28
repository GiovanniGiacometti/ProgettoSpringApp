package giopollo.progetto.Model;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Database.ApiParsing;

public class Metadata {
	public static List<String> getMetadata() {
		List<String> l = new ArrayList<String> ();
		l.add("name");
		l.add("location");
		return l;
	}
}
