import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Components.FrameComponent;
import Components.MapComponent;


public class Frame extends JFrame {
	private List<FrameComponent> components;
	
	public Frame() {
		System.out.println("Running configuration...");
		this.setSize(1000, 1000);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.components = new ArrayList<>();
		createComponents();
	}

	private void createComponents() {
		FrameComponent map = new MapComponent();
		this.components.add(map);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub.
		super.paint(g);
		this.paintComponents(g);
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		
		System.out.println("Painting components...");
		
		int xBaseline = 0;
		int yBaseline = 0;
		int height = getHeight();
		int width = getWidth();
		
		for (FrameComponent c : this.components) {
			c.paintComponent(xBaseline, yBaseline, height, width, g);
			c.setVisible(true);
			
			height -= c.getHeight();
			width -= c.getWidth();
			
			xBaseline += c.getWidth();
			yBaseline += c.getHeight();
		}
	}
}
