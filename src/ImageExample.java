import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
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
	static Graph newGraph;
	private JPanel checkPanel;
	JPanel menuPanel;
	public static int Zoom = 1000;
	static Map map;
	static JTextField SearchWindow;
	static JPanel temppanel; 
	ArrayList<Route> routes;
	RoutePriorityQueue<Route> shortest = new RoutePriorityQueue<Route>();
	static int maxLen = -1;
	static int interestEntered = -1;

	public ImageExample() {

		initUI();
	}

	public void initUI() {
		setResizable(false);

		this.newGraph = new Graph(this);

		setBackground(Color.BLACK);
		this.newGraph.addNode("Dawnstar", new Coordinate(665, 128), new int[] {
				0, 1, 1, 1, 0, 0 });
		this.newGraph.addNode("Falkreath", new Coordinate(550, 650), new int[] {
				1, 1, 1, 1, 0, 0 });
		this.newGraph.addNode("Markarth", new Coordinate(250, 434), new int[] {
				1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Morthal", new Coordinate(482, 263), new int[] {
				0, 1, 0, 1, 1, 0 });
		this.newGraph.addNode("Riften", new Coordinate(1052, 692), new int[] {
				1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Solitude", new Coordinate(434, 137), new int[] {
				1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Whiterun", new Coordinate(623, 459), new int[] {
				1, 1, 1, 1, 1, 1 });
		this.newGraph.addNode("Windhelm", new Coordinate(946, 359), new int[] {
				1, 1, 1, 1, 1, 0 });
		this.newGraph.addNode("Winterhold", new Coordinate(868, 135),
				new int[] { 1, 0, 0, 1, 1, 0 });
		this.newGraph.addNode("Dragon Bridge", new Coordinate(308, 223),
				new int[] { 0, 0, 0, 1, 0, 0 });
		this.newGraph.addNode("Helgen", new Coordinate(634, 664), new int[] {
				0, 0, 0, 0, 0, 0 });
		this.newGraph.addNode("Ivarstead", new Coordinate(785, 610), new int[] {
				0, 0, 0, 1, 0, 0 });
		this.newGraph.addNode("Karthwasten", new Coordinate(230, 346),
				new int[] { 0, 0, 0, 0, 0, 0 });
		this.newGraph.addNode("Riverwood", new Coordinate(642, 560), new int[] {
				1, 0, 1, 1, 0, 0 });
		this.newGraph.addNode("Rorikstead", new Coordinate(338, 398),
				new int[] { 0, 0, 0, 1, 0, 0 });
		this.newGraph.addNode("Shor's Stone", new Coordinate(1025, 623),
				new int[] { 0, 0, 1, 0, 0, 0 });

		newGraph.getNode("Dawnstar").Neighbors = new ArrayList();
		newGraph.getNode("Falkreath").Neighbors = new ArrayList();
		newGraph.getNode("Markarth").Neighbors = new ArrayList();
		newGraph.getNode("Morthal").Neighbors = new ArrayList();
		newGraph.getNode("Riften").Neighbors = new ArrayList();
		newGraph.getNode("Solitude").Neighbors = new ArrayList();
		newGraph.getNode("Whiterun").Neighbors = new ArrayList();
		newGraph.getNode("Windhelm").Neighbors = new ArrayList();
		newGraph.getNode("Winterhold").Neighbors = new ArrayList();
		newGraph.getNode("Dragon Bridge").Neighbors = new ArrayList();
		newGraph.getNode("Helgen").Neighbors = new ArrayList();
		newGraph.getNode("Ivarstead").Neighbors = new ArrayList();
		newGraph.getNode("Karthwasten").Neighbors = new ArrayList();
		newGraph.getNode("Riverwood").Neighbors = new ArrayList();
		newGraph.getNode("Rorikstead").Neighbors = new ArrayList();
		newGraph.getNode("Shor's Stone").Neighbors = new ArrayList();
		newGraph.getNode("Dawnstar").Neighbors
				.add(newGraph.getNode("Solitude"));
		newGraph.getNode("Dawnstar").Neighbors.add(newGraph
				.getNode("Winterhold"));

		newGraph.getNode("Falkreath").Neighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Falkreath").Neighbors.add(newGraph
				.getNode("Riverwood"));
		newGraph.getNode("Falkreath").Neighbors.add(newGraph.getNode("Helgen"));

		newGraph.getNode("Markarth").Neighbors.add(newGraph
				.getNode("Karthwasten"));

		newGraph.getNode("Morthal").Neighbors.add(newGraph.getNode("Solitude"));
		newGraph.getNode("Morthal").Neighbors.add(newGraph
				.getNode("Dragon Bridge"));
		newGraph.getNode("Morthal").Neighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Morthal").Neighbors.add(newGraph.getNode("Whiterun"));

		newGraph.getNode("Riften").Neighbors.add(newGraph
				.getNode("Shor's Stone"));
		newGraph.getNode("Riften").Neighbors.add(newGraph.getNode("Ivarstead"));

		newGraph.getNode("Solitude").Neighbors
				.add(newGraph.getNode("Dawnstar"));
		newGraph.getNode("Solitude").Neighbors.add(newGraph.getNode("Morthal"));
		newGraph.getNode("Solitude").Neighbors.add(newGraph
				.getNode("Dragon Bridge"));

		newGraph.getNode("Whiterun").Neighbors.add(newGraph.getNode("Morthal"));
		newGraph.getNode("Whiterun").Neighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Whiterun").Neighbors.add(newGraph
				.getNode("Riverwood"));
		newGraph.getNode("Whiterun").Neighbors
				.add(newGraph.getNode("Windhelm"));

		newGraph.getNode("Windhelm").Neighbors.add(newGraph
				.getNode("Winterhold"));
		newGraph.getNode("Windhelm").Neighbors
				.add(newGraph.getNode("Whiterun"));
		newGraph.getNode("Windhelm").Neighbors.add(newGraph
				.getNode("Shor's Stone"));

		newGraph.getNode("Winterhold").Neighbors.add(newGraph
				.getNode("Dawnstar"));
		newGraph.getNode("Winterhold").Neighbors.add(newGraph
				.getNode("Windhelm"));

		newGraph.getNode("Dragon Bridge").Neighbors.add(newGraph
				.getNode("Solitude"));
		newGraph.getNode("Dragon Bridge").Neighbors.add(newGraph
				.getNode("Morthal"));
		newGraph.getNode("Dragon Bridge").Neighbors.add(newGraph
				.getNode("Karthwasten"));

		newGraph.getNode("Helgen").Neighbors.add(newGraph.getNode("Falkreath"));
		newGraph.getNode("Helgen").Neighbors.add(newGraph.getNode("Ivarstead"));

		newGraph.getNode("Ivarstead").Neighbors.add(newGraph
				.getNode("Riverwood"));
		newGraph.getNode("Ivarstead").Neighbors.add(newGraph.getNode("Riften"));
		newGraph.getNode("Ivarstead").Neighbors.add(newGraph.getNode("Helgen"));

		newGraph.getNode("Karthwasten").Neighbors.add(newGraph
				.getNode("Dragon Bridge"));
		newGraph.getNode("Karthwasten").Neighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Karthwasten").Neighbors.add(newGraph
				.getNode("Markarth"));

		newGraph.getNode("Riverwood").Neighbors.add(newGraph
				.getNode("Whiterun"));
		newGraph.getNode("Riverwood").Neighbors.add(newGraph
				.getNode("Ivarstead"));
		newGraph.getNode("Riverwood").Neighbors.add(newGraph
				.getNode("Falkreath"));

		newGraph.getNode("Rorikstead").Neighbors.add(newGraph
				.getNode("Karthwasten"));
		newGraph.getNode("Rorikstead").Neighbors.add(newGraph
				.getNode("Morthal"));
		newGraph.getNode("Rorikstead").Neighbors.add(newGraph
				.getNode("Whiterun"));
		newGraph.getNode("Rorikstead").Neighbors.add(newGraph
				.getNode("Falkreath"));

		newGraph.getNode("Shor's Stone").Neighbors.add(newGraph
				.getNode("Windhelm"));
		newGraph.getNode("Shor's Stone").Neighbors.add(newGraph
				.getNode("Riften"));

		newGraph.getNode("Dawnstar").setDanger(5);
		newGraph.getNode("Falkreath").setDanger(4);
		newGraph.getNode("Markarth").setDanger(5);
		newGraph.getNode("Morthal").setDanger(4);
		newGraph.getNode("Riften").setDanger(5);
		newGraph.getNode("Solitude").setDanger(1);
		newGraph.getNode("Whiterun").setDanger(2);
		newGraph.getNode("Windhelm").setDanger(2);
		newGraph.getNode("Winterhold").setDanger(4);
		newGraph.getNode("Dragon Bridge").setDanger(3);
		newGraph.getNode("Helgen").setDanger(3);
		newGraph.getNode("Ivarstead").setDanger(3);
		newGraph.getNode("Karthwasten").setDanger(4);
		newGraph.getNode("Riverwood").setDanger(1);
		newGraph.getNode("Rorikstead").setDanger(3);
		newGraph.getNode("Shor's Stone").setDanger(4);
		
		newGraph.getNode("Dawnstar").setInterest(3);
		newGraph.getNode("Falkreath").setInterest(1);
		newGraph.getNode("Markarth").setInterest(4);
		newGraph.getNode("Morthal").setInterest(3);
		newGraph.getNode("Riften").setInterest(3);
		newGraph.getNode("Solitude").setInterest(2);
		newGraph.getNode("Whiterun").setInterest(5);
		newGraph.getNode("Windhelm").setInterest(4);
		newGraph.getNode("Winterhold").setInterest(5);
		newGraph.getNode("Dragon Bridge").setInterest(2);
		newGraph.getNode("Helgen").setInterest(1);
		newGraph.getNode("Ivarstead").setInterest(2);
		newGraph.getNode("Karthwasten").setInterest(4);
		newGraph.getNode("Riverwood").setInterest(5);
		newGraph.getNode("Rorikstead").setInterest(3);
		newGraph.getNode("Shor's Stone").setInterest(3);

		this.menuPanel = new JPanel();

		newGraph.getNode("Dawnstar").nodeNeighbors = new ArrayList();
		newGraph.getNode("Falkreath").nodeNeighbors = new ArrayList();
		newGraph.getNode("Markarth").nodeNeighbors = new ArrayList();
		newGraph.getNode("Morthal").nodeNeighbors = new ArrayList();
		newGraph.getNode("Riften").nodeNeighbors = new ArrayList();
		newGraph.getNode("Solitude").nodeNeighbors = new ArrayList();
		newGraph.getNode("Whiterun").nodeNeighbors = new ArrayList();
		newGraph.getNode("Windhelm").nodeNeighbors = new ArrayList();
		newGraph.getNode("Winterhold").nodeNeighbors = new ArrayList();
		newGraph.getNode("Dragon Bridge").nodeNeighbors = new ArrayList();
		newGraph.getNode("Helgen").nodeNeighbors = new ArrayList();
		newGraph.getNode("Ivarstead").nodeNeighbors = new ArrayList();
		newGraph.getNode("Karthwasten").nodeNeighbors = new ArrayList();
		newGraph.getNode("Riverwood").nodeNeighbors = new ArrayList();
		newGraph.getNode("Rorikstead").nodeNeighbors = new ArrayList();
		newGraph.getNode("Shor's Stone").nodeNeighbors = new ArrayList();
		newGraph.getNode("Dawnstar").nodeNeighbors.add(newGraph
				.getNode("Solitude"));
		newGraph.getNode("Dawnstar").nodeNeighbors.add(newGraph
				.getNode("Winterhold"));
		newGraph.getNode("Falkreath").nodeNeighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Falkreath").nodeNeighbors.add(newGraph
				.getNode("Riverwood"));
		newGraph.getNode("Falkreath").nodeNeighbors.add(newGraph
				.getNode("Helgen"));
		newGraph.getNode("Markarth").nodeNeighbors.add(newGraph
				.getNode("Karthwasten"));
		newGraph.getNode("Morthal").nodeNeighbors.add(newGraph
				.getNode("Solitude"));
		newGraph.getNode("Morthal").nodeNeighbors.add(newGraph
				.getNode("Dragon Bridge"));
		newGraph.getNode("Morthal").nodeNeighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Morthal").nodeNeighbors.add(newGraph
				.getNode("Whiterun"));
		newGraph.getNode("Riften").nodeNeighbors.add(newGraph
				.getNode("Shor's Stone"));
		newGraph.getNode("Riften").nodeNeighbors.add(newGraph
				.getNode("Ivarstead"));
		newGraph.getNode("Solitude").nodeNeighbors.add(newGraph
				.getNode("Dawnstar"));
		newGraph.getNode("Solitude").nodeNeighbors.add(newGraph
				.getNode("Morthal"));
		newGraph.getNode("Solitude").nodeNeighbors.add(newGraph
				.getNode("Dragon Bridge"));
		newGraph.getNode("Whiterun").nodeNeighbors.add(newGraph
				.getNode("Morthal"));
		newGraph.getNode("Whiterun").nodeNeighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Whiterun").nodeNeighbors.add(newGraph
				.getNode("Riverwood"));
		newGraph.getNode("Whiterun").nodeNeighbors.add(newGraph
				.getNode("Windhelm"));
		newGraph.getNode("Windhelm").nodeNeighbors.add(newGraph
				.getNode("Winterhold"));
		newGraph.getNode("Windhelm").nodeNeighbors.add(newGraph
				.getNode("Whiterun"));
		newGraph.getNode("Windhelm").nodeNeighbors.add(newGraph
				.getNode("Shor's Stone"));
		newGraph.getNode("Winterhold").nodeNeighbors.add(newGraph
				.getNode("Dawnstar"));
		newGraph.getNode("Winterhold").nodeNeighbors.add(newGraph
				.getNode("Windhelm"));
		newGraph.getNode("Dragon Bridge").nodeNeighbors.add(newGraph
				.getNode("Solitude"));
		newGraph.getNode("Dragon Bridge").nodeNeighbors.add(newGraph
				.getNode("Morthal"));
		newGraph.getNode("Dragon Bridge").nodeNeighbors.add(newGraph
				.getNode("Karthwasten"));
		newGraph.getNode("Helgen").nodeNeighbors.add(newGraph
				.getNode("Falkreath"));
		newGraph.getNode("Helgen").nodeNeighbors.add(newGraph
				.getNode("Ivarstead"));
		newGraph.getNode("Ivarstead").nodeNeighbors.add(newGraph
				.getNode("Riverwood"));
		newGraph.getNode("Ivarstead").nodeNeighbors.add(newGraph
				.getNode("Riften"));
		newGraph.getNode("Ivarstead").nodeNeighbors.add(newGraph
				.getNode("Helgen"));
		newGraph.getNode("Karthwasten").nodeNeighbors.add(newGraph
				.getNode("Dragon Bridge"));
		newGraph.getNode("Karthwasten").nodeNeighbors.add(newGraph
				.getNode("Rorikstead"));
		newGraph.getNode("Karthwasten").nodeNeighbors.add(newGraph
				.getNode("Markarth"));
		newGraph.getNode("Riverwood").nodeNeighbors.add(newGraph
				.getNode("Whiterun"));
		newGraph.getNode("Riverwood").nodeNeighbors.add(newGraph
				.getNode("Ivarstead"));
		newGraph.getNode("Riverwood").nodeNeighbors.add(newGraph
				.getNode("Falkreath"));
		newGraph.getNode("Rorikstead").nodeNeighbors.add(newGraph
				.getNode("Karthwasten"));
		newGraph.getNode("Rorikstead").nodeNeighbors.add(newGraph
				.getNode("Morthal"));
		newGraph.getNode("Rorikstead").nodeNeighbors.add(newGraph
				.getNode("Whiterun"));
		newGraph.getNode("Rorikstead").nodeNeighbors.add(newGraph
				.getNode("Falkreath"));
		newGraph.getNode("Shor's Stone").nodeNeighbors.add(newGraph
				.getNode("Windhelm"));
		newGraph.getNode("Shor's Stone").nodeNeighbors.add(newGraph
				.getNode("Riften"));

		this.menuPanel = new JPanel();

		JComboBox<String> Combobox = new JComboBox<String>();
		SearchWindow = new JTextField("Find a Location...");

		JPanel menuPanel = new JPanel();
		// JComboBox Combobox = new JComboBox();
		JTextField SearchWindow = new JTextField("Find a Location...");

		JTextArea mainText = new JTextArea("Choose a function");
		mainText.setEditable(false);
		JPanel ComboPanel = new JPanel();
		JPanel SearchPanel = new JPanel();
		ComboPanel.add(Combobox);
		Combobox.addItem("Select Option");
		Combobox.addItem("Minimum Distance");
//		Combobox.addItem("Find Nearest");
		Combobox.addItem("Plan Road Trip");
		Combobox.addItem("Specify Interest");

		// Combobox.addItem("Find close by towns");

		Combobox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				q.clear();
				if (Combobox.getSelectedItem() == "Minimum Distance") {
					if (java.util.Arrays.asList(menuPanel.getComponents())
							.contains(ImageExample.this.checkPanel))
						menuPanel.remove(ImageExample.this.checkPanel);
					if (java.util.Arrays.asList(menuPanel.getComponents())
							.contains(temppanel))
						menuPanel.remove(temppanel);
					ImageExample.this.newGraph.nodes.clear();
					mainText.setText("Choose 2 locations to find\nthe minimum distance between them.");
				}

				if (Combobox.getSelectedItem() == "Find close by towns") {
					if (java.util.Arrays.asList(menuPanel.getComponents())
							.contains(ImageExample.this.checkPanel))
						menuPanel.remove(ImageExample.this.checkPanel);
					if (Combobox.getSelectedItem() == "Plan Road Trip") {
						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(ImageExample.this.checkPanel))
							menuPanel.remove(ImageExample.this.checkPanel);
						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(temppanel))
							menuPanel.remove(temppanel);
						newGraph.nodes.clear();
						mainText.setText("Get options for routes\nbetween two nodes.");
						JTextField DistSearchWindow = new JTextField(
								"Enter Length:");
						temppanel = new JPanel();
						menuPanel.add(temppanel);
						menuPanel.remove(mainText);
						temppanel.add(DistSearchWindow);
						JButton findButton = new JButton("Find");
						temppanel.add(findButton);
						menuPanel.add(mainText);
						findButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									if (Integer.parseInt(DistSearchWindow
											.getText()) > 0

											|| Integer
													.parseInt(DistSearchWindow
															.getText()) < 20000) {
										mainText.setText("Enter New Length:");
									}
								} catch (Exception a) {
									mainText.setText("Invalid length.");
								}

							}
						});

					}
					if (Combobox.getSelectedItem() == "Plan Road Trip") {
						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(ImageExample.this.checkPanel))
							menuPanel.remove(ImageExample.this.checkPanel);
						

						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(temppanel))
							menuPanel.remove(temppanel);
						ImageExample.this.newGraph.nodes.clear();
						mainText.setText("Get options for routes\nbetween two nodes.");

					}
					if (Combobox.getSelectedItem() == "Find Nearest") {
						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(ImageExample.this.checkPanel))
							menuPanel.remove(ImageExample.this.checkPanel);
						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(temppanel))
							menuPanel.remove(temppanel);
						ImageExample.this.newGraph.nodes.clear();
						mainText.setText("Find the closest node with the\nfeature(s) you specify.");
						addCheckBoxes(menuPanel);

					}
					if (Combobox.getSelectedItem() == "Select Option") {
						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(ImageExample.this.checkPanel))
							menuPanel.remove(ImageExample.this.checkPanel);

						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(temppanel))
							menuPanel.remove(temppanel);
						mainText.setText("Please Select Something to Do.");
					}
					if (Combobox.getSelectedItem() == "Specify Interest") {
						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(ImageExample.this.checkPanel))
							menuPanel.remove(ImageExample.this.checkPanel);

						if (java.util.Arrays.asList(menuPanel.getComponents())
								.contains(temppanel))
							menuPanel.remove(temppanel);
						mainText.setText("Enter an interest rating\n to search for.");
				
					}

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

			Graph tempGraph = newGraph;

			@Override
			public void actionPerformed(ActionEvent e) {
				// Enumeration<String> afd =
				// ImageExample.this.newGraph.nodes.keys();

				for (Object item : this.tempGraph.getNodes()) {
					String asd = ((Graph.Node) item).getElement();
					if (SearchWindow.getText().equals(asd)) {
						if (q.contains(asd)) {
							q.remove(asd);

						} else {
							ArrayList<Graph.Node> gg = this.tempGraph
									.getNodes();
							for (Graph.Node item2 : gg)
								if (item2.element == asd)
									q.offer(item2);
						}
						repaint();
						return;

					}
				}
				q.clear();
				SearchWindow.setText("City not found");

			}
		});
		JButton GoButton = new JButton("Go");
		GoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Combobox.getSelectedItem() == "Specify Interest") {
					System.out.println("fkf");
					if (java.util.Arrays.asList(menuPanel.getComponents())
							.contains(temppanel))
						menuPanel.remove(temppanel);
					JTextField interestWindow = new JTextField(
							"Enter interest level (1-5):");
					temppanel = new JPanel();
					temppanel.add(interestWindow);
					menuPanel.add(temppanel);
					menuPanel.remove(mainText);

					repaint();
					JButton interestButton = new JButton("Find");
					temppanel.add(interestButton);
					menuPanel.add(mainText);
					repaint();
					setVisible(true);
					interestButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if (Integer.parseInt(interestWindow.getText()) > 0

										|| Integer.parseInt(interestWindow
												.getText()) < 20000) {
									// mainText.setText("Enter New Length:");
									interestEntered = Integer.parseInt(interestWindow
											.getText());
									for (Graph.Node u : newGraph.getNodes()){
										if (u.interest == interestEntered){
											mainText.append("\n" + u.element);
										}
									}
								}
							} catch (Exception a) {
								mainText.setText("Invalid number.");
							}

						}
					});
			
				}
				if (Combobox.getSelectedItem() == "Minimum Distance") {
					if (q.size() == 0) {
						mainText.setText("Please select two nodes.");
						// how to check if a node is pressed?
					}
					if (q.size() == 1) {
						mainText.setText("Please select 1 more node.");
					}
					if (q.size() == 2) {
						Graph.Node g = q.poll();
						ArrayList<Graph.Node> shortestPath = shortestPath(g,
								q.poll());

						for (Graph.Node item3 : shortestPath) {
							mainText.append("\n" + item3.getElement());
						}

					}
					q.clear();
				}
				if (Combobox.getSelectedItem() == "Plan Road Trip") {
					if (java.util.Arrays.asList(menuPanel.getComponents())
							.contains(temppanel))
						menuPanel.remove(temppanel);
					JTextField maxDistWindow = new JTextField(
							"Enter Max Travel Distance:");
					temppanel = new JPanel();
					temppanel.add(maxDistWindow);
					menuPanel.add(temppanel);
					menuPanel.remove(mainText);

					JButton findButton = new JButton("Find");
					temppanel.add(findButton);
					menuPanel.add(mainText);
					repaint();
					findButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if (Integer.parseInt(maxDistWindow.getText()) > 0

										|| Integer.parseInt(maxDistWindow
												.getText()) < 20000) {
									// mainText.setText("Enter New Length:");
									maxLen = Integer.parseInt(maxDistWindow
											.getText());
								}
							} catch (Exception a) {
								mainText.setText("Invalid length.");
							}

						}
					});
					if (q.size() == 0) {
						mainText.setText("Please select two nodes.");
					}
					if (q.size() == 1) {
						mainText.setText("Please select 1 more node.");
					}
					if (q.size() == 2) {
						Queue save = q;
						Graph.Node g = q.poll();
						RoutePriorityQueue<Route> temp = roadTripPath(g,
								q.poll());
						for (Route r : temp) {
							if (r.getCost() <= maxLen) {
								ArrayList<Graph.Node> tempNode = r.getPath();
								mainText.append("\nNew Path");
								for (Graph.Node n : tempNode) {
									mainText.append("\n" + n.element);
								}
							}
						}
					}
					q.clear();
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
					q.clear();
				}

			}

			private Object getRoadTripTextBox() {

				Component lengthWindow = menuPanel.getComponent(0);

				return null;
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
		if (this.generalStore.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (this.apothecary.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (this.blacksmith.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (this.inn.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (this.magicStore.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}
		if (this.jewelryStore.isSelected()) {
			isChecked.add(1);
		} else {
			isChecked.add(0);
		}

		ArrayList cityList = new ArrayList();
		cityList.add("Dawnstar");
		cityList.add("Falkreath");
		cityList.add("Markarth");
		cityList.add("Morthal");
		cityList.add("Riften");
		cityList.add("Solitude");
		cityList.add("Whiterun");
		cityList.add("Windhelm");
		cityList.add("Winterhold");
		cityList.add("Dragon Bridge");
		cityList.add("Helgen");
		cityList.add("Ivarstead");
		cityList.add("Karthwasten");
		cityList.add("Riverwood");
		cityList.add("Rorikstead");
		cityList.add("Shor's Stone");
		ArrayList validCities = new ArrayList();
	}

	JCheckBox generalStore = new JCheckBox("General Store");
	JCheckBox apothecary = new JCheckBox("Apothecary");
	JCheckBox blacksmith = new JCheckBox("Blacksmith");
	JCheckBox inn = new JCheckBox("Inn");
	JCheckBox magicStore = new JCheckBox("Magic Store");
	JCheckBox jewelryStore = new JCheckBox("Jewelry Store");

	public void addCheckBoxes(JPanel menuPanel) {

		this.checkPanel = new JPanel();
		this.checkPanel.setLayout(new GridLayout(6, 2));

		this.checkPanel = new JPanel();
		this.checkPanel.setLayout(new GridLayout(6, 2));

		JCheckBox generalStore = new JCheckBox("general store");
		JCheckBox apothecary = new JCheckBox("apothecary");
		JCheckBox blacksmith = new JCheckBox("blacksmith");
		JCheckBox inn = new JCheckBox("inn");
		JCheckBox magicStore = new JCheckBox("magicStore");
		JCheckBox jewelryStore = new JCheckBox("jewelryStore");

		this.checkPanel.add(generalStore);
		this.checkPanel.add(apothecary);
		this.checkPanel.add(blacksmith);
		this.checkPanel.add(inn);
		this.checkPanel.add(magicStore);
		this.checkPanel.add(jewelryStore);
		menuPanel.add(this.checkPanel);

		this.checkPanel.add(generalStore);
		this.checkPanel.add(apothecary);
		this.checkPanel.add(blacksmith);
		this.checkPanel.add(inn);
		this.checkPanel.add(magicStore);
		this.checkPanel.add(jewelryStore);
		menuPanel.add(this.checkPanel);

	}

	protected void redrawnodes() {
		ArrayList<Graph.Node> ggg = this.newGraph.nodes;

		for (Graph.Node item : ggg) {
			add(item);
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

	/**
	 * initialization for finding the shortest path. It sets up an arraylist then passes in the start and end points
	 * along with the initialized arraylist to fill. It then grabs the 1st path from the queue which is sorted to be
	 * the shortest path.
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<Graph.Node> shortestPath(Graph.Node start, Graph.Node end) {
		ArrayList<Graph.Node> temp = new ArrayList<>();
		temp.add(start);
		getPath(temp, start, end, 0);
		return this.shortest.poll().getPath();
	}
	/**
	 * getPath is a helper method that looks at all nodes except the header node. It branches out from
	 * the start point and finds all paths for each neighbor. It creates a route tout of an arraylist of 
	 * nodes which are added to a priority queue. This is comparable so it is able to sort which ones are
	 * the shortest distances.
	 * @param pathNodes
	 * @param current
	 * @param end
	 * @param distance
	 */
	public void getPath(ArrayList<Graph.Node> pathNodes, Graph.Node current,
			Graph.Node end, int distance) {
		for (Graph.Node i : current.nodeNeighbors) {
			if (current.element.equals(end.element)) {
				Route potentialRoute = new Route(pathNodes, distance);
				this.shortest.add(potentialRoute);
			}
			if (!pathNodes.contains(i)) {
				ArrayList<Graph.Node> temp = new ArrayList<Graph.Node>();
				temp.addAll(pathNodes);
				temp.add(i);
				CostFxn cstFxn = new CostFxn(current.c.distanceTo(i.c),
						current.danger);
				getPath(temp, i, end, distance + cstFxn.getDist());
			}
		}
	}
	
	/**
	 * return back the entire priority queue of routes that are found.
	 * @param start
	 * @param end
	 * @return
	 */
	public RoutePriorityQueue<Route> roadTripPath(Graph.Node start,
			Graph.Node end) {
		ArrayList<Graph.Node> temp = new ArrayList<>();
		temp.add(start);
		getPath(temp, start, end, 0);
		return this.shortest;
	}

}