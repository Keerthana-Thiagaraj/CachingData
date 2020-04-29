package cache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GetCacheData {

	private static Map<String, UserRow> userData = new HashMap<String, UserRow>();

	public static UserRow getUserRow(String Id) {

		UserRow userRecord = new UserRow();

		userRecord = GetCacheData.userData.get(Id);

		if (userRecord == null) {

			System.out.println("Not able to find symbol from symbolMap > " + Id);
			return userRecord;

		}

		return userRecord;
	}

	public static void loadData() throws SQLException {
		Connection connection = null;
		ResultSet results = null;
		PreparedStatement ps = null;
		try {

			// Load the MySQL JDBC driver

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			// Create a connection to the database

			String serverName = "localhost";

			String schema = "cache";

			String url = "jdbc:mysql://" + serverName + "/" + schema;

			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, username, password);
			ps = connection.prepareStatement("SELECT * FROM CACHE_DATA");

			results = ps.executeQuery();
			System.out.println("Successfully Connected to the database!");

			if (!results.isBeforeFirst())
				System.out.println("No Symbols Found");

			while (results.next()) {

				UserRow row = new UserRow(results);

				GetCacheData.userData.put(results.getString("id"), row);

			}

		} catch (ClassNotFoundException e) {

			System.out.println("Could not find the database driver " + e.getMessage());
		} catch (SQLException e) {

			System.out.println("Could not connect to the database " + e.getMessage());
		} catch (Exception e) {
			e.getMessage();

		} finally {
			results.close();

		}
	}

	public static void main(String[] args) throws SQLException {
		loadData();
		System.out.println("details are" + getUserRow("1"));
	}

}