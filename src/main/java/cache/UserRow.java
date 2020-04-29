package cache;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

public class UserRow extends JSONObject {

	public UserRow() {

		setUserDetail(new UserDetails());
	}

	public UserRow(JSONObject symbolobj) {

		this.put("USER_OBJ", new UserDetails(symbolobj));
	}

	public void setUserDetail(UserDetails symBlock) {
		this.put("USER_OBJ", new UserDetails(symBlock));
	}

	public void extend(UserRow otherRow) {

		String[] fields = JSONObject.getNames(otherRow);
		for (String f : fields) {
			this.put(f, otherRow.get(f));
		}

	}

	public void extend(JSONObject jsonObject) {

		String[] fields = JSONObject.getNames(jsonObject);
		for (String f : fields) {
			this.put(f, jsonObject.get(f));
		}
	}

	public UserRow(ResultSet rs) throws JSONException, SQLException {

		this.put("USER_OBJ", new UserDetails());
		this.setName(rs.getString("name"));
		this.setEmail(rs.getString("EMAIL"));
		this.setAge(rs.getString("AGE"));

	}

	public UserRow(Object object) {

		String[] fields = JSONObject.getNames(object);
		for (String f : fields) {
			this.put(f, ((JSONObject) object).get(f));
		}
	}

	@Override
	public JSONObject put(String key, Object value) throws JSONException {
		return super.put(key, value);
	}

	public void setName(String name) {
		this.getSymBlock().put("NAME", name);
	}

	public String getName() {
		return this.getSymBlock().getString("NAME");
	}

	public void setEmail(String email) {
		this.getSymBlock().put("EMAIL", email);
	}

	public String getEmail() {
		return this.getSymBlock().getString("EMAIL");
	}

	public void setAge(String age) {
		this.getSymBlock().put("AGE", age);
	}

	public String getAge() {
		return this.getSymBlock().getString("AGE");
	}

	public JSONObject getSymBlock() {
		return this.getJSONObject("USER_OBJ");
	}

}