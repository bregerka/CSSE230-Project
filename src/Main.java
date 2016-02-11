import java.awt.BorderLayout;
java.awt.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
	

	public Main() {
		
	}
	
	public static void main(String[] args){
		JFrame window = new JFrame("Testing");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    window.setLayout(new BorderLayout());
//	    window.setSize(1000, 1000);
	    JLabel label = new JLabel("pls work", JLabel.CENTER);
//	    window.getContentPane().add(label);
//	    Label imageLabel = new Label();
//	    imageLabel.setIcon(new ImageIcon("skyrim test map.jpg"));
//	    window.getContentPane().add(imageLabel);
	    Image image;
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        if(image != null){
	            g.drawImage(image, 0, 0, this);
	        }
	    }
	    window.setVisible(true);
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run(){
//			Main test = new Main();
//			test.setVisible(true);
//		}
//		});
		
	}
}
