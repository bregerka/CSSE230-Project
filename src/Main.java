import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
	

	public Main() {
		super("Testing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    setSize(1000, 1000);
	    JLabel label = new JLabel("pls work?", JLabel.CENTER);
	    
	    JLabel imageLabel = new JLabel("", JLabel.RIGHT);
	    imageLabel.setIcon(new ImageIcon("src\\skyrim test map.jpg"));
	    getContentPane().add(label);
	    getContentPane().add(imageLabel);
		
		
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
