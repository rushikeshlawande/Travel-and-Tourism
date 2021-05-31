import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackage extends JFrame implements ActionListener {

	Choice c1;
	JLabel l11, l12, l13, l14, l15, l16, label;
	JTextField t1;
	JButton b1, b2, b3;
	int cost = 0;
	long price = 0;
	int persons = 0;
	String username = null;
	JFrame dashboard;
	boolean check=false;
	
	BookPackage(String username,JFrame dash){
		
		this.username = username;
		dashboard=dash;
		
		setBounds(480, 200, 950, 480);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
	    setResizable(false);
	    addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
                this.windowClosed(null);
    			dashboard.setEnabled(true);
    			dashboard.setVisible(true);
    			dispose();
    		}
    });

		Image i1 = new ImageIcon(this.getClass().getResource("bookpackage.png")).getImage();
	    Image i2 = i1.getScaledInstance(400,490, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    l16 = new JLabel(i3);
	    l16.setBounds(450, 0, 530, 470);
	    add(l16);
	    
		JLabel l1 = new JLabel("BOOK PACKAGE");
		l1.setBounds(50, 10, 250, 30);
		l1.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		add(l1);
		
		JLabel l2 = new JLabel("Username");
		l2.setBounds(40, 70, 100, 30);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l2);
		
	    l11 = new JLabel();
		l11.setBounds(250, 70, 150, 30);
		l11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l11);
		
		JLabel l3 = new JLabel("Select Package");
		l3.setBounds(40, 110, 150, 30);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l3);
		
		c1 = new Choice();
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		c1.add("Package-4");
		c1.add("Package-5");
		c1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		c1.setBounds(250, 110, 200, 30);
		add(c1);
		
		JLabel l4 = new JLabel("Total Persons:");
		l4.setBounds(40, 150, 150, 30);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l4);
		
		t1 = new JTextField("0");
		t1.setToolTipText("enter a number");
	    t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		t1.setBounds(250, 150, 35,25);
		label = new JLabel("Maximun Limit 9 Persons");
		label.setBounds(290, 150, 260, 25);
	    label.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
	    label.setForeground(Color.RED);
		add(label);
		add(t1);
		
		JLabel l5 = new JLabel("ID:");
		l5.setBounds(40, 190, 100, 30);
		l5.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		add(l5);
		
		l12 = new JLabel();
		l12.setBounds(250, 190, 200, 30);
		l12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l12);
		
		JLabel l6 = new JLabel("Number:");
		l6.setBounds(40, 230, 100, 30);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l6);
		
		l13 = new JLabel();
		l13.setBounds(250, 230, 200, 30);
		l13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l13);
		
		JLabel l7 = new JLabel("Phone:");
		l7.setBounds(40, 270, 100, 30);
		l7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l7);
		
		l14 = new JLabel();
		l14.setBounds(250, 270, 200, 30);
		l14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l14);
		
		JLabel l8 = new JLabel("Total Price:");
		l8.setBounds(40, 310, 120, 30);
		l8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(l8);
		
		l15 = new JLabel("0");
		l15.setBounds(250, 310, 200, 30);
		l15.setForeground(Color.RED);
		l15.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(l15);
	    
		try {
			Conn c =new Conn();
			ResultSet rs = c.s.executeQuery("Select * from customer where username ='"+username+"'");
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("id"));
				l13.setText(rs.getString("idnumber"));
				l14.setText(rs.getString("mobileNO"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		b1 = new JButton("Check Price");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60, 380, 108,25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Book Package");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200, 380, 115,25);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(340, 380, 100,25);
		b3.addActionListener(this);
		add(b3);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String p = c1.getSelectedItem();
			if(p.equals("Gold Package")) {
				cost =12000;
			} else if(p.equals("Silver Package")) {
				cost = 25000;
			}else if(p.equals("Bronze Package")) {
				cost = 32000;
			}else if(p.equals("Package-4")) {
				cost = 18000;
			}else if(p.equals("Package-5")) {
				cost = 20000;
			}
			try {
			    persons = Integer.parseInt(t1.getText());
			    if(persons>20) {
					t1.setText("0");
			    }
			} catch(Exception e) {
				t1.setText("0");
			}
			persons = Integer.parseInt(t1.getText());
			if(cost*persons > 0) {
			price = cost *persons;
			l15.setText("Rs " + price);
			}else {
				l15.setText("Rs 0" );
				persons = 0;
				label.setText("Enter the valid number 1-20");
			}
		}else if(ae.getSource() == b2) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("delete from bookpackage where username ='"+username+"'");
			}catch(Exception e) {}
			if(price > 0)
			{
				try {
					Conn c =new Conn();
				    c.s.executeUpdate("insert into bookpackage values('"+l11.getText()+"',"
				    		+ "'"+c1.getSelectedItem()+"','"+persons+"','"+l12.getText()+"',"
				    				+ "'"+l13.getText()+"','"+l14.getText()+"','"+price+"')");
				    JOptionPane.showMessageDialog(null,"Your Package Booked Successfully");
				
				}catch(Exception e) {
					System.out.println(e);
				}
		        this.dispose();
		        dashboard.setEnabled(true);
				dashboard.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"total persons and price cannot be 0 ");
			}
			
		}else if(ae.getSource() == b3) {
	        this.dispose();
	        dashboard.setEnabled(true);
			dashboard.setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
	    new BookPackage("",new JFrame()).setVisible(true);
	}

}
