import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
	

	public Main() {
		
	}
	
	public static void main(String[] args){
		JFrame window = new JFrame("Testing");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    window.setLayout(new BorderLayout());
	    window.setSize(1000, 1000);
	    JLabel label = new JLabel("pls work", JLabel.CENTER);
	    window.getContentPane().add(label);
//	    Font myfont = new Font("arial", Font.BOLD, 36);
	    window.setVisible(true);
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run(){
//			Main test = new Main();
//			test.setVisible(true);
//		}
//		});
		
	}
}
