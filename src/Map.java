

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Map extends JPanel {
	static int x=0;
	static int y=0;
	int w;
	int h;
	int hh;
	int ww;
    private Image bardejov;

    ImageExample I ;
    Coordinate c;
    /**
     * Creates a map layout using imageExample
     * @param imageExample
     */
    public Map(ImageExample imageExample) {
    	c = new Coordinate(0, 0);
    	I = imageExample;
        initMap();
        setPreferredSize(new Dimension(1221, 858));
    }
    
    /**
     * Initialize the map
     */
    private void initMap() {
    	 
        loadImage();
        w = bardejov.getWidth(this);
        h =  bardejov.getHeight(this);
        ww=w;
        hh=h;
    }
    /**
     * Load the imageIcon from a .png
     */
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src\\Skyrim_Map.png");
        bardejov = ii.getImage();        
    }
    
    
    /**
     * Paint the component to the graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
    	
    	ww = (int) (w*I.Zoom/1000);
    	hh = (int) (h*I.Zoom/1000);
  
    	
    	
    	setBounds(x, y,ww,hh);
    	
        g.drawImage(bardejov, x, y,ww,hh, null);
    }


/**
 * Allow zoom in and zoom out
 * @param source
 */
	public void ChangeZoom(int source) {
		I.Zoom = source; 
	}






}