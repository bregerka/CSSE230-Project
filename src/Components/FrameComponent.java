package Components;
import java.awt.Graphics;

import javax.swing.JComponent;


public abstract class FrameComponent extends JComponent {
	private int frameHeight;
	private int frameWidth;
	private int xBaseline;
	private int yBaseline;
	
	public void paintComponent(int xBaseline, int yBaseline, int height, int width, Graphics g) {
		this.frameHeight = height;
		this.frameWidth = width;
		this.xBaseline = xBaseline;
		this.yBaseline = yBaseline;
		this.paint(g);
	}

	protected void setBounds() {
		this.setBounds(this.getXPosition() + xBaseline, this.getYPosition() + yBaseline, 
				(int) (this.getWidthPercent() * this.frameWidth), (int) (this.getHeightPercent() * this.frameHeight));
	}
	
	protected abstract double getHeightPercent();
	protected abstract double getWidthPercent();
	protected abstract int getXPosition();
	protected abstract int getYPosition();
}
