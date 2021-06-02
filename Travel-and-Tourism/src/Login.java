import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;
    String username=null, password=null;
	Login(String username, String password){
	  this.setTitle(" Login Page");
      this.username=username;
      this.password=password;
      setLayout(null); //BorderLayout, FlowLayout, GridLayout,Grid
      getContentPane().setBackground(Color.WHITE);
      setBounds(300, 250, 900, 400);
	  setResizable(false);
	 
      
      JPanel p1 = new JPanel();
      p1.setBackground(new Color(131, 193, 233));
      p1.setBounds(2, 2, 400, 400);
      p1.setLayout(null);
      add(p1);
   
      Image i1 = new ImageIcon(this.getClass().getResource("/login1.png")).getImage();
      Image i2 = i1.getScaledInstance(320,300, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel l1 = new JLabel(i3);
      l1.setBounds(1, 1, 400, 350);
      p1.add(l1);

      JPanel p2 = new JPanel();
      p2.setLayout(null);
      p2.setBounds(415, 30, 450, 300);
      add(p2);

      JLabel l2 = new JLabel("Username");
      l2.setBounds(60, 20, 100, 25);
      l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
      p2.add(l2);

      t1 = new JTextField(username);
      t1.setBounds(60, 60, 300, 30);
      t1.setBorder(BorderFactory.createEmptyBorder());
      t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
      p2.add(t1);

      JLabel l3 = new JLabel("Password");
      l3.setBounds(60, 110, 100, 25);
      l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
      p2.add(l3);

      t2 = new JPasswordField (password);
      t2.setBounds(60, 150, 300, 30);
      t2.setBorder(BorderFactory.createEmptyBorder());
      t2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
      p2.add(t2);

      b1 = new JButton("Login");
      b1.setBounds(60, 200, 130, 30);
      b1.setBackground(new Color(133, 193, 233));
      b1.setForeground(Color.WHITE);
      b1.setBorder(BorderFactory.createEmptyBorder());
      b1.addActionListener(this);
      p2.add(b1);


      b2 = new JButton("SignUp");
      b2.setBounds(230, 200, 130, 30);
      b2.setForeground(new Color(133, 193, 233));
      b2.setBackground(Color.WHITE);
      b2.setBorder(new LineBorder(new Color(133, 193, 233)));
      b2.addActionListener(this);
      p2.add(b2);

      b3 = new JButton("Forgot Password");
      b3.setBounds(130, 250, 160, 30);
      b3.setForeground(new Color(133, 193, 233));
      b3.setBackground(Color.WHITE);
      b3.setBorder(new LineBorder(new Color(133, 193, 233)));
      b3.addActionListener(this);
      p2.add(b3);
    
      JLabel l4 = new JLabel("Trouble in Login...");
      l4.setBounds(300, 250, 150, 20);
      l4.setForeground(Color.RED);
      p2.add(l4);
      


      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
    }
   
   public void actionPerformed(ActionEvent ae) {
	    if(ae.getSource() == b1) {
	    	Conn c = new Conn();
	    	
	    	try {
	    		String username = t1.getText();
		    	String password= t2.getText();
		    	String sql = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(sql);	
                
                if(rs.next()) {
					this.dispose();
                	new Loading(username).setVisible(true);
                }else {
         		   t1.setText("");
        		   t2.setText("");	
            	   JOptionPane.showMessageDialog(null, "Invalid Username or Password","Invalid Login!",JOptionPane.ERROR_MESSAGE);

                }
	    	}
	    	catch(Exception e){
		     	JOptionPane.showMessageDialog(null, e,"Database Error!",JOptionPane.ERROR_MESSAGE);
	    	}
	    }
	    else if(ae.getSource() == b2) {
			this.dispose();
	    	new Signup().setVisible(true);
	    }
	    else if(ae.getSource() == b3) {
			this.dispose();
	    	new ForgotPassword().setVisible(true);
	    }
	   
   }

    public static void main(String[] args){
        new Login("","");
     }
}