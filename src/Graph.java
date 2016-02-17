
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Graph<T>  {
	Hashtable<T, Node> nodes;
	private int numNodes;
	private int numEdges;
	private double maxDistance;
	private double maxTime;
	private ImageExample imagee;

	public Graph(ImageExample imageExample) {
		this.imagee = imageExample;
		this.nodes = new Hashtable<T, Node>();
		this.numNodes = 0;
		this.numEdges = 0;
	}

	public String toString() {
		return nodes.toString();
	}

	public boolean addNode(T e, Coordinate c) {
		this.nodes.put(e, new Node(e, c));
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

	class Node extends JButton  {
		
		private T element;
		private ArrayList<Edge> neighbors;
		private double rating;
		private int numRatings;
		private Coordinate c;
		private Image image;
		private int Zoom;

		public Node(T e, Coordinate location) {
			
			loadImage();
			setSize(20,20);
			this.element = e;
			this.neighbors = new ArrayList<Edge>();
			this.c = location;
			this.numRatings = 0;
			this.rating = 0;
			setVisible(true);
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("g");
					imagee.q.offer(Node.this);
					
				}
			});
		}
	    private void loadImage() {
	        
	        ImageIcon ii = new ImageIcon("src\\icon.png");
	        image = ii.getImage();        
	     
	    }
		public void addEdge(T e) {
			Node otherNode = nodes.get(e);
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
			setBounds((imagee.thing.x*2 + c.getX()*imagee.Zoom/1000), 
					(imagee.thing.y*2 + c.getY()*imagee.Zoom/1000), 20, 20);
			g.drawImage(image, 0,0,20,20, null);
			
		}

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



}
