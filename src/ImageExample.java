
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
	static Queue<String> q = new LinkedList<String>();
	int xVariable;
	int yVariable;
	private Graph<String> newGraph;
	private boolean checkboxeson;
	private JPanel checkPanel;
	JPanel menuPanel;
	public static int Zoom = 1000;
	static Map map;
	static JTextField SearchWindow;
	static JPanel temppanel;

	public ImageExample() {

		initUI();
	}

	public void initUI() {
		setResizable(false);
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> origin/master
		this.newGraph = new Graph<String>(this);
		setBackground(Color.BLACK);

		this.newGraph.addNode("Dawnstar", new Coordinate(665, 128), new int[] { 0, 1, 1, 1, 0, 0 });
		this.newGraph.addNode("Falkreath", new Coordinate(550, 650), new int[] { 1, 1, 1, 1, 0, 0 });
		this.newGraph.addNode("Markarth", new Coordinate(107, 434), new int[] { 1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Morthal", new Coordinate(482, 263), new int[] { 0, 1, 0, 1, 1, 0 });
		this.newGraph.addNode("Riften", new Coordinate(1052, 692), new int[] { 1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Solitude", new Coordinate(434, 137), new int[] { 1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Whiterun", new Coordinate(623, 459), new int[] { 1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Windhelm", new Coordinate(946, 359), new int[] { 1, 1, 1, 1, 1, 0 });
		this.newGraph.addNode("Winterhold", new Coordinate(868, 135), new int[] { 1, 0, 0, 1, 1, 0 });
		this.newGraph.addNode("Dragon Bridge", new Coordinate(308, 223), new int[] { 0, 0, 0, 1, 0, 0 });
		this.newGraph.addNode("Helgen", new Coordinate(634, 664), new int[] { 0, 0, 0, 0, 0, 0 });
		this.newGraph.addNode("Ivarstead", new Coordinate(785, 610), new int[] { 0, 0, 0, 1, 0, 0 });
		this.newGraph.addNode("Karthwasten", new Coordinate(230, 346), new int[] { 0, 0, 0, 0, 0, 0 });
		this.newGraph.addNode("Riverwood", new Coordinate(642, 560), new int[] { 1, 0, 1, 1, 0, 0 });
		this.newGraph.addNode("Rorikstead", new Coordinate(338, 398), new int[] { 0, 0, 0, 1, 0, 0 });
		this.newGraph.addNode("Shor's Stone", new Coordinate(1025, 623), new int[] { 0, 0, 1, 0, 0, 0 });

		menuPanel = new JPanel();
		JComboBox<String> Combobox = new JComboBox<String>();
		SearchWindow = new JTextField("Find a Location...");
<<<<<<< HEAD
=======
=======

>>>>>>> origin/master
		String bl = null;
		newGraph = new Graph(this);
		int[] f ={1,2,3,5,6,7};
		
//		newGraph.addNode("DawnStar", new Coordinate(665, 128),f);
		
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
//		JComboBox Combobox = new JComboBox();
		JTextField SearchWindow = new JTextField("Find a Location...");
<<<<<<< HEAD
>>>>>>> origin/master
=======

>>>>>>> origin/master
		JTextArea mainText = new JTextArea("Choose a function");
		mainText.setEditable(false);
		JPanel ComboPanel = new JPanel();
		JPanel SearchPanel = new JPanel();
		ComboPanel.add(Combobox);
		Combobox.addItem("Select Option");
		Combobox.addItem("Minimum Distance");
		Combobox.addItem("Find Nearest");
		Combobox.addItem("Plan Road Trip");
		Combobox.addItem("Find close by towns");
		
		Combobox.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				q.clear();
				if (Combobox.getSelectedItem() == "Minimum Distance") {
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(checkPanel)) menuPanel.remove(checkPanel);;
					
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(temppanel))
						menuPanel.remove(temppanel);
					ImageExample.this.newGraph.nodes.clear();
					mainText.setText("Choose 2 locations to find\nthe minimum distance between them.");
				}
				if (Combobox.getSelectedItem() == "Find close by towns") {
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(checkPanel)) menuPanel.remove(checkPanel);;
					
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(temppanel))
						menuPanel.remove(temppanel);
					ImageExample.this.newGraph.nodes.clear();
					mainText.setText("Find all cities under a certain\ndistance from you");
					JTextField DistSearchWindow = new JTextField("Enter Length:");
					temppanel = new JPanel();
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
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(checkPanel)) menuPanel.remove(checkPanel);;
					
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(temppanel))
						menuPanel.remove(temppanel);
					newGraph.nodes.clear();
					mainText.setText("Get options for routes\nbetween two nodes.");

				}
				if (Combobox.getSelectedItem() == "Find Nearest") {
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(checkPanel)) menuPanel.remove(checkPanel);;
					
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(temppanel))
						menuPanel.remove(temppanel);
					ImageExample.this.newGraph.nodes.clear();
					mainText.setText("Find the closest node with the\nfeature(s) you specify.");
					addCheckBoxes(menuPanel);

				}
				if (Combobox.getSelectedItem() == "Select Option") {
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(checkPanel)) menuPanel.remove(checkPanel);;
					
					if (java.util.Arrays.asList(menuPanel.getComponents()).contains(temppanel))
						menuPanel.remove(temppanel);
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
				this.extraMap.ChangeZoom((int) source.getValue());
				repaint();
			}
		});
		menuPanel.setLayout(new BoxLayout(menuPanel, 1));
		JButton SearchButton = new JButton("Search");
		SearchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Enumeration<String> afd = ImageExample.this.newGraph.nodes.keys();

				while (afd.hasMoreElements()) {

					String asd = afd.nextElement().toString();
					if (SearchWindow.getText().equals(asd)) {
						if (q.contains(asd)) {
							q.remove(asd);

						}

						else
							q.offer(asd);
						repaint();
						return;

					}
				}

				SearchWindow.setText("City not found");

			}
		});
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
					}
				}
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					if (q.size() == 0) {
						mainText.setText("Please select two nodes.");
					}
					if (q.size() == 1) {
						System.out.println("Road Trip");
					}

					mainText.setText(
							ImageExample.this.newGraph.roadTripCalculator(q.poll(), q.poll(), getRoadTripTextBox()));

				}
				if (Combobox.getSelectedItem() == "Find Nearest") {
					if (q.size() == 0) {
						mainText.setText("Please select a start node.");
					}
					if (q.size() == 1) {
						mainText.setText("Check the boxes of the features\nyou want from your destination.");
						new ArrayList<Object>();

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
		map.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub.

			}

			@Override
			public void mouseDragged(MouseEvent e) {

				map.x += e.getX() - ImageExample.this.xVariable;
				map.y += e.getY() - ImageExample.this.yVariable;
				repaint();

			}
		});
		map.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				redrawnodes();

			}

			@Override
			public void mousePressed(MouseEvent e) {

				ImageExample.this.xVariable = e.getX();
				ImageExample.this.yVariable = e.getY();
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
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

	protected void removeCheckBoxes() {
		
		// TODO Auto-generated method stub.
		
	}

	protected void checkCheckBoxes() {
		ArrayList isChecked = new ArrayList();
		if (generalStore.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (apothecary.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (blacksmith.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (inn.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (magicStore.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (jewelryStore.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}

	}

	protected Object getRoadTripTextBox() {
		// TODO Auto-generated method stub.
		return null;
	}

	public void minimumDistance() {

	}

	
	JCheckBox generalStore = new JCheckBox("General Store");
	JCheckBox apothecary = new JCheckBox("Apothecary");
	JCheckBox blacksmith = new JCheckBox("Blacksmith");
	JCheckBox inn = new JCheckBox("Inn");
	JCheckBox magicStore = new JCheckBox("Magic Store");
	JCheckBox jewelryStore = new JCheckBox("Jewelry Store");
	public void addCheckBoxes(JPanel menuPanel) {
		checkboxeson=true;
		checkPanel = new JPanel();
		checkPanel.setLayout(new GridLayout(6, 2));
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> origin/master
		JCheckBox generalStore = new JCheckBox("general store");
		JCheckBox apothecary = new JCheckBox("apothecary");
		JCheckBox blacksmith = new JCheckBox("blacksmith");
		JCheckBox inn = new JCheckBox("inn");
		JCheckBox magicStore = new JCheckBox("magicStore");
		JCheckBox jewelryStore = new JCheckBox("jewelryStore");
<<<<<<< HEAD
=======
		
>>>>>>> origin/master
=======

>>>>>>> origin/master
		checkPanel.add(generalStore);
		checkPanel.add(apothecary);
		checkPanel.add(blacksmith);
		checkPanel.add(inn);
		checkPanel.add(magicStore);
		checkPanel.add(jewelryStore);
		menuPanel.add(checkPanel);
	}

	protected void redrawnodes() {
		Enumeration<Graph<String>.Node> afd = this.newGraph.nodes.elements();

		while (afd.hasMoreElements()) {
			add(afd.nextElement());
		}
		add(map);

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