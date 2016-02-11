
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph<T> {
	private Hashtable<T, Node> nodes;
	private int numNodes;
	private int numEdges;
	
	public Graph(){
		this.nodes = new Hashtable<T, Node>();
		this.numNodes = 0;
		this.numEdges = 0;
	}
	
	public boolean addNode(T e,Coordinate c) {
		this.nodes.put(e, new Node(e,c));
		this.numNodes++;
		return true;
	}
	
	public Node getNode(T e){
		return this.nodes.get(e);	
	}
	
	public boolean containsNode(T e){
		return this.nodes.containsKey(e);
	}
	
	
	
	public boolean addEdge(T e1, T e2, int cost) {
		if (!this.nodes.containsKey(e1) && !this.nodes.containsKey(e2)) return false;
		this.nodes.get(e1).addEdge(e2, cost);
		this.numEdges++;
	    return true;
	}
	
	private class Node {
		private T element;
		private ArrayList<Edge> neighbors;
		private double rating;
		private int numRatings;
		private Coordinate c;
		
		public Node(T e,Coordinate location){
			this.element = e;
			this.neighbors = new ArrayList<Edge>();
			this.c = location;
		}
		
		public void addEdge(T e, int cost) {
			Node otherNode = nodes.get(e);
			this.neighbors.add(new Edge(otherNode, cost));
		}
	}
	
	private class Edge {
		private Node otherNode;
		private int cost;
				
		public Edge(Node n, int c){
			this.otherNode = n;
			this.cost = c;
		}
	}


}

