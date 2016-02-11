import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
	

	public Main() {
		JFrame window = new JFrame("Testing");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    window.setLayout(new FlowLayout());
	    window.setSize(1000, 1000);
	    JLabel label = new JLabel("pls work", JLabel.CENTER);
	    window.getContentPane().add(label);
	    JLabel imageLabel = new JLabel("?", JLabel.RIGHT);
	    imageLabel.setIcon(new ImageIcon("skyrim test map.jpg"));
	    window.getContentPane().add(imageLabel);
//	    Font myfont = new Font("arial", Font.BOLD, 36);
//	    window.setVisible(true);
	}
	
	public static void main(String[] args){
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run(){
			Main test = new Main();
			test.setVisible(true);
		}
		});
		
	}
}
