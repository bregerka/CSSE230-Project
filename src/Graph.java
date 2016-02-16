
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Queue;

import javax.swing.SwingUtilities;

public class Graph<T>{
	private Hashtable<T, Node> nodes;
	private int numNodes;
	private int numEdges;
	private double maxDistance;
	private double maxTime;
	
	
	public Graph(){
		this.nodes = new Hashtable<T, Node>();
		this.numNodes = 0;
		this.numEdges = 0;
	}
	
	public boolean addNode(T e,Coordinate c){
		this.nodes.put(e, new Node(e,c));
		this.numNodes++;
		return true;
	}
	
	public Node getNode(T e){
		return this.nodes.get(e);	
	}
	
	public Edge getShortestPath(T e){
		Node temp = this.getNode(e);
		return null;
	}
	
	public boolean containsNode(T e){
		return this.nodes.containsKey(e);
	}
	
	public boolean addEdge(T e1, T e2){
		if (!this.nodes.containsKey(e1) && !this.nodes.containsKey(e2)) return false;
		this.nodes.get(e1).addEdge(e2);
		this.numEdges++;
	    return true;
	}
	
	public void setMaxDistance(double x){
		this.maxDistance = x;
	}
	
	public void setMaxTime(double x){
		this.maxTime = x;
	}
	
	class Node implements ActionListener {
		private T element;
		private ArrayList<Edge> neighbors;
		private double rating;
		private int numRatings;
		private Coordinate c;
		
		
		public Node(T e,Coordinate location){
			this.element = e;
			this.neighbors = new ArrayList<Edge>();
			this.c = location;
			this.numRatings = 0;
			this.rating = 0;
		}
		
		public void addEdge(T e) {
			Node otherNode = nodes.get(e);
			double cost = this.c.distanceTo(otherNode.c);
			this.neighbors.add(new Edge(otherNode, cost));
		}
		
		public double addRating(double x){
			this.rating = this.rating*this.numRatings;
			this.numRatings++;
			this.rating = (this.rating + x)/this.numRatings;
			return this.rating;
		}
		
		public ArrayList<Edge> getNeighbors(){
			Main name = Graph.this.returnMain();
			return this.neighbors;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			Queue selectedNodes = Main.getQueue();
			SwingUtilities.windowForComponent(returnGraph());
		}
		
		
	}
	
	private class Edge {
		private Node otherNode;
		//private double cost;
		private double danger;
		private CostFxn costFxn;
		private double straightDist;
				
		public Edge(Node n, double c){
			this.otherNode = n;
			this.straightDist = c;
			this.costFxn = new CostFxn(this.straightDist,this.danger);
		}
		public double distCost(){
			return this.costFxn.distanceCost;
		}
		public double timeCost(){
			return this.costFxn.timeCost;
		}
	}

	public Main returnMain() {
		// TODO Auto-generated method stub.
		return Main.this;
	}


}

