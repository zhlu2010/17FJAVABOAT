package Roboat;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/**
 * 
 * @author 
 *set point on map, calculate the distance and change the current location
 */
public class ClickMap extends JFrame {
	private int CurrentX=400;
	private int CurrentY=250;
	private int DestinationX = CurrentX;
	private int DestinationY = CurrentY;
	private int Xdistance;
	private double boatspeed = 40;
	
	public ClickMap() {
		super("map");
		Container c = getContentPane();
		setSize(800,500);
		setLocation(550,450);
		MyMouseListener ml=new MyMouseListener();
		c.addMouseListener(ml);
		MapPanel mappanel = new MapPanel();
		c.add(mappanel);
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	class MapPanel extends JPanel {
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
			Xdistance = Math.abs(DestinationX-CurrentX);
			Automatic.mapRepaint();
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	public double getLongitude() {
		return CurrentX;
	}
	public double getLatitude() {
		return CurrentY;
	}
	public double getDirection() {
		double directionAng;
		directionAng = - Math.toDegrees(Math.atan((double)(DestinationX-CurrentX)/(double)(DestinationY-CurrentY)));
		if(DestinationY-CurrentY > 0) {
				 directionAng = directionAng +180;
			}
		return directionAng;
	}
	public void changeLocation(double directiontheta) {
		CurrentX += (int)boatspeed*Math.sin(directiontheta);   								
		CurrentY -= (int)boatspeed*Math.cos(directiontheta);
		Xdistance -= Math.abs((int)boatspeed*Math.sin(directiontheta));
		repaint();
	}
	public double getdistance() {
		return Xdistance;
	}
	public void arrived() {
		CurrentX = DestinationX;
    	CurrentY = DestinationY;
    	repaint();
	}
	
	
	/*public static void main(String[] args) {
		ClickMap cm = new ClickMap();
	
		
	}*/
}
