package Roboat;

import java.awt.*;
import javax.swing.*;

public class DrawPropellors extends JPanel{
    private int[] xPropellor1={130,120,130,120,130,140,130,140,130};
    private int[] yPropellor1={750,740,750,760,750,760,750,740,750};
    private int[] xPropellor2={270,260,270,260,270,280,270,280,270};
    private int[] yPropellor2={750,740,750,760,750,760,750,740,750};
    private int[] xPropellor1Origin={130,120,130,120,130,140,130,140,130};
    private int[] yPropellor1Origin={750,740,750,760,750,760,750,740,750};
    private int[] xPropellor2Origin={270,260,270,260,270,280,270,280,270};
    private int[] yPropellor2Origin={750,740,750,760,750,760,750,740,750};
    private int propellor1Angel,propellor2Angel;
    private double propellor1Speed=500;
	private double propellor2Speed=500;
	public void paintComponent(Graphics g) {
		g.drawLine(130, 700, 130, 750);
        g.drawLine(270, 700, 270, 750);
        g.drawPolyline(xPropellor1, yPropellor1, xPropellor1.length);
        g.drawPolyline(xPropellor2, yPropellor2, xPropellor2.length);
    }
	public void Propellor1Rotate() {
		propellor1Angel+=propellor1Speed;
		Rotation Propellor1Angle = new Rotation(130,750,xPropellor1Origin,yPropellor1Origin,propellor1Angel);
		xPropellor1=Propellor1Angle.Xcoordinate();
		yPropellor1=Propellor1Angle.Ycoordinate();
		repaint();
	}
	public void Propellor2Rotate() {
		propellor2Angel+=propellor2Speed;;
		Rotation Propellor2Angle = new Rotation(270,750,xPropellor2Origin,yPropellor2Origin,propellor2Angel);
		xPropellor2=Propellor2Angle.Xcoordinate();
		yPropellor2=Propellor2Angle.Ycoordinate();
		repaint();
	}
	public void resetPropellor1() {
		xPropellor1 = xPropellor1Origin;
		yPropellor1 = yPropellor1Origin;
		repaint();
	}
	public void resetPropellor2() {
		xPropellor2 = xPropellor2Origin;
		yPropellor2 = yPropellor2Origin;
		repaint();
	}
	public double getPropellor1speed() {
		return propellor1Speed;
	}
	public double getPropellor2speed() {
		return propellor2Speed;
	}
}
