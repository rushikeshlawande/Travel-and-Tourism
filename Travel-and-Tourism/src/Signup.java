import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLIntegrityConstraintViolationException;

public class Signup extends JFrame implements ActionListener, ItemListener{
    
	JButton b1, b2;
	JTextField t1, t2, t3, t5, t6, t7;
	Choice c1;
	
    Signup(){
      setBounds(300,250,900,400);
      this.setTitle(" Register User");
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
	  this.setResizable(false);
	  

      JPanel p1 = new JPanel();
      p1.setBackground(new Color(133, 193, 233));
      p1.setBounds(2, 1, 500, 400);
      p1.setLayout(null);
      add(p1);

      JLabel l1 = new JLabel("Username");
      l1.setFont(new Font("Tahoma", Font.BOLD, 14));
      l1.setBounds(50, 20, 130, 25);
      p1.add(l1);

      t1 = new JTextField();
      t1.setBounds(190, 20, 170, 25);
      t1.setBorder(BorderFactory.createEmptyBorder());
      t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
      p1.add(t1);

      JLabel l2 = new JLabel("Name");
      l2.setFont(new Font("Tahoma", Font.BOLD, 14));
      l2.setBounds(50, 60, 130, 25);
      p1.add(l2);

      t2 = new JTextField();
      t2.setBounds(190, 60, 250, 25);
      t2.setBorder(BorderFactory.createEmptyBorder());
      t2.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
      p1.add(t2);
  
      JLabel l3 = new JLabel("Password");
      l3.setFont(new Font("Tahoma", Font.BOLD, 14));
      l3.setBounds(50, 100, 130, 25);
      p1.add(l3);

      t3 = new JTextField();
      t3.setBounds(190, 100, 170, 25);
      t3.setBorder(BorderFactory.createEmptyBorder());
      t3.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
      p1.add(t3);

      JLabel l4 = new JLabel("Security Question");
      l4.setFont(new Font("Tahoma", Font.BOLD, 14));
      l4.setBounds(50, 140, 130, 25);
      p1.add(l4);
    
      c1 = new Choice();
      c1.add("Your Nickname?");
      c1.add("Your middle name?");
      c1.add("Your Lucky number?");
      c1.add("Your favorite book?");
      c1.add("Your date of birth?");
      c1.add("Your birth place?");
      c1.setBounds(190, 140, 180, 25);
      c1.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
      c1.addItemListener(this);
      p1.add(c1);

      JLabel l5 = new JLabel("Answer");
      l5.setFont(new Font("Tahoma", Font.BOLD, 14));
      l5.setBounds(50, 180, 130, 25);
      p1.add(l5);

      t5 = new JTextField();
      t5.setBounds(190, 180, 250, 25);
      t5.setBorder(BorderFactory.createEmptyBorder());
      t5.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
      p1.add(t5);
      

      JLabel l6 = new JLabel("Phone/Mobile");
      l6.setFont(new Font("Tahoma", Font.BOLD, 14));
      l6.setBounds(50, 220, 130, 25);
      p1.add(l6);

      t6 = new JTextField();
      t6.setBounds(190, 220, 180, 25);
      t6.setBorder(BorderFactory.createEmptyBorder());
      t6.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
      p1.add(t6);
      

      JLabel l7 = new JLabel("Email-ID");
      l7.setFont(new Font("Tahoma", Font.BOLD, 14));
      l7.setBounds(50, 260, 130, 25);
      p1.add(l7);

      t7 = new JTextField();
      t7.setBounds(190, 260, 250, 25);
      t7.setBorder(BorderFactory.createEmptyBorder());
      t7.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
      p1.add(t7);

      b1 = new JButton("Create");
      b1.setFont(new Font("Tahoma", Font.BOLD, 14));
      b1.setForeground(new Color(133, 193, 233));
      b1.setBackground(Color.WHITE);
      b1.setBounds(80, 310, 100, 30);
      b1.addActionListener(this);
      p1.add(b1);
      
      b2 = new JButton("Back");
      b2.setFont(new Font("Tahoma", Font.BOLD, 14));
      b2.setForeground(new Color(133, 193, 233));
      b2.setBackground(Color.WHITE);
      b2.setBounds(250, 310, 100, 30);
      b2.addActionListener(this);
      p1.add(b2);
     
      Image i1 = new ImageIcon(this.getClass().getResource("/signup.png")).getImage();
      Image i2 = i1.getScaledInstance(350, 300, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel l8= new JLabel(i3);
      l8.setBounds(500, 10, 390, 340);
      add(l8);
      
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }
    
    public void actionPerformed(ActionEvent ae) {
	    if(ae.getSource() == b1) {
	    	String username = t1.getText();
	    	String name = t2.getText();
	    	String password = t3.getText();
	    	String security = c1.getSelectedItem();
	    	String answer = t5.getText();
	    	String mobileNo = t6.getText();
	    	String emailID = t7.getText();
	        
	        if( mobileNo.length()==0){  mobileNo= "9850318932";}
	        if (emailID.length()==0) {  emailID ="Not Known";}

	    	
	    	try {
	    		Conn c = new Conn();
		    	String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"','"+mobileNo+"','"+emailID+"')";
	    		c.s.executeUpdate(query);
	    		JOptionPane.showMessageDialog(null, "Account Created Successfully");
	    		
	    		this.setVisible(false);
	    		new Login(username,password).setVisible(true);
	    	}
	    	catch(SQLIntegrityConstraintViolationException e) {		     	
	    		JOptionPane.showMessageDialog(null, "User already exist","Please try another usename",JOptionPane.ERROR_MESSAGE);
            }
	    	catch(java.sql.SQLException e) {		     	
	    		JOptionPane.showMessageDialog(null, "Please Enter Valid Mobile No ","Invalid Mobile No",JOptionPane.ERROR_MESSAGE);
            }
	    	catch (Exception e) {
		     	JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
	    	}
	    }
	    else if(ae.getSource() == b2) {
	    	this.setVisible(false);
	    	new Login("","").setVisible(true);
	    }
	    else if(ae.getSource() == c1) {
	    	
	    }
	   
   }
    
    public void itemStateChanged (ItemEvent ae) {
    	t5.setText("");
    }

  
    public static void main(String[] args){
        new Signup().setVisible(true);
 
     }
}
