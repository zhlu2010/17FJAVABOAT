package Roboat;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import static java.lang.Math.*;
/**
 * 
 * @author 95291
 *set point on map, calculate the distance and change the current location
 */
public class ClickMap extends JFrame {
	private static int CurrentX=355;
	private static int CurrentY=420;
	private int Xdistance;
	private Speed boatspeed=new Speed();
	private ArrayList<Point> points;
	private Point current;
	
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
		current= new Point(CurrentX,CurrentY);

		setVisible(true);
	}
	class MapPanel extends JPanel {
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
            current.draw(g);
            if(points.size()>0) 
            	g.drawLine(CurrentX, CurrentY, points.get(0).getX(), points.get(0).getY());            	
            for (int i = 0; i < points.size()-1; i++) {
            	g.drawLine(points.get(i).getX(),points.get(i).getY(),points.get(i+1).getX(),points.get(i+1).getY());
            }
            for (Point p : points) {
            	p.draw(g);
            }
    	}
	}
	class MyMouseListener implements MouseListener {
        private Point destination;
		
		public void mouseEntered(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
		public void mouseExited(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
            destination = new Point(e.getX(), e.getY());
            points.add(destination);
			Automatic.mapRepaint();
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseDragged(MouseEvent e) {}
	}
	public static double getLongitude() {
		double f=0.00002012*CurrentX-74.0325;  
		BigDecimal b=new BigDecimal(f);
		return b.setScale(6,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public static double getLatitude() {
		double f=-0.000028816*CurrentY+40.7523;  
		BigDecimal b=new BigDecimal(f);
		return b.setScale(6,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getDirection() {
		double directionAng;
		if (points.size()>0) {
			directionAng = - Math.toDegrees(Math.atan((double)(points.get(0).getX()-CurrentX)/(double)(points.get(0).getY()-CurrentY)));
			if(points.get(0).getY()-CurrentY > 0) {
				directionAng = directionAng +180;
			}
			return directionAng;
		} else return 0;
	}
	public void changeLocation() {
		double directiontheta = (getDirection())*(PI/180);
		Xdistance -= abs(boatspeed.getSpeed()*sin(directiontheta));
		if (Xdistance>0) {
			CurrentX += boatspeed.getSpeed()*sin(directiontheta);   								
			CurrentY -= boatspeed.getSpeed()*cos(directiontheta);
			current.setLocation(CurrentX, CurrentY);        	
		}else {
			CurrentX = points.get(0).getX();
			CurrentY = points.get(0).getY();
			current.setLocation(CurrentX, CurrentY);
			points.remove(0);
			setDistance();
		}
	}
	public void setDistance() {
		if (points.size()>0) {
			Xdistance = abs(points.get(0).getX()-CurrentX);
		} else Xdistance = 0;
	}
	public double getDistance() {
		return Xdistance;
	}
	public boolean arrived() {
		if(points.size()>0) {
			return true;
		}else return false;
	}
}
