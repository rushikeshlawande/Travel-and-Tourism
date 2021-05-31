import javax.swing.*;
import java.awt.event.*;
public class Pay extends JFrame implements ActionListener{
	Pay(String url){
	  
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
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
		this.dispose();
		new Payment().setVisible(true);
	}
	

	public static void main(String[] args) {
		new Pay("").setVisible(true);
	
	}
}
