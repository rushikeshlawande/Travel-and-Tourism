import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton b1, b2, b3;
	Login(){
     // setSize(400,400);
     // setLocation(400,200);
      setLayout(null); //BorderLayout, FlowLayout, GridLayout,Grid
      getContentPane().setBackground(Color.WHITE);
      setBounds(300, 250, 900, 400);
      
      JPanel p1 = new JPanel();
      p1.setBackground(new Color(131, 193, 233));
      p1.setBounds(0, 0, 400, 400);
      p1.setLayout(null);
      add(p1);
   
      Image i1 = new ImageIcon(this.getClass().getResource("/login3.png")).getImage();
      //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("/login1.png"));
     // Image i2 = i1.SCALE_DEFAULT();
      Image i2 = i1.getScaledInstance(320,300, 600);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel l1 = new JLabel(i3);
      //JLabel l1 = new JLabel();
      l1.setBounds(1, 1, 400, 350);
      p1.add(l1);

      JPanel p2 = new JPanel();
      p2.setLayout(null);
      p2.setBounds(400, 30, 450, 300);
      add(p2);

      JLabel l2 = new JLabel("Username");
      l2.setBounds(60, 20, 100, 25);
      l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
      p2.add(l2);

      JTextField t1 = new JTextField();
      t1.setBounds(60, 60, 300, 30);
      t1.setBorder(BorderFactory.createEmptyBorder());
      p2.add(t1);

      JLabel l3 = new JLabel("Password");
      l3.setBounds(60, 110, 100, 25);
      l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
      p2.add(l3);

      JPasswordField t2 = new JPasswordField ();
      t2.setBounds(60, 150, 300, 30);
      t2.setBorder(BorderFactory.createEmptyBorder());
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
      l4.setBounds(300, 250, 100, 20);
      l4.setForeground(Color.RED);
      p2.add(l4);
      


      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
    }
   
   public void actionPerformed(ActionEvent ae) {
	    if(ae.getSource() == b1) {
	    	
	    }
	    else if(ae.getSource() == b2) {
	    	new Signup().setVisible(true);
	    	this.setVisible(false);
	    }
	    else if(ae.getSource() == b3) {
	    	
	    }
	   
   }

    public static void main(String[] args){
        new Login();
     }
}