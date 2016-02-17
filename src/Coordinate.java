
public class Coordinate {
	public int x,y;

	public Coordinate(int horizontal,int vertical){
		this.x = horizontal;
		this.y = vertical;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int distanceTo(Coordinate c2){
		int dx = this.x - c2.x;
		int dy = this.y - c2.y;
		return (int) Math.sqrt(dx*dx + dy*dy);
	}
}
