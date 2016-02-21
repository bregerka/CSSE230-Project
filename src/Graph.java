
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Graph<T> {
	ArrayList<Node> nodes;
	private int numNodes;
	private int numEdges;
	private double maxDistance;
	private double maxTime;
	private ImageExample imageEx;

	public Graph(ImageExample imageExample) {
		this.imageEx = imageExample;
		this.nodes = new ArrayList<>();
		this.numNodes = 0;
		this.numEdges = 0;
	}

	public String toString() {
		return this.nodes.toString();
	}

	public boolean addNode(T e, Coordinate c, int[] i) {
		this.nodes.add(new Node(e, c, i));
		this.numNodes++;
		return true;
	}

	public boolean addNode(Node node) {
		this.nodes.add(node);
		this.numNodes++;
		return true;
	}

	public boolean containsNode(Node e) {
		return this.nodes.contains(e);
	}

	public boolean addEdge(Node e1, Node e2) {
		if (!this.nodes.contains(e1) && !this.nodes.contains(e2))
			return false;
		// e1.addEdge(e2.element);
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
		private double rating;
		private int numRatings;
		private Coordinate c;
		private Image image;
		private int Zoom;
		private JButton nodeButton;
		JPanel nodePanel;
		private int xBorder;
		private int yBorder;

		int[] Matches;
		protected JButton newa;
		ArrayList<Node> Neighbors;

		public Node(T e, Coordinate location, int[] i) {
			loadImage();
			this.Matches = i;
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

			// this.Matches = matches;
			this.newa = new JButton();
			this.newa.setBounds(0, 0, 30, 30);

			this.element = e;
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
				public void actionPerformed(ActionEvent e1) {
					if (java.util.Arrays.asList(Node.this.nodePanel.getComponents()).contains(Node.this.newa)) {
						Node.this.nodePanel.remove(Node.this.newa);
					} else
						Node.this.nodePanel.add(Node.this.newa);

					if (Graph.this.imageEx.q.contains(Node.this))
						Graph.this.imageEx.q.remove(Node.this);
					else
						Graph.this.imageEx.q.add(Node.this);
					Graph.this.imageEx.repaint();

				}
			});

		}

		String getElement() {
			return (String) element;

		}

		void setNeighbors(String[] s) {
			Neighbors = new ArrayList<>();
			for (String item : s) {

				System.out.println(Graph.this.getNode(item));
				Neighbors.add(Graph.this.getNode(item));

			}
		}

		private void loadImage() {

			ImageIcon imagIcon = new ImageIcon("src\\icon.png");
			this.image = imagIcon.getImage();

		}

		public ArrayList<Node> findPaths(Node a, ArrayList<Node> s, ArrayList<Node> temp, int runDistance, int min) {
			System.out.println("pop");
			if (s.contains(this))
				return null;
			
			if (this == a){
				temp.add(this);
				return temp;	
			}
			for (Node item : Neighbors){			
				item.findPaths(a, s, temp, runDistance+=c.distanceTo(item.c),min);
				if(min > runDistance){
					min = runDistance;
					s.addAll(temp);
				}		
//				if(min > runDistance){
//					min = runDistance;
//					s.addAll(temp);
//				}	
			}
			return s;
		}

		public int findMinDistance(Node poll, ArrayList<Node> a, int i) {
			System.out.println("pop2");
			if (a.contains(this))
				return 99999;
			a.add(this);
			if (this == poll)
				return i;

			// int i;
			for (Node item : Neighbors)
				if (i > c.distanceTo(item.c))

					this.findMinDistance(item, a, i += c.distanceTo(item.c));
			return i;
		}

		// public void addEdge(Node e) {
		// Node otherNode = Graph.this.nodes.get(e);
		// double cost = this.c.distanceTo(otherNode.c);
		// // this.neighbors.add(new Edge(otherNode, cost));
		// }

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

		}

	}

	public Node getNode(String string) {
		for (Node item : nodes)
			if (item.getElement().equals(string))
				return item;
		return null;

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

	public ArrayList<Node> getNodes() {
		// TODO Auto-generated method stub.
		return nodes;
	}

}
