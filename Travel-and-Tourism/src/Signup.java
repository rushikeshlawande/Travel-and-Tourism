import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
	JButton b1, b2;
	 
    Signup(){
      setBounds(600,280,900,340);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);

      JPanel p1 = new JPanel();
      p1.setBackground(new Color(133, 193, 233));
      p1.setBounds(0, 0, 500, 400);
      p1.setLayout(null);
      add(p1);

      JLabel l1 = new JLabel("Username");
      l1.setFont(new Font("Tahoma", Font.BOLD, 14));
      l1.setBounds(50, 20, 130, 25);
      p1.add(l1);

      JTextField t1 = new JTextField();
      t1.setBounds(190, 20, 180, 25);
      t1.setBorder(BorderFactory.createEmptyBorder());
      p1.add(t1);

      JLabel l2 = new JLabel("Name");
      l2.setFont(new Font("Tahoma", Font.BOLD, 14));
      l2.setBounds(50, 60, 130, 25);
      p1.add(l2);

      JTextField t2 = new JTextField();
      t2.setBounds(190, 60, 180, 25);
      t2.setBorder(BorderFactory.createEmptyBorder());
      p1.add(t2);
  
      JLabel l3 = new JLabel("Password");
      l3.setFont(new Font("Tahoma", Font.BOLD, 14));
      l3.setBounds(50, 100, 130, 25);
      p1.add(l3);

      JTextField t3 = new JTextField();
      t3.setBounds(190, 100, 180, 25);
      t3.setBorder(BorderFactory.createEmptyBorder());
      p1.add(t3);

      JLabel l4 = new JLabel("Security Question");
      l4.setFont(new Font("Tahoma", Font.BOLD, 14));
      l4.setBounds(50, 140, 130, 25);
      p1.add(l4);
    
      Choice c1 = new Choice();
      c1.add("Your Nickname?");
      c1.add("Your middle name?");
      c1.add("Your Lucky number?");
      c1.add("Your favorite book?");
      c1.add("Your date of birth?");
      c1.add("Your birth place?");
      c1.setBounds(190, 140, 180, 25);
      p1.add(c1);

      JLabel l5 = new JLabel("Answer");
      l5.setFont(new Font("Tahoma", Font.BOLD, 14));
      l5.setBounds(50, 180, 130, 25);
      p1.add(l5);

      JTextField t5 = new JTextField();
      t5.setBounds(190, 180, 180, 25);
      t5.setBorder(BorderFactory.createEmptyBorder());
      p1.add(t5);

      b1 = new JButton("Create");
      b1.setFont(new Font("Tahoma", Font.BOLD, 14));
      b1.setForeground(new Color(133, 193, 233));
      b1.setBackground(Color.WHITE);
      b1.setBounds(80, 240, 100, 30);
      b1.addActionListener(this);
      p1.add(b1);
      
      b2 = new JButton("Back");
      b2.setFont(new Font("Tahoma", Font.BOLD, 14));
      b2.setForeground(new Color(133, 193, 233));
      b2.setBackground(Color.WHITE);
      b2.setBounds(250, 240, 100, 30);
      b2.addActionListener(this);
      p1.add(b2);
     
      Image i1 = new ImageIcon(this.getClass().getResource("/login1.png")).getImage();
      //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("/login1.png"));
     // Image i2 = i1.SCALE_DEFAULT();
      Image i2 = i1.getScaledInstance(350, 300, 600);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel l6 = new JLabel(i3);
      l6.setBounds(500, 10, 390, 340);
      add(l6);
     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
	    if(ae.getSource() == b1) {
	    	
	    }
	    else if(ae.getSource() == b2) {
	    	new Login().setVisible(true);
	    	this.setVisible(false);
	    }
	   
   }

  
    public static void main(String[] args){
        new Signup().setVisible(true);
 
     }
}