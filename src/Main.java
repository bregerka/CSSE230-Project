import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
	JPanel selectors;
	JPanel map;
	JPanel description;
	
	public Main() {
		super("Testing");
<<<<<<< HEAD
		selectors = new JPanel(){
=======
//		Graph thisGraph = new Graph();
		this.selectors = new JPanel(){
			@Override
>>>>>>> origin/master
			public void paintComponent(Graphics g)
            {
                g.setColor(Color.red);
                g.fillRect(0,0,getWidth(), getHeight());
            }
		};
		map = new JPanel(){
			public void paintComponent(Graphics g)
            {
                g.setColor(Color.blue);
                g.fillRect(0,0,getWidth(), getHeight());
            }
		};
		description = new JPanel(){
			public void paintComponent(Graphics g)
            {
                g.setColor(Color.green);
                g.fillRect(0,0,getWidth(), getHeight());
            }
		};
		JButton test = new JButton("???");
		selectors.add(test);
	    JLabel imageLabel = new JLabel(new ImageIcon("src\\skyrim test map.jpg"));
	    map.add(imageLabel);
	    description.setLayout(new BoxLayout(description, 1));
	    JLabel descriptionText = new JLabel("cdffxsxxxcxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxfff\nplsffff");
	    JLabel roundTwo = new JLabel("pl");
	    JLabel blah = new JLabel("ofd");
	    description.add(blah);
		description.add(descriptionText);
		description.add(roundTwo);
	    setSize(1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(selectors, BorderLayout.PAGE_START);
		getContentPane().add(map, BorderLayout.LINE_START);
		getContentPane().add(description, BorderLayout.LINE_END);
		
	}
	
		
		
		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	    setLayout(new FlowLayout());
//	    setSize(1000, 1000);
////	    JLabel label = new JLabel("pls work?", JLabel.CENTER);
//	    
//	    JLabel imageLabel = new JLabel("", JLabel.RIGHT);
//	    map = new ImageIcon("src\\skyrim test map.jpg");
//	    imageLabel.setIcon(map);
////	    add(label);
////	    
////	    Graphics2D g2d = (Graphics2D) g;
////	    drawImage(imageLabel.getIcon(),0,0,this);
//	    imageLabel.setBounds(0, 0, 500, 500);
//		add(imageLabel);
//		image = map.getImage();
//		paintComponent(g);
//		doDrawing(g);
//		
//	}
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponents(g);
//
//		doDrawing(g);
//
//		Toolkit.getDefaultToolkit().sync();
//	}
//
//	private void doDrawing(Graphics g) {
//		System.out.println("g");
//		Graphics2D g2d = (Graphics2D) g;
//		
//		
//		g2d.drawImage(image, 0, 0, this);
//		
//	}

	
	public static void main(String[] args){
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run(){
			Main test = new Main();
			test.setVisible(true);
		}
		});
		
	}
}
