
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Graph<T> {
	Hashtable<T, Node> nodes;
	private int numNodes;
	private int numEdges;
	private double maxDistance;
	private double maxTime;
	private ImageExample imageEx;

	public Graph(ImageExample imageExample) {
		this.imageEx = imageExample;
		this.nodes = new Hashtable<T, Node>();
		this.numNodes = 0;
		this.numEdges = 0;
	}

	public String toString() {
		return this.nodes.toString();
	}

<<<<<<< HEAD
	public boolean addNode(T e, Coordinate c, int[] i) {
		this.nodes.put(e, new Node(e, c, i));
=======
	public boolean addNode(T e, Coordinate c) {
		this.nodes.put(e, new Node(e, c));
>>>>>>> origin/master
		this.numNodes++;
		return true;
	}

	public Node getNode(T e) {
		return this.nodes.get(e);
	}

	public boolean containsNode(T e) {
		return this.nodes.containsKey(e);
	}

	public boolean addEdge(T e1, T e2) {
		if (!this.nodes.containsKey(e1) && !this.nodes.containsKey(e2))
			return false;
		this.nodes.get(e1).addEdge(e2);
		this.numEdges++;
		return true;
	}

	public void setMaxDistance(double x) {
		this.maxDistance = x;
	}

	public void setMaxTime(double x) {
		this.maxTime = x;
	}

	public String findMin(Node one, Node two) {
		return "-1";
	}

	class Node extends JPanel {

		T element;
		private ArrayList<Edge> neighbors;
		private double rating;
		private int numRatings;
		private Coordinate c;
		private Image image;
		private int Zoom;
		private JButton nodeButton;
		JPanel nodePanel;
		private int xBorder;
		private int yBorder;
<<<<<<< HEAD

		int[] Matches;
		protected JButton newa;
=======
>>>>>>> origin/master

		public Node(T e, Coordinate location) {
			loadImage();
			this.newa = new JButton();
			nodePanel = new JPanel();
			this.newa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Graph.this.imageEx.remove(Node.this.newa);
					Graph.this.imageEx.repaint();
					
					
				}
			});

			setSize(1, 1);
<<<<<<< HEAD
			this.Matches = matches;
			this.newa = new JButton();
			newa.setBounds(0, 0, 30, 30);
=======
>>>>>>> origin/master

			this.element = e;
			this.neighbors = new ArrayList<Edge>();
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

				@Override
				public void actionPerformed(ActionEvent e) {
					if (java.util.Arrays.asList(nodePanel.getComponents()).contains(newa)){
						nodePanel.remove(newa);
					}
					else nodePanel.add(newa);
					
					if (Graph.this.imageEx.q.contains(Node.this.element.toString()))
						Graph.this.imageEx.q.remove(Node.this.element.toString());
					else
						Graph.this.imageEx.q.offer(Node.this.element.toString());
					Graph.this.imageEx.repaint();

				}
			});

		}

		private void loadImage() {

			ImageIcon imagIcon = new ImageIcon("src\\icon.png");
			this.image = imagIcon.getImage();

		}

		public void addEdge(T e) {
			Node otherNode = Graph.this.nodes.get(e);
			double cost = this.c.distanceTo(otherNode.c);
			this.neighbors.add(new Edge(otherNode, cost));
		}

		public double addRating(double x) {
			this.rating = this.rating * this.numRatings;
			this.numRatings++;
			this.rating = (this.rating + x) / this.numRatings;
			return this.rating;
		}

		@Override
		public void paintComponent(Graphics g) {
			this.xBorder = ((Graph.this.imageEx.map.x * 2 + this.c.getX() * Graph.this.imageEx.Zoom / 1000));
			this.yBorder = ((Graph.this.imageEx.map.y * 2 + this.c.getY() * Graph.this.imageEx.Zoom / 1000));

			if (this.xBorder < 1200 && this.yBorder < 850 && this.xBorder > 200 && this.yBorder > 0) {
				setBounds(this.xBorder, this.yBorder, 80, 80);
				if (Graph.this.imageEx.q.contains(this.element.toString())) {
					this.nodeButton.setOpaque(true);
					g.drawImage(this.image, 20, 30, 20, 20, null);
				} else {
					this.nodeButton.setOpaque(false);
				}
				this.add(this.nodeButton);

			}

<<<<<<< HEAD
		}
=======
>>>>>>> origin/master

	}

	private class Edge {
		private Node otherNode;
		// private double cost;
		private double danger;
		private CostFxn costFxn;
		private double straightDist;

		public Edge(Node n, double c) {
			this.otherNode = n;
			this.straightDist = c;
			this.costFxn = new CostFxn(this.straightDist, this.danger);
		}

		public double distCost() {
			return this.costFxn.distanceCost;
		}

		public double timeCost() {
			return this.costFxn.timeCost;
		}
	}

	public String roadTripCalculator(String string, String string2, Object minimumTextBox) {
		// TODO Auto-generated method stub.
		return null;
	}

}
