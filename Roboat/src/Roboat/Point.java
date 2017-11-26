package Roboat;

import java.awt.*;

public class Point {
	private int x1,y1;
	
	public Point(int x1, int y1) {
		this.x1 = x1; this.y1 = y1;
	}
	public void draw(Graphics g) {
		g.setColor(Color.red);
    	g.drawLine(x1-10, y1, x1+10, y1);
        g.drawLine(x1, y1-10, x1, y1+10);
        //g.drawLine(x2-10,y2,x2+10,y2);
        //g.drawLine(x2,y2-10,x2,y2+10);  
	}
	public int getX() {
        return x1;
    }
	public int getY() {
		return y1;
	}
	public void setLocation(int x , int y) {
		x1 = x;
		y1 = y;		
	}
}
