package TestRoboat;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import TestRoboat.Map.MyMouseListener;

import java.io.*;

public class ClickMap extends JFrame {
	public static int CurrentX=400;
	public static int CurrentY=250;
	public static int DestinationX = CurrentX;
	public static int DestinationY = CurrentY;
	public static int Xdistance;
	public static double boatspeed = 40;
	
	public ClickMap() {
		super("map");
		Container c = getContentPane();
		setSize(800,500);
		setLocation(550,450);
		MyMouseListener ml=new MyMouseListener();
		c.addMouseListener(ml);
		mappanel mappanel = new mappanel();
		c.add(mappanel);
		
		//setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//TODO: Use Java conventions for class names: MapPanel
	class mappanel extends JPanel {
    	public void paintComponent(Graphics g) {
            super.paintComponent(g);            
            g.setColor(Color.RED);
            g.drawLine(DestinationX-10,DestinationY,DestinationX+10,DestinationY);
            g.drawLine(DestinationX,DestinationY-10,DestinationX,DestinationY+10);
            g.setColor(Color.black);
            g.drawLine(CurrentX-10, CurrentY, CurrentX+10, CurrentY);
            g.drawLine(CurrentX, CurrentY-10, CurrentX, CurrentY+10);
            g.drawLine(CurrentX,CurrentY,DestinationX,DestinationY);
    	}
	}
	class MyMouseListener implements MouseListener {
		public void mouseEntered(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
		public void mouseExited(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		public void mouseClicked(MouseEvent e) {			
			
		}
		public void mousePressed(MouseEvent e) {
			DestinationX = e.getX();
			DestinationY = e.getY();			
			Main.map.repaint();
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	/*public static void main(String[] args) {
		new ClickMap();
	}*/
}
