import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame{

	CheckPackage(){
		setBounds(420, 200,1050,600);
	    setResizable(false);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		String[] package1 = new String[] {"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour","Daily Buffet", "Welcome Drinks on Arrival", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW!", "SUMMER SPECIAL!", "RS 12000/-", "/package1.jpg" };

		String[] package2 = new String[] {"SILVER PACKAGE", "5 Days and 6 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Airport", "Welcome Drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise","Cruise with Dinner", "BOOK NOW!", "WINTER SPECIAL!", "RS 24000/-", "/package2.jpg" };

		String[] package3 = new String[] {"BRONZE PACKAGE", "6 Days and 5 Nights", "Return Airfare", "Free Clubing, Horse Riding & Other games", "Welcome Drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel","BBQ Dinner", "BOOK NOW!", "WINTER SPECIAL!", "RS 32000/-", "/package3.jpg" };
		
		String[] package4 = new String[] {"PACKAGE-4", "5 Days and 6 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Airport", "Welcome Drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise","Cruise with Dinner", "BOOK NOW!", "WINTER SPECIAL!", "RS 18000/-", "/package4.jpg" };

		String[] package5 = new String[] {"PACKAGE-5", "6 Days and 5 Nights", "Return Airfare", "Free Clubing, Horse Riding & Other games", "Welcome Drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel","BBQ Dinner", "BOOK NOW!", "WINTER SPECIAL!", "RS 20000/-", "/package5.jpg" };

		
		JTabbedPane pane = new JTabbedPane();
		
		JPanel p1 = createPackage(package1);
		pane.addTab("Package 1", null, p1);

		JPanel p2 = createPackage(package2);
		pane.addTab("Package 2", null, p2);
		
		JPanel p3 = createPackage(package3);
		pane.addTab("Package 3", null, p3);
	
		JPanel p4 = createPackage(package4);
		pane.addTab("Package 4", null, p4);
		add(pane, BorderLayout.CENTER);
		
		JPanel p5 = createPackage(package5);
		pane.addTab("Package 5", null, p5);
		add(pane, BorderLayout.CENTER);
	}
	
	public JPanel createPackage(String[] pack) {
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
				
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(50, 5, 350, 30);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 30 ));
		p1.add(l1);
		
		JLabel l2 = new JLabel(pack[1]);
		l2.setBounds(30, 60, 350, 30);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20 ));
		p1.add(l2);
		
		JLabel l3 = new JLabel(pack[2]);
		l3.setBounds(30, 110, 350, 30);
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 20 ));
		p1.add(l3);
		
		JLabel l4 = new JLabel(pack[3]);
		l4.setBounds(30, 160, 380, 30);
		l4.setForeground(Color.RED);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20 ));
		p1.add(l4);
		
		JLabel l5 = new JLabel(pack[4]);
		l5.setBounds(30, 210, 350, 30);
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 20 ));
		p1.add(l5);
		
		JLabel l6 = new JLabel(pack[5]);
		l6.setBounds(30, 260, 350, 30);
		l6.setForeground(Color.RED);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 20 ));
		p1.add(l6);
		
		JLabel l7 = new JLabel(pack[6]);
		l7.setBounds(30, 310, 350, 30);
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Tahoma", Font.PLAIN, 20 ));
		p1.add(l7);
		
		JLabel l8 = new JLabel(pack[7]);
		l8.setBounds(30, 360, 350, 30);
		l8.setForeground(Color.RED);
		l8.setFont(new Font("Tahoma", Font.PLAIN, 20 ));
		p1.add(l8);
		
		JLabel l9 = new JLabel(pack[8]);
		l9.setBounds(30, 430, 350, 30);
		l9.setForeground(Color.BLUE);
		l9.setFont(new Font("Tahoma", Font.PLAIN,30));
		p1.add(l9);
		
		JLabel l10 = new JLabel(pack[9]);
		l10.setBounds(250, 500, 350, 30);
		l10.setForeground(Color.RED);
		l10.setFont(new Font("Tahoma", Font.PLAIN,35 ));
		p1.add(l10);
		
		JLabel l11 = new JLabel(pack[10]);
		l11.setBounds(730, 500, 350, 30);
		l11.setForeground(Color.BLUE);
		l11.setFont(new Font("Tahoma", Font.PLAIN,25));
		p1.add(l11);
		
		Image i1 = new ImageIcon(this.getClass().getResource(pack[11])).getImage();
	    Image i2 = i1.getScaledInstance(565,470, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel l12 = new JLabel(i3);
	    l12.setBounds(430, 15, 565, 470);
	    p1.add(l12);
		return p1;
	}
	public static void main(String[] args) {
        new CheckPackage().setVisible(true);
	}

}
