package edu.orangecoastcollege.cs272.nutritioneffex.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * 
 *
 */
public class DBModel implements AutoCloseable 
{

	private String mDBName;
	private String mTableName;
	private String[] mFieldNames;
	private String[] mFieldTypes;
	private Connection mConnection;
	private Statement mStmt;
	/**
     * Instantiates a new <code>DBModel</code> given the required parameters, such as the database name,
     * table name, field names and field types.
     *
     * @param dbName The database name, e.g. cs272.db
     * @param tableName The table name, e.g. cars
     * @param fieldNames The field names, e.g. "_id", "make", "description", "horsepower", "fuel_type", "city_mpg", "hwy_mpg", "hybrid"
     * @param fieldTypes The field types, e.g. "INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "INTEGER", "INTEGER", "INTEGER"
     * @throws SQLException If the field names are not the same length as the field types, or the names/types are empty,
     * or there is an error connecting to the database.
     */
	public DBModel(String dbName, String tableName, String[] fieldNames, String[] fieldTypes) throws SQLException {
		super();
		mDBName = dbName;
		mTableName = tableName;
		mFieldNames = fieldNames;
		mFieldTypes = fieldTypes;
		if (mFieldNames == null || mFieldTypes == null || mFieldNames.length == 0
				|| mFieldNames.length != mFieldTypes.length)
			throw new SQLException("Database field names and types must exist and have the same number of elements.");
		mConnection = connectToDB();
		mStmt = mConnection.createStatement();
		createTable();
	}
	private void createTable() throws SQLException 
	{
		StringBuilder createSQL = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
		createSQL.append(mTableName).append("(");
		for (int i = 0; i < mFieldNames.length; i++)
			createSQL.append(mFieldNames[i]).append(" ").append(mFieldTypes[i])
					.append((i < mFieldNames.length - 1) ? "," : ")");
		mStmt.executeUpdate(createSQL.toString());
	}
	/**
     * Gets all records from the database.
     *
     * @return A <code>ResultSet</code> containing all records from the database table.
     * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
     * or the given SQL statement produces anything other than a single ResultSet object.
     */
	public ResultSet getAllRecords() throws SQLException
	{
		String selectSQL = "SELECT * FROM " + mTableName;
		return mStmt.executeQuery(selectSQL);
	}
	
	public ArrayList<ArrayList<String>> getAllRecordsArrayList() throws SQLException {
		try (Connection connection = connectToDB();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM " + mTableName);)
		{
			ArrayList<ArrayList<String>> resultsList = new ArrayList<>();
			while (rs.next())
			{
				ArrayList<String> values = new ArrayList<>(mFieldNames.length);
				for (String field : mFieldNames)
					values.add(rs.getString(field));
				resultsList.add(values);
			}
			return resultsList;
		}
	}

	/**
     * Gets a single record from the database matching a specific primary key.
     *
     * @param key The primary key value for the record to return.
     * @return A <code>ResultSet</code> containing a single record matching the key.
     * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
     * or the given SQL statement produces anything other than a single ResultSet object.
     */
	public ResultSet getRecord(String key) throws SQLException 
	{
		String singleRecord = "SELECT * FROM " + mTableName + " WHERE " + mFieldNames[0] + "=" + key;
		return mStmt.executeQuery(singleRecord);
	}
	
	/**
	 * Gets a single record from the database matching a specific primary key.
	 * 
	 * @param key
	 *            The primary key value for the record to return.
	 * @return A <code>ResultSet</code> containing a single record matching the
	 *         key.
	 * @throws SQLException
	 *             If a database access error occurs, this method is called on a
	 *             closed Statement, or the given SQL statement produces
	 *             anything other than a single ResultSet object.
	 */
	public ArrayList<ArrayList<String>> getRecordFromArrayList(String key) throws SQLException {
		try (Connection connection = connectToDB();
				Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM " + mTableName + " WHERE " + mFieldNames[0] + " = " + key);)
			{		
				ResultSetMetaData rsData = rs.getMetaData();
				ArrayList<ArrayList<String>> resultsList = new ArrayList<>();
				
				int cols = rsData.getColumnCount();
				while (rs.next())
				{
					ArrayList<String> values = new ArrayList<>(cols);
					for (int i = 1; i <= cols; i++)
						values.add(rs.getString(i));
					resultsList.add(values);
				}
				return resultsList;
			}
	}
	/**
     * Gets the count of all records in the database.
     *
     * @return The count of all records in the database.
     * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
     * or the given SQL statement produces anything other than a single ResultSet object.
     */
	public int getRecordCount() throws SQLException 
	{
		int count = 0;
		try (ResultSet rs = getAllRecords())
		{
			while (rs.next())
				count++;
		}
		return count;
	}
	/**
     * Creates (inserts) a new record into the database with the fields and values provided.
     * Usage: Do not provide a primary key in the fields or values, as the database will assign one automatically.
     *
     * @param fields The field names, e.g. "make", "description", "horsepower", "fuel_type", "city_mpg", "hwy_mpg", "hybrid"
     * @param values The values, e.g. "Toyota", "Corolla", "132", "gasoline", "30", "40", "0"
     * @return The newly generated primary key if the record was created successfully,
     * or -1 if the fields length does not match the values length (or if fields/values are empty).
     * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
     * or the given SQL statement produces anything other than a single ResultSet object.
     */
	public int createRecord(String[] fields, String[] values) throws SQLException {
		if (fields == null || values == null || fields.length == 0 || fields.length != values.length)
			return -1;

		StringBuilder insertSQL = new StringBuilder("INSERT INTO ");
		insertSQL.append(mTableName).append("(");
		for (int i = 0; i < fields.length; i++)
			insertSQL.append(fields[i]).append((i < fields.length - 1) ? "," : ") VALUES(");
		for (int i = 0; i < values.length; i++)
			insertSQL.append(convertToSQLText(fields[i], values[i])).append((i < values.length - 1) ? "," : ")");

		mStmt.executeUpdate(insertSQL.toString());
		// Return the newly generated primary key (as an int)
		return mStmt.getGeneratedKeys().getInt(1);
	}
	/**
     * Updates a single record from the database matching the given primary key value.
     * Usage: Do not provide primary key in the fields or values, only provide it as the key parameter.
     *
     * @param key The primary key value to update.
     * @param fields The field names, e.g. "make", "description", "horsepower", "fuel_type", "city_mpg", "hwy_mpg", "hybrid"
     * @param values The values, e.g. "Toyota", "Corolla", "132", "gasoline", "30", "40", "0"
     * @return True if the record was updated successfully, false if the fields length does not match the values length (or if fields/values are empty).
     * @throws SQLException
     */
	public boolean updateRecord(String key, String[] fields, String[] values) throws SQLException 
	{
		if (fields == null || values == null || fields.length == 0 || values.length == 0
				|| fields.length != values.length)
			return false;

		StringBuilder updateSQL = new StringBuilder("UPDATE ");
		updateSQL.append(mTableName).append(" SET ");
		for (int i = 0; i < fields.length; i++)
			updateSQL.append(fields[i]).append("=").append(convertToSQLText(fields[i], values[i]))
					.append((i < values.length - 1) ? "," : " ");

		updateSQL.append("WHERE ").append(mFieldNames[0]).append("=").append(key);
		mStmt.executeUpdate(updateSQL.toString());

		return true;
	}
	/**
     * Deletes all records from the database.
     *
     * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
     * or the given SQL statement produces anything other than a single ResultSet object.
     */
	public void deleteAllRecords() throws SQLException 
	{
		String deleteSQL = "DELETE FROM " + mTableName;
		mStmt.executeUpdate(deleteSQL);
	}
	/**
	 * Deletes an item from the database based off of the given key.
	 * @param key The key of the item to delete from the database.
	 * @throws SQLException
	 */
	public void deleteRecord(String key) throws SQLException {
		String deleteRecord = "DELETE FROM " + mTableName + " WHERE " + mFieldNames[0] + "=" + key;
		mStmt.executeUpdate(deleteRecord);
	}
	private String convertToSQLText(String field, String value) 
	{
		for (int i = 0; i < mFieldNames.length; i++)
		{
			if (field.equalsIgnoreCase(mFieldNames[i])) 
			{
				if (mFieldTypes[i].toUpperCase().trim().equals("TEXT"))
					return "'" + value + "'";
				else
					break;
			}
		}
		return value;
	}
	private Connection connectToDB() throws SQLException 
	{
		// Load SQLite database classes
		try 
		{
			Class.forName("org.sqlite.JDBC");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		// Establish a connection to the database and return that connection
		return DriverManager.getConnection("jdbc:sqlite:" + mDBName);
	}
	/**
     * Closes the connection to the database and the statement.
     */
	@Override
	public void close() throws SQLException 
	{
		mStmt.close();
		mConnection.close();
	}
}