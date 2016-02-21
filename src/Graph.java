import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Graph {
	ArrayList<Node> nodes;
	private int numNodes;
	private int numEdges;
	private double maxDistance;
	private double maxTime;
	private ImageExample imageEx;
	private Node startNode;
	private Node endNode;
	ArrayList<Route> routes;
	PriorityQueue<Route> shortest;

	public Graph(ImageExample imageExample) {
		this.imageEx = imageExample;
		this.nodes = new ArrayList<>();
		this.numNodes = 0;
		this.numEdges = 0;
	}

	public String toString() {
		return this.nodes.toString();
	}

	public boolean addNode(String e, Coordinate c, int[] i) {
		this.nodes.add(new Node(e, c, i));
		this.numNodes++;
		return true;
	}

	public boolean containsNode(Node e) {
		return this.nodes.contains(e);
	}

	public boolean addEdge(Node e1, Node e2) {
		if (!this.nodes.contains(e1) && !this.nodes.contains(e2))
			return false;
		this.numEdges++;
		return true;
	}

	public void setMaxDistance(double x) {
		this.maxDistance = x;
	}

	public void setMaxTime(double x) {
		this.maxTime = x;
	}
	
	class Node extends JPanel {

		String element;
		public ArrayList<Node> nodeNeighbors;
		int rating;
		private int numRatings;
		Coordinate c;
		private Image image;
		private JButton nodeButton;
		JPanel nodePanel;
		private int xBorder;
		private int yBorder;
		int danger = -1;
		int[] Matches;
		protected JButton newa;
		ArrayList<Node> Neighbors;
		private CostFxn cstFxn;

		public Node(String e, Coordinate location, int[] i) {
			loadImage();
//			matches = i;
 
			this.newa = new JButton();
			this.nodePanel = new JPanel();
			this.newa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Graph.this.imageEx.remove(Node.this.newa);
					Graph.this.imageEx.repaint();

				}
			});

			setSize(1, 1);
			
			this.newa = new JButton();
			this.newa.setBounds(0, 0, 30, 30);

			this.element = e;
			//this.cstFxn = new CostFxn(this.danger)
			this.newa = new JButton();
			this.newa.setBounds(0, 0, 30, 30);

			this.element = e;
			this.nodeNeighbors = new ArrayList<Node>();
 
			this.c = location;
			this.numRatings = 0;
			this.rating = 0;
			setVisible(true);
			this.nodeButton = new JButton(e.toString());
			this.nodeButton.setOpaque(false);
			this.nodeButton.setContentAreaFilled(false);
			this.nodeButton.setBorderPainted(false);
			this.nodeButton.setForeground(Color.BLUE);

			this.nodeButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (java.util.Arrays.asList(Node.this.nodePanel.getComponents())
							.contains(Node.this.newa)) {
						Node.this.nodePanel.remove(Node.this.newa);
					} else
						Node.this.nodePanel.add(Node.this.newa);

					if (Graph.this.imageEx.q.contains(Node.this.element
							.toString()))
						Graph.this.imageEx.q.remove(Node.this.element
								.toString());
 
					else
						Graph.this.imageEx.q.add(Node.this);
					Graph.this.imageEx.repaint();

				}
			});

		}
		
		public void setDanger(int danger){
			this.danger = danger;
		}

		String getElement() {
			return this.element;
		}

		void setNeighbors(String[] s) {
			this.Neighbors = new ArrayList<>();
			for (String item : s) {
				System.out.println(Graph.this.getNode(item));
				this.Neighbors.add(Graph.this.getNode(item));
			}
		}

		private void loadImage() {

			ImageIcon imagIcon = new ImageIcon("src\\icon.png");
			this.image = imagIcon.getImage();

		}

		public void addNodeNeighbors(Node e) {
			this.nodeNeighbors.add(e);
		}
 

		public double addRating(double x) {
			this.rating = this.rating * this.numRatings;
			this.numRatings++;
			this.rating = (int) ((this.rating + x) / this.numRatings);
			return this.rating;
		}

		@Override
		public void paintComponent(Graphics g) {
			this.xBorder = ((Graph.this.imageEx.map.x * 2 + this.c.getX()
					* Graph.this.imageEx.Zoom / 1000));
			this.yBorder = ((Graph.this.imageEx.map.y * 2 + this.c.getY()
					* Graph.this.imageEx.Zoom / 1000));

			if (this.xBorder < 1200 && this.yBorder < 850 && this.xBorder > 200
					&& this.yBorder > 0) {
				setBounds(this.xBorder, this.yBorder, 80, 80);
				if (Graph.this.imageEx.q.contains(this.element.toString())) {
					this.nodeButton.setOpaque(true);
					g.drawImage(this.image, 20, 30, 20, 20, null);
				} else {
					this.nodeButton.setOpaque(false);
				}
				this.add(this.nodeButton);
			}
		}
	}

	public Node getNode(String string) {
		for (Node item : this.nodes)
			if (item.getElement().equals(string))
				return item;
		return null;
	}
	
	public ArrayList<Node> getNodes() {
		return this.nodes;
	}

	public String roadTripCalculator(String element, String element2,
			Object roadTripTextBox) {
		return null;
	}
}
