import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener{
    
	JButton b1;
	String username;
	
	ViewCustomer(String username){
		this.username = username;
		setTitle("View Customer");
		setBounds(450, 150, 900, 580);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		Image i1 = new ImageIcon(this.getClass().getResource("/dashboard1.png")).getImage();
	    Image i2 = i1.getScaledInstance(900,200, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel l10 = new JLabel(i3);
	    l10.setBounds(0, 350, 900, 200);
	    add(l10);
		
		
		JLabel l1 = new JLabel("Username :");
		l1.setBounds(30, 40, 150,25);
	    l1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l1);
		
		JLabel l11 = new JLabel();
		l11.setBounds(220, 40, 150,25);
	    l11.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l11);
        
        JLabel l2 = new JLabel("ID :");
		l2.setBounds(30, 95, 150,25);
	    l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l2);
		
		JLabel l12 = new JLabel();
		l12.setBounds(220, 95, 150,25);
	    l12.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l12);

		JLabel l3 = new JLabel("ID Number :");
		l3.setBounds(30, 150, 150,25);
	    l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l3);
		
		JLabel l13 = new JLabel();
		l13.setBounds(220, 150, 150,25);
	    l13.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l13);
		
        JLabel l4 = new JLabel("Name :");
		l4.setBounds(30, 205, 150,25);
	    l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l4);
		
		JLabel l14 = new JLabel();
		l14.setBounds(220, 205, 150,25);
	    l14.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l14);
        
        JLabel l5 = new JLabel("Gender :");
		l5.setBounds(30, 260, 150,25);
	    l5.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l5);
	
		JLabel l15 = new JLabel();
		l15.setBounds(220, 260, 150,25);
	    l15.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l15);

        JLabel l6 = new JLabel("Country");
		l6.setBounds(500, 40, 150,25);
	    l6.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l6);
		
		JLabel l16 = new JLabel();
		l16.setBounds(690, 40, 150,25);
	    l16.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l16);
        
        JLabel l7 = new JLabel("Address :");
		l7.setBounds(500, 95, 150,25);
	    l7.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l7);
		
		JLabel l17 = new JLabel();
		l17.setBounds(690, 95, 150,25);
	    l17.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l17);
    
        JLabel l8 = new JLabel("Phone/ Mobile :");
		l8.setBounds(500, 150, 150,25);
	    l8.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l8);
		
		JLabel l18 = new JLabel();
		l18.setBounds(690, 150, 150,25);
	    l18.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l18);
		
        JLabel l9 = new JLabel("E-Mail :");
		l9.setBounds(500, 205, 150,25);
	    l9.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l9);
		
		JLabel l19 = new JLabel();
		l19.setBounds(690, 205, 150,25);
	    l19.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l19);
		
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(260, 310, 80, 30);
        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b1.addActionListener(this);
        add(b1);
        
		
	    try {
	    	   Conn c = new Conn();
			   String sql = "select * from customer where username = '"+username+"'";
			   ResultSet rs = c.s.executeQuery(sql);
			   while(rs.next()) {
				   l11.setText(rs.getString("username"));
				   l18.setText(rs.getString("id"));
				   l12.setText(rs.getString("idnumber"));
				   l13.setText(rs.getString("name"));
				   l19.setText(rs.getString("gender"));
				   l14.setText(rs.getString("country"));
				   l15.setText(rs.getString("address"));
				   l16.setText(rs.getString("mobileNo"));
				   l17.setText(rs.getString("emailID"));

			   }
			   
		   }
		   catch(Exception e) {			  
			   e.printStackTrace();
	     	   JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
           }
           
	}
	
	public void actionPerformed(ActionEvent ae) {
	    if(ae.getSource() == b1) {
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new ViewCustomer("").setVisible(true);
	}

}
