//ceng497-labwork7
//201611018
//Ecem Emiroðlu

import java.awt.*;
import java.awt.event.*;


public class TransformationC extends Frame implements ActionListener{
	
	 static final int windowWidth = 800;
	 static final int windowHeight = 800;
	//1-sol alt
	 //2-sag alt
	 //3-sag ust
	 //4-sol ust
	 
	int[] x = {400,600,600,400};
	int[] y = {400,400,200,200}; 
	public static void main(String[] args) {
		 // Set Frame s ize to 800x800
		 // Set background color
		 // Set visibility
		
		 TransformationC trans =new TransformationC();
		 trans.setSize(windowWidth,windowHeight);
		 trans.setVisible(true);
		 trans.setBackground(Color.getHSBColor(0.55f, 0.2f, 0.9f));
		
		 } 
	public TransformationC() {
		 // Set title
		 // Create menu
		 // Add WindowListener to exit the program when window is closed
		 // Set layout
		 // Add control panel
		 // Add buttons
		
		addWindowListener(new MyFinishWindow());
		 setTitle("Transformations Continued");
		 
		//menu:
			MenuBar menu_bar = new MenuBar();
				
			Menu def = new Menu("File");
			def.add(new MenuItem("Set Default"));
			def.addActionListener(this);
			
			
			menu_bar.add(def);
			setMenuBar(menu_bar);
			//https://www.javatpoint.com/java-awt-panel
	        Panel panel=new Panel();  
	        panel.setBounds(0,40,windowWidth ,40);  
			
	        //https://beginnersbook.com/2015/06/java-awt-tutorial/
			Button button_sx = new Button();
			button_sx.setLabel("Shear in X");
			button_sx.addActionListener(this);
			Button button_sy = new Button();
			button_sy.addActionListener(this);
			button_sy.setLabel("Shear in Y");
			Button button_scx= new Button();
			button_scx.setLabel("Stretch in X");
			button_scx.addActionListener(this);
			Button button_scy= new Button();
			button_scy.setLabel("Stretch in Y");
			button_scy.addActionListener(this);
			Button button_su = new Button();
			button_su.setLabel("Scale Up");
			button_su.addActionListener(this);
			Button button_sd = new Button();
			button_sd.setLabel("Scale Down");
			button_sd.addActionListener(this);
			
			panel.add(button_sx);
			panel.add(button_sy);
			panel.add(button_scx);
			panel.add(button_scy);
			panel.add(button_su);
			panel.add(button_sd);
			
			panel.setBackground(Color.black); 
			
			add(panel);
			setLayout(null);
		 
		 } 
	// Draw 2 lines and paint 1 filled rectangle
	 public void paint(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.setColor(Color.white);
		 g2d.drawLine(400, 0, 400, 800);//dik çizgi
		 g2d.drawLine(0, 400, 800, 400);//yatay
		 g2d.setColor(Color.gray);
		 g2d.fillPolygon(x, y, 4);
	 }
	 
	 public class MyFinishWindow extends WindowAdapter
	   {
	     public void windowClosing(WindowEvent e)
	     {
	       System.exit(0);
	     }
	   }

	 // Action listener
	 public void actionPerformed(ActionEvent e) {
		 String str = e.getActionCommand();
			//System.out.println(str);
			if(str.equals("Set Default")) {
				x[0]=400;
				x[1]=600;
				x[2]=600;
				x[3]=400;
				
				y[0]=400;
				y[1]=400;
				y[2]=200;
				y[3]=200;
				
				repaint();
				
			}
			else if(str.equals("Shear in X")) {
				x[2]=x[2]+50;
				x[3]=x[3]+50;
				repaint();
			}
			else if(str.equals("Shear in Y")) {
				y[1]=y[1]-50;
				y[2]=y[2]-50;
				
				repaint();
			}
			else if(str.equals("Stretch in X")) {
	
				x[1]=x[1]+50;
				x[2]=x[2]+50;
				
				
				repaint();
			}
			else if(str.equals("Stretch in Y")) {
				y[2]=y[2]-50;
				y[3]=y[3]-50;
				
				repaint();
			}
			else if(str.equals("Scale Up")) {
				//right bottom point
				x[1]=x[1]+50;
				//right top point
				x[2]=x[2]+50;
				y[2]=y[2]-50;
				//left top point
				y[3]=y[3]-50;
				
				
				repaint();
			}
			else if(str.equals("Scale Down")) {
				//right bottom point
				x[1]=x[1]-50;
				//right top point
				x[2]=x[2]-50;
				y[2]=y[2]+50;
				//left top point
				y[3]=y[3]+50;
					
				repaint();
			}
	 }
}
