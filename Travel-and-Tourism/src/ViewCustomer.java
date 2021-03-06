import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener{
    
	JButton b1;
	String username;
	JFrame dashboard;
	
	ViewCustomer(String username, JFrame dash){
		this.username = username;
		dashboard=dash;
		setTitle("View Customer");
		setBounds(550, 200, 930, 600);
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
		Image i1 = new ImageIcon(this.getClass().getResource("viewcustomer1.jpg")).getImage();
	    Image i2 = i1.getScaledInstance(450,260, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel l10 = new JLabel(i3);
	    l10.setBounds(0, 340, 450, 280);
	    add(l10);
	    
	    Image i4 = new ImageIcon(this.getClass().getResource("viewcustomer2.jpg")).getImage();
	    Image i5 = i4.getScaledInstance(450,240, Image.SCALE_DEFAULT);
	    ImageIcon i6 = new ImageIcon(i5);
	    JLabel l20 = new JLabel(i6);
	    l20.setBounds(452, 353, 450, 245);
	    add(l20);
		
		
		JLabel l1 = new JLabel("Username :");
		l1.setBounds(30, 40, 150,25);
	    l1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l1);
		
		JLabel l11 = new JLabel();
		l11.setBounds(200, 40, 200,25);
	    l11.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l11);
        
        JLabel l2 = new JLabel("ID :");
		l2.setBounds(30, 95, 150,25);
	    l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l2);
		
		JLabel l12 = new JLabel();
		l12.setBounds(200, 95, 200,25);
	    l12.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l12);

		JLabel l3 = new JLabel("ID Number :");
		l3.setBounds(30, 150, 150,25);
	    l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l3);
		
		JLabel l13 = new JLabel();
		l13.setBounds(200, 150, 200,25);
	    l13.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l13);
		
        JLabel l4 = new JLabel("Name :");
		l4.setBounds(30, 205, 150,25);
	    l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l4);
		
		JLabel l14 = new JLabel();
		l14.setBounds(200, 205, 250,25);
	    l14.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l14);
        
        JLabel l5 = new JLabel("Gender :");
		l5.setBounds(30, 260, 150,25);
	    l5.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l5);
	
		JLabel l15 = new JLabel();
		l15.setBounds(200, 260, 200,25);
	    l15.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l15);

        JLabel l6 = new JLabel("Country");
		l6.setBounds(460, 40, 150,25);
	    l6.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l6);
		
		JLabel l16 = new JLabel();
		l16.setBounds(630, 40, 200,25);
	    l16.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l16);
        
        JLabel l7 = new JLabel("Address :");
		l7.setBounds(460, 95, 150,25);
	    l7.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l7);
		
		JLabel l17 = new JLabel();
		l17.setBounds(630, 95, 250,25);
	    l17.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l17);
    
        JLabel l8 = new JLabel("Phone/ Mobile :");
		l8.setBounds(460, 150, 150,25);
	    l8.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l8);
		
		JLabel l18 = new JLabel();
		l18.setBounds(630, 150, 200,25);
	    l18.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l18);
		
        JLabel l9 = new JLabel("E-Mail :");
		l9.setBounds(460, 205, 150,25);
	    l9.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l9);
		
		JLabel l19 = new JLabel();
		l19.setBounds(630, 205, 200,25);
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
			    if(rs.next() == false) {
					 JOptionPane.showMessageDialog(null,"Customer Details are are Empty","Please Add Customer Details",JOptionPane.ERROR_MESSAGE);
					 dashboard.setVisible(true);
		       }else {
			     do {
				   l11.setText(rs.getString("username"));
				   l18.setText(rs.getString("id"));
				   l12.setText(rs.getString("idnumber"));
				   l13.setText(rs.getString("name"));
				   l19.setText(rs.getString("gender"));
				   l14.setText(rs.getString("country"));
				   l15.setText(rs.getString("address"));
				   l16.setText(rs.getString("mobileNo"));
				   l17.setText(rs.getString("emailID"));
			     }while(rs.next());
		       }
		   }
		   catch(Exception e) {			  
	     	   JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
           }
           
	}
	
	public void actionPerformed(ActionEvent ae) {
	    if(ae.getSource() == b1) {
	  	 this.dispose();
	  	dashboard.setEnabled(true);
		dashboard.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
          new ViewCustomer(" ",new JFrame()).setVisible(true);
	}

}
