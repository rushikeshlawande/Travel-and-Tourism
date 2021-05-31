import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

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
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Failed To Connect Database");

		}
		
	}
  public static void main(String []args) {
	  new Conn();
  }
}
