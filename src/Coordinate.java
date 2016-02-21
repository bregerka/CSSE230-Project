
public class Coordinate {
	public int x,y;
	/**
	 * Stores the x and y coordinate values
	 * @param horizontal
	 * @param vertical
	 */
	public Coordinate(int horizontal,int vertical){
		this.x = horizontal;
		this.y = vertical;
	}
	/**
	 * x coord
	 * @return x
	 */
	public int getX(){
		return this.x;
	}
	/**
	 * y coord
	 * @return y
	 */
	public int getY(){
		return this.y;
	}
	/**
	 * Calculates the straight line distance between 2 points
	 * @param c2
	 * @return
	 */
	public int distanceTo(Coordinate c2){
		int dx = this.x - c2.x;
		int dy = this.y - c2.y;
		return (int) Math.sqrt(dx*dx + dy*dy);
	}
}
