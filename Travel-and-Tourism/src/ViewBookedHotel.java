import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{

	JButton b1;
	String username;
	JFrame dashboard;

	public ViewBookedHotel(String username, JFrame dash) {
		dashboard=dash;

		this.username = username;
		setBounds(420, 200,1100,550);
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
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("viewbookedhotel.jpg"));
		Image i2= i1.getImage().getScaledInstance(650,440,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l21=new JLabel(i3);
		l21.setBounds(430,30,650,440);
		add(l21);
            
        JLabel heading = new JLabel("VIEW BOOKED HOTEL DETAILS");
		heading.setBounds(60,0,350,30);
		heading.setFont(new Font("Tahoma",Font.PLAIN,25));
		add(heading);
		
		JLabel l1=new JLabel("Username: ");
		l1.setBounds(30,50,100,30);
		add(l1);
		
		JLabel l11=new JLabel();
		l11.setBounds(200,50,250,30);
		add(l11);
		
		JLabel l2=new JLabel("Hotel Name: ");
		l2.setBounds(30,90,100,30);
		add(l2);
		
		JLabel l12=new JLabel();
		l12.setBounds(200,90,250,30);
		add(l12);
		
		JLabel l3=new JLabel("Total Person: ");
		l3.setBounds(30,130,100,30);
		add(l3);
		
		JLabel l13=new JLabel();
		l13.setBounds(200,130,250,30);
		add(l13);
		
		JLabel l4=new JLabel("Total Days: ");
		l4.setBounds(30,170,100,30);
		add(l4);
		
		JLabel l14=new JLabel();
		l14.setBounds(200,170,250,30);
		add(l14);
		
		JLabel l5=new JLabel("Ac Included?: ");
		l5.setBounds(30,210,100,30);
		add(l5);
		
		JLabel l15=new JLabel();
		l15.setBounds(200,210,250,30);
		add(l15);
		
		JLabel l6=new JLabel("Food Included?: ");
		l6.setBounds(30,250,100,30);
		add(l6);
		
		JLabel l16=new JLabel();
		l16.setBounds(200,250,250,30);
		add(l16);
		
		JLabel l7=new JLabel("ID: ");
		l7.setBounds(30,290,100,30);
		add(l7);
		
		JLabel l17=new JLabel();
		l17.setBounds(200,290,250,30);
		add(l17);
		
		JLabel l8=new JLabel("Number: ");
		l8.setBounds(30,330,100,30);
		add(l8);
		
		JLabel l18=new JLabel();
		l18.setBounds(200,330,250,30);
		add(l18);
		
		JLabel l9=new JLabel("Phone: ");
		l9.setBounds(30,370,100,30);
		add(l9);
		
		JLabel l19=new JLabel();
		l19.setBounds(200,370,250,30);
		add(l19);
		
		JLabel l10=new JLabel("Total cost: ");
		l10.setBounds(30,410,100,30);
		add(l10);
		
		JLabel l20=new JLabel();
		l20.setBounds(200,410,250,30);
		add(l20);
                
        b1=new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(150,460,80,25);
		b1.addActionListener(this);
		add(b1);

		try {
			Conn c=new Conn();
			ResultSet rs =c.s.executeQuery("select * from bookhotel where username = '"+username+"'");
			if(rs.next() == false) {
				 JOptionPane.showMessageDialog(null,"No Hotel Booked ","Please Book a Package",JOptionPane.ERROR_MESSAGE);
				 dashboard.setVisible(true);	 
	       }else {
		      do {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("hotel"));
				l13.setText(rs.getString("persons"));
				l14.setText(rs.getString("days"));
				l15.setText(rs.getString("ac"));
				l16.setText(rs.getString("food"));
				l17.setText(rs.getString("id"));
				l18.setText(rs.getString("idnumber"));
				l19.setText(rs.getString("mobileNo"));
				l20.setText(rs.getString("cost"));
			    }while(rs.next()) ;
	           }
			}catch(Exception e) {
			}
	        
	}

	public void actionPerformed(ActionEvent ae) {
		  this.dispose();
		  dashboard.setEnabled(true);
		  dashboard.setVisible(true);
	}
	public static void main(String[] args) {
		new ViewBookedHotel("",new JFrame()).setVisible(true);

	}
	
}
