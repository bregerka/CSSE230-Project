import java.util.ArrayList;
import java.util.HashMap;

public class Route<T extends Comparable<? super T>> {
	private Graph.Node start;
	private Graph.Node dest;
	private double dEstimate;
	private ArrayList<Graph.Node> path = new ArrayList<Graph.Node>();
	private int cost = 0;
	private int interest;
	private ArrayList<Graph.Node> completeRoute = new ArrayList<Graph.Node>();
	private ArrayList<Graph.Node> visited = new ArrayList<Graph.Node>();

	HashMap<Double, ArrayList<Graph.Node>> finalPath = new HashMap<Double, ArrayList<Graph.Node>>();

	public Route(Graph.Node starter, Graph.Node finish) {
		start = starter;
		dest = finish;
		// start.getNeighbors();
		dEstimate = estimate();
		completeRoute = new ArrayList<Graph.Node>();
		interest = starter.rating + finish.rating;
	}

	public Route(ArrayList<Graph.Node> pathNodes, int distCost) {
		this.path = pathNodes;
		this.cost += distCost;
	}

	public Route(Graph.Node n, int distCost) {
		this.path.add(n);
		this.cost += distCost;
		for (int i = 0; i < path.size(); i++) {
			interest += path.get(i).rating;
		}
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

	public int getInterest() {
		return this.interest;
	}

	public String toString() {
		if (completeRoute == null) {
			System.out.println("complete route is null");
		}
		return this.path.toString();
	}

	private double estimate() {
		Coordinate a = start.c;
		Coordinate b = dest.c;
		return a.distanceTo(b);

	}

	public double getEstimate() {
		return this.dEstimate;
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
