package Components;
import java.awt.Color;
import java.awt.Graphics;


public class MapComponent extends FrameComponent {
	public MapComponent() {
		super();
	}
	
	@Override
	public void paint(Graphics g) {
		this.setBounds();
		
		System.out.println("Painting Map...");
		System.out.println("Height is " + getHeight() + ", width is " + this.getWidth());
		g.setColor(Color.BLUE);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	protected double getHeightPercent() {
		return 1;
	}

	@Override
	protected double getWidthPercent() {
		return .7;
	}

	@Override
	protected int getXPosition() {
		return 0;
	}

	@Override
	protected int getYPosition() {
		return 0;
	}
	
	
}
