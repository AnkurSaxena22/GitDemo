package EndToEndFramework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCconnection {
	
	public void javaConnection() throws SQLException {
		
		//Url path for database
		//“jdbc:mysql://”+localhost+”:”+3306+”/databasename”;
		
		String host="localhost";
		String port="3306";
	    Connection c=	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"databasename", "user", "password");
	    Statement s=c.createStatement();
	    ResultSet rs=s.executeQuery("Select * from login where id=98");
	    rs.next();
	    rs.getString("username");
	}

}
