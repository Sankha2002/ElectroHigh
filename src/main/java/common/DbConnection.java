package common;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;


	public class DbConnection {
		private String url="jdbc:mysql://localhost:4306/webproject";
		private String dbuname="root";
		private String dbpassword="";
		private String dbDriver="com.mysql.jdbc.Driver";
		
		public void loadDriver(String dbDriver) {
			try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Connection getConnection() {
			Connection con=null;
			try {
				con=DriverManager.getConnection(url,dbuname,dbpassword);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		public Connection connect() {
			loadDriver(dbDriver);
			Connection con=getConnection();
			return con;
		}
}
