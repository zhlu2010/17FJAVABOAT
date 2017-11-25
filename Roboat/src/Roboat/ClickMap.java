package Roboat;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
/**
 * 
 * @author 95291
 *set point on map, calculate the distance and change the current location
 */
public class ClickMap extends JFrame {
	private int CurrentX=355;
	private int CurrentY=420;
	private int DestinationX;
	private int DestinationY;
	private int Xdistance;
	private double boatspeed = 40;
	private ArrayList<Point> points;
	
	public ClickMap() {
		super("map");
		Container c = getContentPane();
		setSize(1200,1000);
		setLocation(700,10);
		points = new ArrayList<>(1024);
		MyMouseListener ml=new MyMouseListener();
		c.addMouseListener(ml);
		MapPanel mappanel = new MapPanel();
		c.add(mappanel);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	class MapPanel extends JPanel {
		//Image image=null;
    	public void paintComponent(Graphics g) {
            super.paintComponent(g);           
            try {
            	Image image=ImageIO.read(new File("map1.png"));
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            g.setColor(Color.red);
            g.drawLine(DestinationX-10,DestinationY,DestinationX+10,DestinationY);
            g.drawLine(DestinationX,DestinationY-10,DestinationX,DestinationY+10);
            g.drawLine(CurrentX-10, CurrentY, CurrentX+10, CurrentY);
            g.drawLine(CurrentX, CurrentY-10, CurrentX, CurrentY+10);
    	}
	}
	class MyMouseListener implements MouseListener {
        private Point current;
		
		public void mouseEntered(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
		public void mouseExited(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			Graphics g = getGraphics();
			DestinationX = e.getX();
			DestinationY = e.getY();   
            g.setColor(Color.red);
            g.drawLine(CurrentX,CurrentY,DestinationX,DestinationY);
            current = new Point(CurrentX, CurrentY);
            Xdistance = Math.abs(DestinationX-CurrentX);
            CurrentX = DestinationX;
            CurrentY = DestinationY;
			//Automatic.mapRepaint();
		}
		public void mouseReleased(MouseEvent e) {
			Graphics g = getGraphics();
            g.setXORMode(Color.yellow);
            current.draw(g);
            g.setPaintMode();
            current.setPoint(CurrentX, CurrentY);
            current.draw(g);
            points.add(current);
		}
		public void mouseDragged(MouseEvent e) {}
	}
	public double getLongitude() {
		return 0.00002012*CurrentX-74.0325;
	}
	public double getLatitude() {
		return -0.000028816*CurrentY+40.7523;
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
		//repaint();
	}
	public double getdistance() {
		return Xdistance;
	}
	public void arrived() {
		CurrentX = DestinationX;
    	CurrentY = DestinationY;
    	//repaint();
	}
}
