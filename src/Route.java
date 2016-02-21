import java.util.ArrayList;

public class Route<T extends Comparable<? super T>> {
	private Graph.Node start;
	private Graph.Node dest;
	private double distEstimate;
	private int cost = 0;
	private ArrayList<Graph.Node> path = new ArrayList<Graph.Node>();
	private ArrayList<Graph.Node> closedList = new ArrayList<Graph.Node>();//nodes already visited

	/**
	 * Create route with a start and finish
	 * @param starter
	 * @param finish
	 */
	public Route(Graph.Node starter, Graph.Node finish) {
		this.start = starter;
		this.dest = finish;
		this.distEstimate = estimate();
	}

	/**
	 * update the routes path and cost
	 * @param pathNodes
	 * @param distCost
	 */
	public Route(ArrayList<Graph.Node> pathNodes, int distCost) {
		this.path = pathNodes;
		this.cost += distCost;
	}
	/**
	 * update a nodes path and cost
	 * @param n
	 * @param distCost
	 */
	public Route(Graph.Node n, int distCost) {
		this.path.add(n);
		this.cost += distCost;
	}
	/**
	 * return the path as a string
	 */
	public String toString() {
		return this.path.toString();
	}
	/**
	 * return the path list
	 * @return
	 */
	public ArrayList<Graph.Node> getList() {
		return this.path;
	}
	/**
	 * get cost for a route
	 * @return cost 
	 */
	public int getCost() {
		return this.cost;
	}
	/**
	 * update the cost function for a route
	 * @param cost
	 * @return
	 */
	public boolean updateCost(Integer cost) {
		this.cost += cost;
		return true;
	}
	/**
	 * return nodes already visited
	 * @return closedList
	 */
	public ArrayList<Graph.Node> getVisited() {
		return this.closedList;
	}

	/**
	 * straight distance between points
	 * @return distance
	 */
	private double estimate() {
		Coordinate a = this.start.c;
		Coordinate b = this.dest.c;
		return a.distanceTo(b);

	}
	/**
	 * return the estimate
	 * @return estimate
	 */
	public double getEstimate() {
		return this.distEstimate;
	}
	/**
	 * 
	 * @return path
	 */
	public ArrayList<Graph.Node> getPath() {
		return this.path;
	}

	/**
	 * compare routes for the priority queue
	 * @param other
	 * @return rankings
	 */
	public int compareTo(Route other) {
		if (this.cost < other.cost)
			return -1;
		if (this.cost > other.cost)
			return 1;
		return 0;
	}

}
