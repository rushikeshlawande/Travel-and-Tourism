import javax.swing.*;
import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener, ItemListener{
    
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JComboBox c1;
	JRadioButton r1, r2;
	JButton b1, b2;
	ButtonGroup grp1;
	String username;
	String gender = null;

	
	AddCustomer(String username){
		this.username = username;
		setTitle("Add Customer ");
		setBounds(550, 200, 800, 550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	    setResizable(false);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Image i1 = new ImageIcon(this.getClass().getResource("addcustomerinfo.jpg")).getImage();
	    Image i2 = i1.getScaledInstance(370,420, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel l10 = new JLabel(i3);
	    l10.setBounds(400, 30, 370,420);
	    add(l10);
		
		JLabel l11 = new JLabel("Add Customer Details");
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
		t1.setBounds(220, 50, 150, 25);
	    t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);
        
        JLabel l2 = new JLabel("ID :");
		l2.setBounds(30, 90, 150,25);
	    l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l2);
		
        c1 = new JComboBox(new String [] {"Passport", "Aadhar Card", "Pan Card", "Driving Licence"});
		c1.setBounds(220, 90, 150,25);
		c1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(c1);

		JLabel l3 = new JLabel("ID Number :");
		l3.setBounds(30, 130, 150,25);
	    l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(220, 130, 150, 25);
	    t2.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t2);
        
        JLabel l4 = new JLabel("Name :");
		l4.setBounds(30, 170, 150,25);
	    l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(220, 170, 150, 25);
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
		t4.setBounds(220, 250, 150, 25);
	    t4.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t4);
        

        JLabel l7 = new JLabel("Address :");
		l7.setBounds(30, 290, 150,25);
	    l7.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(220, 290, 150, 25);
	    t5.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t5);
    

        JLabel l8 = new JLabel("Phone/ Mobile :");
		l8.setBounds(30, 330, 150,25);
	    l8.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l8);
		
		t6 = new JTextField();
		t6.setBounds(220, 330, 150, 25);
	    t6.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t6);
        
        JLabel l9 = new JLabel("E-Mail :");
		l9.setBounds(30, 370, 150,25);
	    l9.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		add(l9);
		
		t7 = new JTextField();
		t7.setBounds(220, 370, 150, 25);
	    t7.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t7);
		
        b1 = new JButton("Add");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	    b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b1.setBounds(100, 425, 70, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 425, 80, 30);
        b2.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b2.addActionListener(this);
        add(b2);
        
	    try {
	    	   Conn c = new Conn();
			   String sql = "select * from account where username = '"+username+"'";
			   ResultSet rs = c.s.executeQuery(sql);
			   while(rs.next()) {
				   t1.setText(rs.getString("username"));
				   t1.setEditable(false);
				   t3.setText(rs.getString("name"));
				   t3.setEditable(false);
				   t6.setText(rs.getString("mobileNo"));
				   t6.setEditable(false);
				   t7.setText(rs.getString("emailID"));
				   t7.setEditable(false);

			   }
		   }
		   catch(Exception e) {
	     	   JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
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
			String username = t1.getText();
			String id = (String) c1.getSelectedItem();
			String idnumber = t2.getText();
			String name = t3.getText();
			
			String country = t4.getText();
			String address = t5.getText();
			String phone = t6.getText();
			String email = t7.getText();
			
			String query = "insert into customer values('"+username+"','"+id+"','"+idnumber+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
			try {
				 Conn c = new Conn();
				 c.s.executeUpdate(query);
				 JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
				 //this.setVisible(false);
				 this.dispose();

			}catch(SQLIntegrityConstraintViolationException e) {		     	
	    		JOptionPane.showMessageDialog(null, "Please Use Update Personal Details To Change Details","User Information Already Added ",JOptionPane.ERROR_MESSAGE);
            }catch(Exception e) {
	     	   JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
			}
		} else if(ae.getSource() == b2) {
			//this.setVisible(false);
			this.dispose();
		}
	

	}
	
	public static void main(String[] args){
          new AddCustomer("").setVisible(true);
	}

}
