import javax.swing.*;
import java.awt.event.*;
public class Pay extends JFrame implements ActionListener{
	JFrame dashboard;
    String username;
	Pay(String url,String username,JFrame dash){
		dashboard=dash;
		dashboard.setEnabled(false);
		dashboard.setVisible(true);
	    this.username=username;
		JEditorPane jep =new JEditorPane();
		jep.setEditable(false);
		add(jep);
		try {
			jep.setPage(url);
			
		}catch(Exception e) {
			jep.setContentType("text/html");
			jep.setText("<html>Could not load, Error 404</html>");
		}
		
		JScrollPane jsp =new JScrollPane(jep);
		getContentPane().add(jsp);
		
		JButton b1=new JButton("Cancel");
		b1.setBounds(520,680,80,20);
		b1.addActionListener(this);
	    jep.add(b1);
		
		setBounds(250, 50,1100,750);
		addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
                this.windowClosed(null);
    			dispose();
    			dashboard.setEnabled(true);
				dashboard.setVisible(true);
    		}
    });	}
	
	public void actionPerformed(ActionEvent ae){
		this.dispose();
		dashboard.setVisible(true);
		new Payment(username,dashboard).setVisible(true);
	}
	

	public static void main(String[] args) {
		new Pay("","",new JFrame()).setVisible(true);
	
	}
}
