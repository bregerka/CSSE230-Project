
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private Graph newGraph;
	public static int Zoom = 1000;
	static Map thing;

	public ImageExample() {

		initUI();
	}

	public void initUI() {
		setResizable(false);
		String bl = null;
		newGraph = new Graph(this);
		newGraph.addNode("DawnStar", new Coordinate(665, 128));
		newGraph.addNode("Falkreath", new Coordinate(550, 650));
		newGraph.addNode("Markarth", new Coordinate(107, 434));
		newGraph.addNode("Morthal", new Coordinate(482, 263));
		newGraph.addNode("Riften", new Coordinate(1052, 692));
		newGraph.addNode("Solitude", new Coordinate(434, 137));
		newGraph.addNode("WhiteRun", new Coordinate(623, 459));
		newGraph.addNode("Windhelm", new Coordinate(946, 359));
		newGraph.addNode("WinterHold", new Coordinate(868, 135));
		newGraph.addNode("Dragon Bridge", new Coordinate(308, 223));
		newGraph.addNode("Helgen", new Coordinate(634, 664));
		newGraph.addNode("Ivarstead", new Coordinate(785, 610));
		newGraph.addNode("Karthwasten", new Coordinate(230, 346));
		newGraph.addNode("Riverwood", new Coordinate(642, 560));
		newGraph.addNode("Rorikstead", new Coordinate(338, 398));
		newGraph.addNode("Shor's Stone", new Coordinate(1025, 623));

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
					newGraph.nodes.clear();
					nnn.setText("Choose 2 locations to find\nthe minumum distance between:");
				}
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					newGraph.nodes.clear();
					nnn.setText("Find the nearest town\nto the One selected");
				}
				if (Combobox.getSelectedItem() == "Find Nearest") {
					newGraph.nodes.clear();
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
		JSlider ZoomScroll = new JSlider(1000, 3000, 1000);

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
					if (q.size() == 0) {
						nnn.setText("Please select two nodes.");
					}
					if (q.size() == 1) {
						nnn.setText("Please select 1 more node.");
					}
					if (q.size() == 2) {
						Queue save = q;
						nnn.setText(newGraph.findMin(q.poll(),q.poll()));
					}
				}
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					if (q.size() == 0) {
						nnn.setText("Please select two nodes.");
					}
					if (q.size() == 1) {
						nnn.setText("Please select 1 more node.");
					}
					if (q.size() == 2) {
						if (getMinimumTextBox() == null) {
							nnn.setText("Enter minimum travel distance.");
						}
						Queue save = q;
						nnn.setText(newGraph.roadTripCalculator(q.poll(),q.poll(),getMinimumTextBox()));
					}
				}
				if (Combobox.getSelectedItem() == "Find Nearest") {
					if (q.size() == 0) {
						nnn.setText("Please select a start node.");
					}
					if (q.size() == 1) {
						nnn.setText("Check the boxes of the features you want from your destination.");
						ArrayList checkBoxes = new ArrayList();
						addCheckBoxes(menupanel);
					}
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
				System.out.println(e.getX());
				System.out.println(e.getY());
				repaint();

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
	
	protected Object getMinimumTextBox() {
		// TODO Auto-generated method stub.
		return null;
	}

	public void minimumDistance(){
		
	}
	
	public void addCheckBoxes(JPanel menuPanel){
		JPanel checkPanel = new JPanel();
		checkPanel.setLayout(new GridLayout(6,2));
		JCheckBox generalStore = new JCheckBox("general store");
		JCheckBox apothecary = new JCheckBox();
		JCheckBox blacksmith = new JCheckBox();
		JCheckBox inn = new JCheckBox();
		JCheckBox magicStore = new JCheckBox();
		JCheckBox jewelryStore = new JCheckBox();
		checkPanel.add(generalStore);
	}

	protected void redrawnodes() {
		Enumeration<JButton> afd = newGraph.nodes.elements();

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