import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
	Connection c;
	Statement s;
	
	private final String url="jdbc:mysql:///project";
	public final String user = "root";
	public final String password= "Rushi@712";
	public Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url,user,password);
			s = c.createStatement();
			System.out.println("connecton successfull");
		}
		catch(Exception e) {
			System.out.println("connecton unsuccessfull");
		}
		
		//c.close();
		//s.close();
	}
  public static void main(String []args) {
	  new Conn();
  }
}
