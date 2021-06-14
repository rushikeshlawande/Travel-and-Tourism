import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conn {
	Connection c;
	Statement s;
	/*
	 //freedb.tech:
	private final String url="jdbc:mysql://freedb.tech:3306/freedbtech_rushitravel";
	public final String user = "freedbtech_rushitravel";
	public final String password= "Pass@123";
    */
	
	//remotemysql.com
	private final String url="jdbc:mysql://remotemysql.com:3306/8FKklAJJZz";
	public final String user = "8FKklAJJZz";
	public final String password= "D81fAfcw8J";
	
	/*
	private final String url="jdbc:mysql:///project";
	public final String user = "root";
	public final String password= "Rushi@712";
	*/
	

	public Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url,user,password);
			s = c.createStatement();
		}
		catch(com.mysql.cj.jdbc.exceptions.CommunicationsException e){
			JOptionPane.showMessageDialog(null,"        You are offline! ","No Internet Connectivity",JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Failed To Connect Database");

		}
		
	}
  public static void main(String []args) {
	  new Conn();
  }
}
