import java.util.ArrayList;

public class Route<T extends Comparable<? super T>> {
	private Graph.Node start;
	private Graph.Node dest;
	private double distEstimate;
	private int cost = 0;
	private ArrayList<Graph.Node> path = new ArrayList<Graph.Node>();
	private ArrayList<Graph.Node> visited = new ArrayList<Graph.Node>();

	public Route(Graph.Node starter, Graph.Node finish) {
		this.start = starter;
		this.dest = finish;
		this.distEstimate = estimate();
	}

	public Route(ArrayList<Graph.Node> pathNodes, int distCost) {
		this.path = pathNodes;
		this.cost += distCost;
	}

	public Route(Graph.Node n, int distCost) {
		this.path.add(n);
		this.cost += distCost;
	}

	public ArrayList<Graph.Node> getList() {
		return this.path;
	}

	public int getCost() {
		return this.cost;
	}

	public boolean updateCost(Integer cost) {
		this.cost += cost;
		return true;
	}

	public ArrayList<Graph.Node> getVisited() {
		return this.visited;
	}

	public String toString() {
		return this.path.toString();
	}

	private double estimate() {
		Coordinate a = this.start.c;
		Coordinate b = this.dest.c;
		return a.distanceTo(b);

	}

	public double getEstimate() {
		return this.distEstimate;
	}

	public ArrayList<Graph.Node> getPath() {
		return this.path;
	}

	public int compareTo(Route other) {
		if (this.cost < other.cost)
			return -1;
		if (this.cost > other.cost)
			return 1;
		return 0;
	}

}
