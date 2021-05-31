import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener, ItemListener{
    
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JComboBox<Object> c1;
	JRadioButton r1, r2;
	JButton b1, b2;
	ButtonGroup grp1;
	String username;
	String gender = null;

	
	UpdateCustomer(String username){
		this.username = username;
		setTitle("Update Customer ");
		setBounds(450, 200, 970, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Image i1 = new ImageIcon(this.getClass().getResource("updatecustomer.jpg")).getImage();
	    Image i2 = i1.getScaledInstance(450,400, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel l10 = new JLabel(i3);
	    l10.setBounds(490, 45, 450, 400);
	    add(l10);
		
		JLabel l11 = new JLabel("Update Customer Details");
		l11.setBackground(Color.BLACK);
		l11.setForeground(Color.black);
		l11.setFont(new Font("Arial", Font.BOLD,30));
		l11.setBounds(40,5, 400, 30);
		add(l11);
		
		JLabel l1 = new JLabel("Username :");
		l1.setBounds(30, 50, 150,25);
	    l1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l1);
		
		t1 = new JTextField(username);
		t1.setBounds(220, 50, 250, 25);
	    t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);
        
        JLabel l2 = new JLabel("ID :");
		l2.setBounds(30, 90, 150,25);
	    l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l2);
		
        c1 = new JComboBox<Object>(new String [] {"Passport", "Aadhar Card", "Pan Card", "Driving Licence"});
		c1.setBounds(220, 90, 150,25);
		c1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(c1);

		JLabel l3 = new JLabel("ID Number :");
		l3.setBounds(30, 130, 150,25);
	    l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(220, 130, 250, 25);
	    t2.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t2);
        
        JLabel l4 = new JLabel("Name :");
		l4.setBounds(30, 170, 150,25);
	    l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(220, 170, 250, 25);
	    t3.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t3);
        
        JLabel l5 = new JLabel("Gender :");
		l5.setBounds(30, 210, 150,25);
	    l5.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l5);
	
		grp1 = new ButtonGroup();
		
		r1 = new JRadioButton("Male");
		r1.setBounds(220, 210, 70, 25);
		r1.setBackground(Color.WHITE);
	    r1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
	    grp1.add(r1);
	    r1.addItemListener(this);
	    add(r1);
	    
	    r2 = new JRadioButton("Female");
		r2.setBounds(300, 210, 80, 25);
		r2.setBackground(Color.WHITE);
	    r2.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        grp1.add(r2);
	    r2.addItemListener(this);
	    add(r2);
	    
        JLabel l6 = new JLabel("Country :");
		l6.setBounds(30, 250, 150,25);
	    l6.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(220, 250, 200, 25);
	    t4.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t4);
        

        JLabel l7 = new JLabel("Address :");
		l7.setBounds(30, 290, 150,25);
	    l7.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(220, 290, 250, 25);
	    t5.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t5);
    

        JLabel l8 = new JLabel("Phone/ Mobile :");
		l8.setBounds(30, 330, 150,25);
	    l8.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l8);
		
		t6 = new JTextField();
		t6.setBounds(220, 330, 200, 25);
	    t6.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t6);
        
        JLabel l9 = new JLabel("E-Mail :");
		l9.setBounds(30, 370, 150,25);
	    l9.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l9);
		
		t7 = new JTextField();
		t7.setBounds(220, 370, 200, 25);
	    t7.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t7);
		
        b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	    b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b1.setBounds(100, 425, 95, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(260, 425, 80, 30);
        b2.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b2.addActionListener(this);
        add(b2);
        
	    
	    try {
	    	   Conn c = new Conn();
			   String sql = "select * from customer where username = '"+username+"'";
			   ResultSet rs = c.s.executeQuery(sql);
			   if(rs.next() == false) {
					 JOptionPane.showMessageDialog(null,"Customer Details are Not Added","Please Add Customer Details",JOptionPane.ERROR_MESSAGE);
					  this.dispose();
			   }
			   else {
			     do {
				   t1.setText(rs.getString("username"));
				   switch(rs.getString("id")) {
				   case "Passport":
					    c1.setSelectedIndex(0);
					    break;
				   case "Aadhar Card":
					    c1.setSelectedIndex(1);
					    break;
				   case "Pan Card":
					    c1.setSelectedIndex(2);
					    break;
				   case "Driving Licence":
					    c1.setSelectedIndex(3);
					    break;
				   default:
					    break;
				   }
				   t3.setText(rs.getString("name"));
				   r1.setSelected(rs.getString("gender").equals("Male"));
				   r2.setSelected(rs.getString("gender").equals("Female"));
				   t2.setText(rs.getString("idnumber"));
				   t4.setText(rs.getString("country"));
				   t5.setText(rs.getString("address"));
				   t6.setText(rs.getString("mobileNo"));
				   t7.setText(rs.getString("emailID"));
			   }while(rs.next());
		      }
	       }
		   catch(Exception e) {
		   }
        
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(r1.isSelected()) {
			gender = "Male";
		}else if(r2.isSelected()) {
			gender = "Female";
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String username1 = t1.getText();
			String id = (String) c1.getSelectedItem();
			String idnumber = t2.getText();
			String name = t3.getText();
			String country = t4.getText();
			String address = t5.getText();
			String phone = t6.getText();
			String email = t7.getText();
			
			String query = "update customer set username ='"+username1+"', id='"+id+"', idnumber='"+idnumber+"', name='"+name+"', gender='"+gender+"', country='"+country+"', address='"+address+"', mobileNo='"+phone+"', emailID='"+email+"' where username = '"+username+"'";
			/* code to update the customer database*/
			try {
				 Conn c = new Conn();
				 c.s.executeUpdate(query);
				 JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
			}catch(Exception e) {
	     	   JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
			}
			 
			/* code to update the account/bookpackage/bookhotel database*/
			try {
				 Conn c = new Conn();
				 c.s.executeUpdate("update account set username ='"+username1+"', name='"+name+"', mobileNo='"+phone+"', emailID='"+email+"' where username = '"+username+"'");
				 c.s.executeUpdate("update bookpackage set username ='"+username1+"' where username = '"+username+"'");
				 c.s.executeUpdate("update bookhotel set username ='"+username1+"' where username = '"+username+"'");
				 this.dispose();
			}catch(Exception e) {
	     	   JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
			}
		} else if(ae.getSource() == b2) {
			  this.dispose();
		}
	}
	
	
	public static void main(String[] args) {
		
          new UpdateCustomer("").setVisible(true);
	}

}