import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main extends JFrame {
	JPanel selectors;
	JPanel map;
	JPanel description;
	int height = this.getHeight();
	int width = this.getWidth();
	boolean flag = true;
	static Queue selectedNodes;
	
	private static float SELECTOR_HEIGHT = (float) 0.30;
	private static float SELECTOR_WIDTH = (float) 1.0;
	private static float MAP_HEIGHT = 1 - SELECTOR_HEIGHT;
	private static float MAP_WIDTH = (float) 0.7;
	private static float DESC_HEIGHT = MAP_HEIGHT;
	private static float DESC_WIDTH = 1 - MAP_WIDTH;
	
	public Main() {
		super("Testing");
		Graph thisGraph = new Graph();
		this.selectors = new JPanel(){
			@Override
			public void paintComponent(Graphics g)
            {
				g.setColor(Color.red);
                g.fillRect(0,0,getWidth(), getHeight());
            }
		};
		this.map = new JPanel(){
			@Override
			public void paintComponent(Graphics g)
            {
                g.setColor(Color.blue);
                g.fillRect(0,0,getWidth(), getHeight());
            }
		};
		this.description = new JPanel(){
			@Override
			public void paintComponent(Graphics g)
            {
                g.setColor(Color.green);
                g.fillRect(0,0,getWidth(), getHeight());
            }
		};
		JButton test = new JButton("???");
//		selectors.add(test);
	    JLabel imageLabel = new JLabel(new ImageIcon("src\\skyrim map.jpg"));
	    this.map.add(imageLabel);
	    this.description.setLayout(new BoxLayout(this.description, 1));
	   	JTextArea descriptionText = new JTextArea("Description:");
//	   	JTextArea save = descriptionText.copy();
	   	Font font1 = new Font("Serif", Font.BOLD, 30);
	   	descriptionText.setFont(font1);
	   	JLabel spaceFiller = new JLabel("                                                                                            ");
	   	
	   	descriptionText.setWrapStyleWord(true);
	   	descriptionText.setBackground(Color.GREEN);
		this.description.add(descriptionText);
		description.add(spaceFiller);
		
		JComboBox<String> needSelector = new JComboBox<>();
		needSelector.addItem("Select Option");
		needSelector.addItem("Minimum Distance"); 
		needSelector.addItem("Find Nearest");
		needSelector.addItem("Plan Road Trip");
		needSelector.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
//				String bl = needSelector.getSelectedItem().toString();
				if (needSelector.getSelectedItem() == "Find Nearest" && flag) {
					String testing = "\n does work?";
					flag = !flag;
					descriptionText.removeAll();
					descriptionText.append(testing);
					
				}
				if (needSelector.getSelectedItem() == "Minimum Distance" && flag){
					String miniTesting = "\n now?";
					flag = !flag;
					descriptionText.append(miniTesting);
					findMinimumDistance();
					
				}
				if (needSelector.getSelectedItem() == "Plan Road Trip" && flag){
					String roadTesting = "\n nfhjhuf";
					flag = !flag;
					descriptionText.append(roadTesting);
				}
			}

			private void findMinimumDistance() {
				if (selectedNodes.size() != 2){
					
				}
			}
		});
		
		
		
//		public void addSelectedNodes(ActionListener e){
//			if (click node){
//				add to queue
//			}
//		}
		
//		JSlider ZoomScroll = new JSlider(1000,3000,1000);
//		ZoomScroll.addChangeListener(new ChangeListener() {
//			Board thingy = thing;
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				JSlider source = (JSlider) e.getSource();
//				thingy.ChangeZoom((int) source.getValue());
//				repaint();
//			}
//		});
//
//
//
//		thing.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				thing.x += e.getX()-xx;
//				thing.y += e.getY()-yy;
//				repaint();
//				System.out.println("x: " + e.getX());
//				System.out.println("y: " + e.getY());
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//	
//				xx = e.getX();
//				yy = e.getY();
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub.
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub.
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub.
//				
//			}
//
//		});

		this.setResizable(false);
		
		setSize(1487,945);
		
        //this.selectors.setBounds(0, 0, (int)(this.width * SELECTOR_WIDTH), (int) (this.height * SELECTOR_HEIGHT));
        //this.map.setBounds(0, (int)(this.width * SELECTOR_WIDTH), (int)(this.width * MAP_WIDTH), (int) (this.height * MAP_HEIGHT));
		//this.description.setBounds((int)(this.width * MAP_WIDTH), (int)(this.width * SELECTOR_WIDTH), (int)(this.width * DESC_WIDTH), (int) (this.height * DESC_HEIGHT));

		this.selectors.add(needSelector);
	    
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weighty = .3;
		getContentPane().add(this.selectors, constraints);
		
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = .65;
		constraints.weighty = .7;
		constraints.anchor = GridBagConstraints.PAGE_START;
		getContentPane().add(this.map, constraints);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.weightx = .35;
		constraints.weighty = .7;
		constraints.anchor = GridBagConstraints.PAGE_END;
		getContentPane().add(this.description, constraints);
		
		selectors.setLayout(new FlowLayout());
		
	}
	
	
	
		
		
		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	    setLayout(new FlowLayout());
//	    setSize(1000, 1000);
////	    JLabel label = new JLabel("pls work?", JLabel.CENTER);
//	    
//	    JLabel imageLabel = new JLabel("", JLabel.RIGHT);
//	    map = new ImageIcon("src\\skyrim test map.jpg");
//	    imageLabel.setIcon(map);
////	    add(label);
////	    
////	    Graphics2D g2d = (Graphics2D) g;
////	    drawImage(imageLabel.getIcon(),0,0,this);
//	    imageLabel.setBounds(0, 0, 500, 500);
//		add(imageLabel);
//		image = map.getImage();
//		paintComponent(g);
//		doDrawing(g);
//		
//	}
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponents(g);
//
//		doDrawing(g);
//
//		Toolkit.getDefaultToolkit().sync();
//	}
//
//	private void doDrawing(Graphics g) {
//		System.out.println("g");
//		Graphics2D g2d = (Graphics2D) g;
//		
//		
//		g2d.drawImage(image, 0, 0, this);
//		
//	}
	public static Queue getQueue(){
		return selectedNodes;
	}

	
	public static void main(String[] args){
		
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run(){
			Main test = new Main();
			test.setVisible(true);
		}
		});
		
	}
}
