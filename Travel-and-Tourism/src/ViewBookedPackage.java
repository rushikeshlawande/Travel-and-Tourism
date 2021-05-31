import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewBookedPackage extends JFrame implements ActionListener{

	JButton b1;
	String username;
	public ViewBookedPackage(String user) {
		username = user;
		setBounds(550, 200,800,430);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	    setResizable(false);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    

		Image i1 = new ImageIcon(this.getClass().getResource("viewpackage.jpg")).getImage();
	    Image i2 = i1.getScaledInstance(485,410, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
		JLabel l10 = new JLabel(i3);
		l10.setBounds(300,1,485,410);
		add(l10);
		
		JLabel head = new JLabel("BOOKED PACKAGE DETAILS");
		head.setBounds(30,10,240,30);
		head.setFont(new Font("Tahoma",Font.PLAIN,19));
		add(head);
		
		JLabel l1=new JLabel("Username : ");
		l1.setBounds(30,50,100,30);
		add(l1);
		
		JLabel l11=new JLabel();
		l11.setBounds(120,50,200,30);
		add(l11);
        
        JLabel l2=new JLabel("Package : ");
		l2.setBounds(30,90,100,30);
		add(l2);
		
		JLabel l12=new JLabel();
		l12.setBounds(120,90,250,30);
		add(l12);
		
		JLabel l3=new JLabel("Total Person : ");
		l3.setBounds(30,130,100,30);
		add(l3);
		
		JLabel l13=new JLabel();
		l13.setBounds(150,130,100,30);
		add(l13);
        
        JLabel l4=new JLabel("ID : ");
		l4.setBounds(30,170,100,30);
		add(l4);
		
		JLabel l14=new JLabel();
		l14.setBounds(120,170,250,30);
		add(l14);
		
		JLabel l5=new JLabel("ID Number : ");
		l5.setBounds(30,210,100,30);
		add(l5);
		
		JLabel l15=new JLabel();
		l15.setBounds(120,210,250,30);
		add(l15);
		
        
        JLabel l6=new JLabel("Phone : ");
		l6.setBounds(30,250,100,30);
		add(l6);
		
		JLabel l16=new JLabel();
		l16.setBounds(120,250,200,30);
		add(l16);
		
		JLabel l7=new JLabel("Price : ");
		l7.setBounds(30,300,100,30);
		add(l7);
		
		JLabel l17=new JLabel();
		l17.setBounds(120,300,250,30);
		l17.setForeground(Color.RED);
		l17.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(l17);
		
		b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130, 350, 80, 20);
        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        b1.addActionListener(this);
        add(b1);
		
		try {
			Conn c=new Conn();
			ResultSet rs =c.s.executeQuery("select * from bookPackage where username ='"+username+"'");
			if(rs.next() == false) {
				 JOptionPane.showMessageDialog(null,"No Package Booked ","Please Book a Package",JOptionPane.ERROR_MESSAGE);
				 
	       }else {
		     do {
				l11.setText(rs.getString(1));
				l12.setText(rs.getString(2));
				l13.setText(rs.getString(3));
				l14.setText(rs.getString(4));
				l15.setText(rs.getString(5));
				l16.setText(rs.getString(6));
				l17.setText(rs.getString(7));
			  }while(rs.next());
	         }
			}catch(Exception e) {
			}
	

	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			  this.dispose();
		}
	}
	public static void main(String[] args) {
		new ViewBookedPackage("").setVisible(true);

	}
}
