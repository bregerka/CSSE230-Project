

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	int x=0;
	int y=0;
	int w;
	int h;
	int Zoom = 1000;
    private Image image;
	private int hh;
	private int ww;

    public Board() {

        initBoard();
    }
    
    
    
    private void initBoard() {
        
        loadImage();
        
        w = image.getWidth(this);
        h =  image.getHeight(this);

              
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src\\Skyrim_Map.png");
        image = ii.getImage();        
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	ww = (int) (w*Zoom/1000);
    	hh = (int) (h*Zoom/1000);
    	
    	
    	
    	
        g.drawImage(image, x, y,ww,hh, null);
    }



	public void ChangeZoom(int source) {
		Zoom = source;
		x -= ((int) (w*Zoom/1000) -ww)/2;
		y -= ((int) (h*Zoom/1000) -hh)/2;
	}







}