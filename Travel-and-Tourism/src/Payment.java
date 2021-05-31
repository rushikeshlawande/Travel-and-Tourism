import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Payment extends JFrame implements ActionListener, ItemListener {
	JButton b1,b2;
	JRadioButton r1, r2, r3, r4;
	ButtonGroup grp1;
	String url = "https://www.billdesk.com";
	JFrame dashboard;
    String username;
	Payment(String username,JFrame dash){
		dashboard=dash;
		this.username= username;

		setBounds(500,200,800,600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
	    setResizable(false);
	    addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
                this.windowClosed(null);
    			dispose();
                dashboard.enable(true);
    			dashboard.setVisible(true);
    			
    		}
    });	
		Image i1 = new ImageIcon(this.getClass().getResource("payment1.jpg")).getImage();
	    Image i2 = i1.getScaledInstance(800,400, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel l1 = new JLabel(i3);
	    l1.setBounds(0, 0, 800,600);
	    add(l1);
	    
		JLabel l2=new JLabel("Please select the payment option");
		l2.setBounds(120, 50, 400,30);
	    l2.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
		l1.add(l2);

		
        grp1 = new ButtonGroup();
		
		r1 = new JRadioButton("AmzonPay");
		r1.setBounds(140, 90, 150, 25);
		r1.setBackground(Color.WHITE);
	    r1.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
	    grp1.add(r1);
	    r1.addItemListener(this);
	    l1.add(r1);
	    
	    r2 = new JRadioButton("Paytm");
		r2.setBounds(140, 130, 150, 25);
		r2.setBackground(Color.WHITE);
	    r2.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        grp1.add(r2);
	    r2.addItemListener(this);
	    l1.add(r2);
	    

	    r3 = new JRadioButton("Net Banking");
	    r3.setSelected(true);
		r3.setBounds(140, 170, 150, 25);
		r3.setBackground(Color.WHITE);
	    r3.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        grp1.add(r3);
	    r3.addItemListener(this);
	    l1.add(r3);
	    
	    r4 = new JRadioButton("Credit/Debit card");
	    r4.setSelected(true);
		r4.setBounds(140, 210, 150, 25);
		r4.setBackground(Color.WHITE);
	    r4.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        grp1.add(r4);
	    r4.addItemListener(this);
	    l1.add(r4);
		
		b1=new JButton("Proceed To Pay");
		b1.setBounds(140,245,140,25);
		b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		l1.add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(310,245,71,25);
		b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
		l1.add(b2);
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(r1.isSelected()) {
			url = "https://www.amazon.in/b?ie=UTF8&node=14366549031";
		}else if(r2.isSelected()) {
			url = "https://paytm.com/credit-card-bill-payment";
		}else if(r3.isSelected()){
            url="https://www.billdesk.com";			
		}else {url=" ";}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			this.dispose();
			dashboard.setVisible(true);
			new Pay(url,username,dashboard).setVisible(true);
			
		}else if(ae.getSource()==b2) {
		this.dispose();
		dashboard.setEnabled(true);
		dashboard.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Payment("",new JFrame()).setVisible(true);
	}	
}
