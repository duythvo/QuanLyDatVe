package connectDB;
import java.sql.*;
public class ConnectDB {
	 	public static Connection con = null;
	    private static ConnectDB instance = new ConnectDB();

	    public static ConnectDB getInstance() {
	        return instance;
	    }

	    public static void connect() throws SQLException {
	        String severName = "localhost";
	        //sua o day
	        String databaseName = "DatVe";
	        String username = "sa";
	        String password = "sa";
	        String url = "jdbc:sqlserver://" + severName + ":1433;databaseName=" + databaseName;
	        con = DriverManager.getConnection(url, username, password);
	    }

	    public void disconnect() {
	        if (con != null)
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	    }

	    // public static Connection getConnection() {
	    //     return con;
	    // }

		public static Connection getConnection() {
	    	try {
				connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return con;
	    }
}
