import java.util.ArrayList;
import java.util.PriorityQueue;


public class findShortest {
	private Graph.Node startNode;
    private Graph.Node endNode;
    ArrayList<Route> routes;
    PriorityQueue<Route> shortestRoute;


    public findShortest(Graph.Node start, Graph.Node end){
    	this.startNode = start;
    	this.endNode = end;
    	this.routes = new ArrayList<Route>();
        this.shortestRoute = new PriorityQueue<Route>();
    }
    
    public void getPath(ArrayList<Graph.Node> pathNodes, Graph.Node current, int distance){
    	for (Graph.Node i : current.nodeNeighbors){
    		
    	}
    }
}
