import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conn {
	Connection c;
	Statement s;
	
	private final String url="jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6416326";
	public final String user = "sql6416326";
	public final String password= "ZrxfffNjaf";
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
