
public class Coordinate {
	public double x,y;

	public Coordinate(double horizontal,double vertical){
		this.x = horizontal;
		this.y = vertical;
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double distanceTo(Coordinate c2){
		double dx = this.x - c2.x;
		double dy = this.y - c2.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
}
