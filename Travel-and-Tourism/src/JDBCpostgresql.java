import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.jdbc.PgConnection;

public class JDBCpostgresql {
	
	         //jdbc url
			//jdbc username
			//jdbc password
        
	private final String url="jdbc:postgresql://localhost/Accountform";
	public final String user = "postgres";
	public final String password= "Rushi@712";
	
	private void connect () {
		try(Connection connection = DriverManager.getConnection(url, user, password);){
			
			if(connection != null) {
				System.out.println("Connected to postgressql server");
			}
			else {
				System.out.println("failed to connect postgressql server");
			}
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT VERSION()");
			if(resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			
			
			ResultSet resultSet1 = statement.executeQuery("SELECT * FROM accountdetails");
            while (resultSet1.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet1.getString("fname"), resultSet1.getString("lname"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JDBCpostgresql sqlConnect = new JDBCpostgresql();
       sqlConnect.connect();
	}

}


/*
 * import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.jdbc.PgConnection;

public class Conn {
	
	         //jdbc url
			//jdbc username
			//jdbc password
        
	private final String url="jdbc:postgresql://localhost/project";
	public final String user = "postgres";
	public final String password= "Rushi@712";
	Connection c;
	Statement s;
	private  Conn () {
		try{
		    c = DriverManager.getConnection(url, user, password);
			s = c.createStatement();

			if(c != null) {
				System.out.println("Connected to postgressql server");
			}
			else {
				System.out.println("failed to connect postgressql server");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new Conn();
      
	}

}

*/
