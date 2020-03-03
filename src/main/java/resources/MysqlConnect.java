package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlConnect {

		// TODO Auto-generated method stub
		
		String hostname="localhost";
		String port="3306";
		String dbname="priyatest";
     
		public Statement databaseconnection1() throws SQLException {
		
			Connection con= DriverManager.getConnection("jdbc:mysql://"+hostname+":"+port+"/"+dbname, "root", "root2929");
		    Statement s= con.createStatement();
		    return s;		
        }
	}
	


