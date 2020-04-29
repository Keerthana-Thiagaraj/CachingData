package cache;

import org.json.JSONObject;

public class UserDetails extends JSONObject {
	public UserDetails() {
		
	}

	public UserDetails(JSONObject symBlock) {
		String[] fields = JSONObject.getNames(symBlock);
		if (fields == null)
			return;

		for (String f : fields) {
			this.put(f, symBlock.get(f));
		}
	}
}