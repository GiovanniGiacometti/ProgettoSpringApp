package giopollo.progetto.Request.Macro;

import java.util.ArrayList;
import java.util.List;

import giopollo.progetto.Database.Parsing;

public class M_Metadata {
	public static List<String> getMetadata(Parsing p) {
		List<String> keys = new ArrayList<String>();
		keys.addAll(p.users.get(0).keySet());
		return keys;
	}
}
