import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class BookHotel extends JFrame implements ActionListener{
    Choice c1,c2,c3;
    JTextField t1,t2;
    JLabel l21,l22,l23,l24,l25, l31, l32;
    JButton b1,b2,b3;
    String username;
	JFrame dashboard;
    int total=0;
    int persons=0, days=0; 
    
	BookHotel(String username,JFrame dash){
		this.username = username;
		dashboard=dash;
		setBounds(420, 200,1100,600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	    setResizable(false);
	    addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
                this.windowClosed(null);
    			dashboard.setEnabled(true);
    			dashboard.setVisible(true);
    			dispose();
    		}
    });		
		JLabel l1=new JLabel("Book Hotel");
		l1.setFont(new Font("Tamoha",Font.PLAIN,28));
		l1.setBounds(100,10,300,30);
		add(l1);
		
		JLabel l2=new JLabel("Username: ");
		l2.setBounds(20,70,100,30);
		add(l2);
		
	    l21=new JLabel();
		l21.setBounds(200,70,200,30);
		add(l21);
		
		JLabel l3=new JLabel("Select Hotel: ");
		l3.setBounds(20,110,100,30);
		add(l3);
		
		c1=new Choice();
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from hotel");
			while(rs.next()) {
				c1.add(rs.getString("name"));
			}
		}catch(Exception e) {}
		c1.setBounds(200,110,200,30);
		add(c1);
		
		JLabel l4=new JLabel("Total Persons: ");
		l4.setBounds(20,150,100,30);
		add(l4);
		
		t1=new JTextField();
		t1.setBounds(200,150,200,25);
		add(t1);
		
		l31=new JLabel("Maximum limit 5 Persons");
		l31.setFont(new Font("SAN_SERIF", Font.PLAIN, 10));
	    l31.setForeground(Color.RED);
		l31.setBounds(200,170,200,20);
		add(l31);
		
		JLabel l5=new JLabel("No. of Days: ");
		l5.setBounds(20,190,100,30);
		add(l5);
		
		t2=new JTextField();
		t2.setBounds(200,190,200,25);
		add(t2);
		
		l32=new JLabel("Maximun Limit 10 Days");
		l32.setFont(new Font("SAN_SERIF", Font.PLAIN, 10));
	    l32.setForeground(Color.RED);
		l32.setBounds(200,210,200,20);
		add(l32);
		
		JLabel l6=new JLabel("AC/ Non-AC: ");
		l6.setBounds(20,230,100,30);
		add(l6);
		
		c2=new Choice();
		c2.add("Yes");
		c2.add("No");
		c2.setBounds(200,230,150,30);
		add(c2);
		
		JLabel l7=new JLabel("Food Included: ");
		l7.setBounds(20,270,100,30);
		add(l7);
		
		c3=new Choice();
		c3.add("Yes");
		c3.add("No");
		c3.setBounds(200,270,150,30);
		add(c3);
		
		JLabel l8=new JLabel("ID: ");
		l8.setBounds(20,310,100,30);
		add(l8);
		
		l22=new JLabel();
		l22.setBounds(200,310,200,30);
		add(l22);
		
		JLabel l9=new JLabel("Number: ");
		l9.setBounds(20,350,100,30);
		add(l9);
		
		l23=new JLabel();
		l23.setBounds(200,350,200,30);
		add(l23);
		
		JLabel l10=new JLabel("Phone: ");
		l10.setBounds(20,390,100,30);
		add(l10);
		
		l24=new JLabel();
		l24.setBounds(200,390,200,30);
		add(l24);
		
		JLabel l11=new JLabel("Total Price: ");
		l11.setBounds(20,430,100,30);
		add(l11);
		
		l25=new JLabel();
		l25.setForeground(Color.RED);
		l25.setBounds(200,430,200,30);
		add(l25);
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
			while(rs.next()) {
				l21.setText(rs.getString("username"));
				l22.setText(rs.getString("id"));
				l23.setText(rs.getString("idnumber"));
				l24.setText(rs.getString("mobileNo"));
				
			}
		}catch(Exception e) {}
		
		b1=new JButton("Check Price");
		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.WHITE);
		b1.setBounds(50,490,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Book");
		b2.setBackground(Color.DARK_GRAY);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200,490,120,30);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("Back");
		b3.setBackground(Color.DARK_GRAY);
		b3.setForeground(Color.WHITE);
		b3.setBounds(350,490,120,30);
		b3.addActionListener(this);
		add(b3);

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("bookhotel.jpg"));
		Image i2= i1.getImage().getScaledInstance(640,440,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l12=new JLabel(i3);
		l12.setBounds(430,30,640,440);
		add(l12);
	
	}
	public void actionPerformed(ActionEvent ae) {
		l31.setText("Maximum Limit 5 persons");
    	l32.setText("Maximum Limit 10 days");
    	
    	try {persons=Integer.parseInt(t1.getText());}catch(Exception e){
			persons=0;
			l31.setText("Please Enter valid Total Person");}
		try {days=Integer.parseInt(t2.getText());}catch(Exception e){
			days=0;
			l32.setText("Please Enter valid No of Days");}

		if(ae.getSource()==b1) {
			try {
				Conn c=new Conn();
				ResultSet rs =c.s.executeQuery("select * from hotel where name='"+c1.getSelectedItem()+"'");
				while(rs.next()) {
					int cost =Integer.parseInt(rs.getString("cost_per_day"));
					int food =Integer.parseInt(rs.getString("food_charges"));
					int ac =Integer.parseInt(rs.getString("ac_charges"));
				
					String acprice = c2.getSelectedItem();
					String foodprice = c3.getSelectedItem();
					
					if(persons * days > 0) {
						total=0;
						total += acprice.equals("Yes") ? ac : 0;
						total += foodprice.equals("Yes") ? food : 0;
						total += cost;
						total = total * persons * days;
						l25.setText(""+total);
					}else {
						l25.setText("Please enter the valid number");
					}
				
		    	}

			}catch(Exception e) {}
		}else if(ae.getSource()==b2) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("delete from bookhotel where username ='"+username+"'");
			}catch(Exception e) {}
			
			if(total >0 &(persons>0 & days>0)) {
				try {
					Conn c= new Conn();
					String query = "insert into bookhotel values('"+ username +"','"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l22.getText()+"', '"+l23.getText()+"', '"+l24.getText()+"', '"+l25.getText()+"')" ;
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");				
			        this.dispose();
					dashboard.setEnabled(true);
					dashboard.setVisible(true);
				}catch(Exception e) {	JOptionPane.showMessageDialog(null, e);}
			}else {l25.setText("Please enter the valid number");}
		}else if(ae.getSource()==b3) {
	        this.dispose();
			dashboard.setEnabled(true);
			dashboard.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new BookHotel(" ",new JFrame()).setVisible(true);

	}

}
