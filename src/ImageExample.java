
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageExample extends JFrame {
	static Queue<Graph.Node> q = new LinkedList<Graph.Node>();
	int xx;
	int yy;
	private Graph newMap;
	public static int Zoom = 1500;
	static Map thing;

	public ImageExample() {

		initUI();
	}

	public void initUI() {

		String bl = null;
		newMap = new Graph(this);
		newMap.addNode("ded", new Coordinate(700, 200));
		newMap.addNode("ded3", new Coordinate(500, 500));

		JPanel menupanel = new JPanel();
		JComboBox Combobox = new JComboBox();
		JTextField SearchWindow = new JTextField("Find a Location...");
		JTextArea nnn = new JTextArea("Choose a function");
		JPanel ComboPanel = new JPanel();
		JPanel SearchPanel = new JPanel();
		ComboPanel.add(Combobox);
		Combobox.addItem("Select Option");
		Combobox.addItem("Minimum Distance");
		Combobox.addItem("Find Nearest");
		Combobox.addItem("Plan Road Trip");
		Combobox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (Combobox.getSelectedItem() == "Minimum Distance") {
					nnn.setText("Choose 2 locations to find\nthe minumum distance between:");
				}
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					nnn.setText("Find the nearest town\nto the One selected");
				}
				if (Combobox.getSelectedItem() == "Find Nearest") {
					nnn.setText("Find the best Locations to\nvisit under a certain distance:");
					JTextField DistSearchWindow = new JTextField("Enter Length:");
					JPanel temppanel = new JPanel();
					menupanel.add(temppanel);
					menupanel.remove(nnn);
					temppanel.add(DistSearchWindow);
					JButton newb = new JButton("Find");
					temppanel.add(newb);
					menupanel.add(nnn);
					newb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (Integer.parseInt(DistSearchWindow.getText()) > 0
									|| Integer.parseInt(DistSearchWindow.getText()) < 2000) {
								nnn.setText("Enter New Length:");
								// menupanel.remove(temppanel);

							}

						}
					});

				}
				if (Combobox.getSelectedItem() == "Select Option") {
					nnn.setText("Please Select Something to Do:");
				}

			}
		});
		thing = new Map(this);

		thing.setLayout(new GridLayout(1221, 858));

		SearchPanel.add(SearchWindow);
		JSlider ZoomScroll = new JSlider(1000, 3000);

		ZoomScroll.addChangeListener(new ChangeListener() {
			Map thingy = thing;

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
				if (Combobox.getSelectedItem() == "Minimum Distance") {
					nnn.setText("Choose 2 locations to find\nthe minumum distance between:");

				}

			}
		});
		menupanel.add(ZoomScroll);
		SearchPanel.add(SearchButton);
		menupanel.add(SearchPanel);

		menupanel.add(ComboPanel);
		ComboPanel.add(GoButton);

		menupanel.add(nnn);

		menupanel.setBackground(Color.BLACK);
		add(menupanel, BorderLayout.WEST);
		thing.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				thing.x += e.getX() - xx;
				thing.y += e.getY() - yy;
				Enumeration<JButton> afd = newMap.nodes.elements();

			
				repaint();
				revalidate();

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

		JPanel testpanel = new JPanel();
		testpanel.setLayout(null);

		redrawnodes();

		

		setSize(1500, 1000);
		setTitle("Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	protected void redrawnodes() {
		Enumeration<JButton> afd = newMap.nodes.elements();

		while (afd.hasMoreElements()) {
			add(afd.nextElement());
		}
		add(thing);
		setVisible(true);

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