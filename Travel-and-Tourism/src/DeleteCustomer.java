import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener {
	JButton b1,b2;
	String username;
	DeleteCustomer(String user){
		this.username = user;
		setBounds(550, 200,850,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
	    setResizable(false);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel heading = new JLabel("DELETE CUSTOMER DETAILS");
		heading.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		heading.setBounds(110, 10, 300, 30);
		add(heading);
		
		JLabel l1 = new JLabel("Username :");
		l1.setBounds(30, 70, 100, 16);
		add(l1);
		
		JLabel l11 = new JLabel();
		l11.setBounds(150, 70, 250, 16);
		add(l11);
		
		JLabel l2 = new JLabel("Name :");
		l2.setBounds(30, 110, 100, 16);
		add(l2);
		
		JLabel l12 = new JLabel();
		l12.setBounds(150, 110, 250, 16);
		add(l12);
		
		JLabel l3 = new JLabel("Id :");
		l3.setBounds(30, 150, 100, 16);
		add(l3);
		
		JLabel l13 = new JLabel();
		l13.setBounds(150, 150, 200, 16);
		add(l13);
		
		JLabel l4 = new JLabel("Number :");
		l4.setBounds(30, 190, 100, 16);
		add(l4);
		
		JLabel l14 = new JLabel();
		l14.setBounds(150, 190, 200, 16);
		add(l14);
		
		JLabel l5 = new JLabel("Gender :");
		l5.setBounds(30, 230, 100, 16);
		add(l5);
		
		JLabel l15 = new JLabel();
		l15.setBounds(150, 230, 200, 16);
		add(l15);
		
		JLabel l6 = new JLabel("Country :");
		l6.setBounds(30, 270, 100, 16);
		add(l6);
		
		JLabel l16 = new JLabel();
		l16.setBounds(150, 270, 200, 16);
		add(l16);
		
		JLabel l7 = new JLabel("Address :");
		l7.setBounds(30, 310, 100, 16);
		add(l7);
		
		JLabel l17 = new JLabel();
		l17.setBounds(150, 310, 200, 16);
		add(l17);
		
		JLabel l8 = new JLabel("Phone :");
		l8.setBounds(30, 350, 100, 16);
		add(l8);
		
		JLabel l18 = new JLabel();
		l18.setBounds(150, 350, 200, 16);
		add(l18);
		
		JLabel l9 = new JLabel("Email :");
		l9.setBounds(30, 390, 100, 16);
		add(l9);
		
		JLabel l19 = new JLabel();
		l19.setBounds(150, 390, 200, 16);
		add(l19);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			while (rs.next()) {
				l11.setText(username);
				l12.setText(rs.getString("name"));
				l13.setText(rs.getString("id"));
				l14.setText(rs.getString("idnumber"));
				l15.setText(rs.getString("gender"));
				l16.setText(rs.getString("country"));
				l17.setText(rs.getString("address"));
				l18.setText(rs.getString("mobileNo"));
				l19.setText(rs.getString("emailID"));

			}
		} catch (Exception e) {}
		
		b1 = new JButton("Delete");
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
		b1.setBounds(80, 450, 80, 25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
		b2.setBounds(210, 450, 80, 25);
		b2.addActionListener(this);
		add(b2);
		
		Image i1 = new ImageIcon(this.getClass().getResource("deletecustomer.png")).getImage();
	    Image i2 = i1.getScaledInstance(450,400, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel l10 = new JLabel(i3);
        l10.setBounds(350,50,450,400);
        add(l10);
        
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("delete from customer where username ='"+username+"'");
				c.s.executeUpdate("delete from account where username ='"+username+"'");
				c.s.executeUpdate("delete from bookhotel where username ='"+username+"'");
				c.s.executeUpdate("delete from bookpackage where username ='"+username+"'");
				
				JOptionPane.showMessageDialog(null, "Customer Details Deleted Successfully");
				System.exit(0);
			}catch(Exception e) {}
		}else if(ae.getSource()== b2) {
			this.dispose();
		}
	}
	
	public static void main(String[] args) {
		new DeleteCustomer("").setVisible(true);
				
	}
}
	