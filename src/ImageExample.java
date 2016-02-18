
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
	int xVariable;
	int yVariable;
	private Graph newGraph;
	public static int Zoom = 1000;
	static Map map;

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

		JPanel menuPanel = new JPanel();
		JComboBox Combobox = new JComboBox();
		JTextField SearchWindow = new JTextField("Find a Location...");
		JTextArea mainText = new JTextArea("Choose a function");
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
					mainText.setText("Choose 2 locations to find\nthe minimum distance between them.");
				}
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					newGraph.nodes.clear();
					mainText.setText("Get options for routes between two nodes.");
					
				}
				if (Combobox.getSelectedItem() == "Find Nearest") {
					newGraph.nodes.clear();
					mainText.setText("Find the closest node with the feature(s) you specify.");
					JTextField DistSearchWindow = new JTextField("Enter Length:");
					JPanel temppanel = new JPanel();
					menuPanel.add(temppanel);
					menuPanel.remove(mainText);
					temppanel.add(DistSearchWindow);
					JButton newb = new JButton("Find");
					temppanel.add(newb);
					menuPanel.add(mainText);
					newb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (Integer.parseInt(DistSearchWindow.getText()) > 0
									|| Integer.parseInt(DistSearchWindow.getText()) < 2000) {
								mainText.setText("Enter New Length:");
								// menuPanel.remove(temppanel);

							}

						}
					});

				}
				if (Combobox.getSelectedItem() == "Select Option") {
					mainText.setText("Please Select Something to Do.");
				}

			}
		});
		map = new Map(this);

		map.setLayout(new GridLayout(1221, 858));

		SearchPanel.add(SearchWindow);
		JSlider ZoomScroll = new JSlider(1000, 3000, 1000);

		ZoomScroll.addChangeListener(new ChangeListener() {
			Map extraMap = map;

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				extraMap.ChangeZoom((int) source.getValue());
				repaint();
			}
		});
		menuPanel.setLayout(new BoxLayout(menuPanel, 1));
		JButton SearchButton = new JButton("Search");
		JButton GoButton = new JButton("Go");
		GoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Combobox.getSelectedItem() == "Minimum Distance") {
					if (q.size() == 0) {
						mainText.setText("Please select two nodes.");
					}
					if (q.size() == 1) {
						mainText.setText("Please select 1 more node.");
					}
					if (q.size() == 2) {
						Queue save = q;
						mainText.setText(newGraph.findMin(q.poll(),q.poll()));
					}
				}
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					if (q.size() == 0) {
						mainText.setText("Please select two nodes.");
					}
					if (q.size() == 1) {
						mainText.setText("Please select 1 more node.");
					}
					if (q.size() == 2) {
						if (getRoadTripTextBox() == null) {
							mainText.setText("Enter minimum travel distance.");
						}
						Queue save = q;
						mainText.setText(newGraph.roadTripCalculator(q.poll(),q.poll(),getRoadTripTextBox()));
					}
				}
				if (Combobox.getSelectedItem() == "Find Nearest") {
					if (q.size() == 0) {
						mainText.setText("Please select a start node.");
					}
					if (q.size() == 1) {
						mainText.setText("Check the boxes of the features you want from your destination.");
						ArrayList checkBoxes = new ArrayList();
						addCheckBoxes(menuPanel);
						checkCheckBoxes();
					}
				}

			}
		});
		menuPanel.add(ZoomScroll);
		SearchPanel.add(SearchButton);
		menuPanel.add(SearchPanel);

		menuPanel.add(ComboPanel);
		ComboPanel.add(GoButton);

		menuPanel.add(mainText);

		menuPanel.setBackground(Color.BLACK);
		add(menuPanel, BorderLayout.WEST);
		map.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				map.x += e.getX() - xVariable;
				map.y += e.getY() - yVariable;
				System.out.println(e.getX());
				System.out.println(e.getY());
				repaint();

			}

			@Override
			public void mousePressed(MouseEvent e) {

				xVariable = e.getX();
				yVariable = e.getY();
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

		setSize(1300, 900);
		setTitle("Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	protected void checkCheckBoxes() {
		
	}

	protected Object getRoadTripTextBox() {
		// TODO Auto-generated method stub.
		return null;
	}

	public void minimumDistance(){
		
	}
	
	public void addCheckBoxes(JPanel menuPanel){
		JPanel checkPanel = new JPanel();
		checkPanel.setLayout(new GridLayout(6,2));
		JCheckBox generalStore = new JCheckBox("General Store");
		JCheckBox apothecary = new JCheckBox("Apothecary");
		JCheckBox blacksmith = new JCheckBox("Blacksmith");
		JCheckBox inn = new JCheckBox("Inn");
		JCheckBox magicStore = new JCheckBox("Magic Store");
		JCheckBox jewelryStore = new JCheckBox("Jewelry Store");
		checkPanel.add(generalStore);
		checkPanel.add(apothecary);
		checkPanel.add(blacksmith);
		checkPanel.add(inn);
		checkPanel.add(magicStore);
		checkPanel.add(jewelryStore);
		menuPanel.add(checkPanel);
	}

	protected void redrawnodes() {
		Enumeration<JButton> afd = newGraph.nodes.elements();

		while (afd.hasMoreElements()) {
			add(afd.nextElement());
		}
		add(map);
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