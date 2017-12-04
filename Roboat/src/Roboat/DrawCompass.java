package Roboat;

import java.awt.*;
import javax.swing.*;
import static java.lang.Math.*;

public class DrawCompass extends JPanel{
    public double rad = Math.PI / 180;
	private int xCompass=150, yCompass=150, rCompass=50;
	private int[] xredCompass={200,195,205};
	private int[] yredCompass={170,200,200};
	private int[] xwhiteCompass={200,195,205};
	private int[] ywhiteCompass={230,200,200};
	private int[] xredCompassOrigin={200,195,205};
    private int[] yredCompassOrigin={170,200,200};
    private int[] xwhiteCompassOrigin={200,195,205};
    private int[] ywhiteCompassOrigin={230,200,200};
    
	public void paintComponent(Graphics g) {
        g.drawOval(xCompass, yCompass, rCompass*2, rCompass*2);
        g.setColor(Color.red);
        int x1 = (int) ((rCompass - 10) * sin(rad));   //TODO: for math-intensive code using static import as above
        int y1 = (int) ((rCompass - 10) * cos(rad));  
        g.drawString("N", xCompass + rCompass + x1 - 4, xCompass + rCompass - y1 + 5);
        int x2 = (int) ((rCompass - 10) * sin(rad*90));   //TODO: why *90?
        int y2 = (int) ((rCompass - 10) * cos(rad*90));
        g.drawString("E", xCompass + rCompass + x2 - 4, xCompass + rCompass - y2 + 5);
        int x3 = (int) ((rCompass - 10) * sin(rad*180));  
        int y3 = (int) ((rCompass - 10) * cos(rad*180));
        g.drawString("S", xCompass + rCompass + x3 - 4, xCompass + rCompass - y3 + 5);
        int x4 = (int) ((rCompass - 10) * sin(rad*270));  
        int y4 = (int) ((rCompass - 10) * cos(rad*270));
        g.drawString("W", xCompass + rCompass + x4 - 4, xCompass + rCompass - y4 + 5);
        g.setColor(Color.black);
        int d = 0;  
        for (int i = 0; i < 60; i++) {  
            int x5 = (int) ((rCompass - 2) * sin(rad * d));  
            int y5 = (int) ((rCompass - 2) * cos(rad * d));  
            g.drawString(".", xCompass + rCompass + x5 - 1, xCompass + rCompass - y5 + 1);
            d += 6;  
        }
        g.setColor(Color.red);
        g.fillPolygon(xredCompass, yredCompass, xredCompass.length);
        g.setColor(Color.black);
        g.drawPolygon(xredCompass, yredCompass, xredCompass.length);
        g.drawPolygon(xwhiteCompass, ywhiteCompass, xwhiteCompass.length);
        g.fillPolygon(xwhiteCompass, ywhiteCompass, xwhiteCompass.length); 
    }
	public void setcompassAngel(double newAngle) {
		Rotation redcompassAngle = new Rotation(200,200,xredCompassOrigin,yredCompassOrigin,newAngle);
		xredCompass=redcompassAngle.Xcoordinate();
		yredCompass=redcompassAngle.Ycoordinate();
		Rotation whitecompassAngle = new Rotation(200,200,xwhiteCompassOrigin,ywhiteCompassOrigin,newAngle);
		xwhiteCompass=whitecompassAngle.Xcoordinate();
		ywhiteCompass=whitecompassAngle.Ycoordinate();
		repaint();
	}
	public void resetCompass() {
		xredCompass = xredCompassOrigin;
		yredCompass = yredCompassOrigin;
		xwhiteCompass = xwhiteCompassOrigin;
		ywhiteCompass = ywhiteCompassOrigin;
		repaint();
	}
}