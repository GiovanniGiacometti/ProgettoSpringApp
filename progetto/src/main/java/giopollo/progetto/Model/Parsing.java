package giopollo.progetto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parsing {
	
		public List<HashMap<String,String>> users;
		public String next_cursor;
		public String next_cursor_str;
		public String previous_cursor;
		public String previous_cursor_str;
		public String total_count; 
		
		public List<String> getMetadata() {
			List<String> keys = new ArrayList<String>();
			keys.addAll(users.get(0).keySet());
			return keys;
		}

	}

