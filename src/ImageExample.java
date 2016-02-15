
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageExample extends JFrame {
	int xx;
	int yy;

	public ImageExample() {

		initUI();
	}

	public void initUI() {
		String bl = null;
		Graph newMap = new Graph();
		newMap.addNode("ded", new Coordinate(400, 400));
		
		
		JComboBox Combobox = new JComboBox();
		JTextField SearchWindow = new JTextField("Find a Location...");
		
		JPanel ComboPanel = new JPanel();
		JPanel SearchPanel = new JPanel();
		ComboPanel.add(Combobox);
		Combobox.addItem("Select Option");
		Combobox.addItem("Minimum Distance");
		Combobox.addItem("Find Nearest");
		Combobox.addItem("Plan Road Trip");

		Board thing = new Board();
		JPanel menupanel = new JPanel();
		SearchPanel.add(SearchWindow);
		JSlider ZoomScroll = new JSlider(1000,3000,1000);
		ZoomScroll.addChangeListener(new ChangeListener() {
			Board thingy = thing;
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				thingy.ChangeZoom((int) source.getValue());
				repaint();
			}
		});
		menupanel.setLayout(new BoxLayout(menupanel, 1));
		JButton SearchButton = new JButton("Search");
		JButton GoButton = new JButton("Go");
		GoButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Combobox.getSelectedItem());
		
				
			}
		});
		SearchPanel.add(SearchButton);
		menupanel.add(SearchPanel);
		menupanel.add(ZoomScroll);
		menupanel.add(ComboPanel);
		ComboPanel.add(GoButton);
		
		
		
		menupanel.setBackground(Color.BLACK);
		add(menupanel,BorderLayout.WEST);
		thing.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				thing.x += e.getX()-xx;
				thing.y += e.getY()-yy;
				repaint();
				System.out.println("x: " + e.getX());
				System.out.println("y: " + e.getY());
			}

			@Override
			public void mousePressed(MouseEvent e) {
	
				xx = e.getX();
				yy = e.getY();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}

		});
		setResizable(false);
		add(thing);

		// pack();
		setSize(1000, 1000);
		setTitle("Bardejov");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				ImageExample ex = new ImageExample();
				ex.setVisible(true);
			}
		});
	}
	
}