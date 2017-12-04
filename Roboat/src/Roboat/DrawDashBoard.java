package Roboat;

import java.awt.*;
import javax.swing.*;
import static java.lang.Math.*;

/*
 * everything on the boat is controlled here, except compass
 */
class DrawDashBoard extends JFrame {
    private final static int[] xRoboat = {200,100,100,300,300,200};
    private final static int[] yRoboat = {30, 300,700,700,300,30 };
   
    private int[] xBattery = {195,195,185,185,215,215,205,205,195};
    private int[] yBattery = {300,305,305,406,406,305,305,300,300};
    private int BatteryPower1 = 306;
	static int BatteryPower2 = 100;
	private int BatteryColorR=0;
	private int BatteryColorG=255;
   
	private int[] xFuel = {200,243,236,243,241};
    private int[] yFuel = {550,525,524,525,532};
    private int[] xFuelRot = xFuel;
    private int[] yFuelRot = yFuel;
    static double fuelAngle = 0;
    
    private double xRudder1=200;
    private double yRudder1=700;
    private double xRudder2=200;
    private double yRudder2=740;
    private double XX;
    private double YY;
	private static JLabel Propellor1speed;
	private static JLabel Propellor2speed;
	
	
	private JLabel lblRudder;	
	private static DrawCompass compass;
	private static DrawPropellors propellors;
	
    public DrawDashBoard() {
    	super("Dash Board");
    	setLayout(null);
    	setBounds(-40, 10, 350, 900);
    	Container c=getContentPane();
    	lblRudder = new JLabel("Rudder: "+90+"бу");
    	lblRudder.setBounds(160,660,150,30);
    	dashPanel dashPanel=new dashPanel();
    	dashPanel.setBounds(-10,-20,400,800);
    	compass=new DrawCompass();
        compass.setBounds(-10,-20,400,800);
        c.add(compass);
        propellors=new DrawPropellors();
        propellors.setBounds(-10,-20,400,800);
        c.add(propellors);
        c.add(lblRudder); c.add(dashPanel);
        
        dashPanel.setLayout(null);
        Propellor1speed = new  JLabel("0.0");
        Propellor1speed.setBounds(110,685,50,21);
        dashPanel.add(Propellor1speed);
        Propellor1speed.setHorizontalAlignment(JTextField.CENTER);
        Propellor2speed = new  JLabel("0.0");
        Propellor2speed.setBounds(240,685,50,21);
        dashPanel.add(Propellor2speed);
        Propellor2speed.setHorizontalAlignment(JTextField.CENTER);
                      
        setVisible(true);
    }
    class dashPanel extends JPanel {
    	public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D)g).setStroke(new BasicStroke(3));
            g.drawPolyline(xRoboat, yRoboat, xRoboat.length);
            ((Graphics2D)g).setStroke(new BasicStroke(1));
            g.drawPolyline(xBattery, yBattery, xBattery.length);          
            g.setColor(new Color(BatteryColorR,BatteryColorG,0));
            g.fillRect(186, BatteryPower1, 29, BatteryPower2);
            g.setColor(Color.black);
            g.drawString((BatteryPower2*100/100)+"%",186,420);
            ((Graphics2D)g).setStroke(new BasicStroke(2));
            g.drawArc(150, 500, 100, 100, 30, 120);
            ((Graphics2D)g).setStroke(new BasicStroke(1));
            g.drawPolyline(xFuelRot, yFuelRot, xFuelRot.length);
            g.drawString((int)((fuelAngle+120)*100/120)+"%",186,570);
            g.drawLine((int)xRudder1, (int)yRudder1, (int)xRudder2, (int)yRudder2);
            g.setColor(Color.red);
            g.setFont(new java.awt.Font("Times New Roman",4,30));
            g.drawString("Roboat",156,650);
        }
    }
    public void setCompassAngle(double newAngle) {
    	compass.setcompassAngel(newAngle);
    }
    public void resetCompass() {
    	compass.resetCompass();
    }
    
    public void setRudderAngle(double newRA) {
    	double rdang = 0;
    	rdang = (newRA-90)*(PI/180);
    	xRudder2=200;
		yRudder2=740;
		double mycos = cos(rdang);
        double mysin = sin(rdang);
        XX = xRudder2 - xRudder1;
        YY = yRudder2 - yRudder1;
        xRudder2=(double)(-(XX*mycos-YY*mysin));
        yRudder2=(double)(XX*mysin+YY*mycos);
        xRudder2+=xRudder1;
        yRudder2+=yRudder1;
        lblRudder.setText("Rudder: "+newRA+"бу");
        repaint();
    }
    public void setPropellor1Speed(double propellor1Speed) {
    	Propellor1speed.setText(""+propellor1Speed);
    	propellors.Propellor1Rotate();
    }
    public void setPropellor2Speed(double propellor2Speed) {
    	Propellor2speed.setText(""+propellor2Speed);
    	propellors.Propellor2Rotate();
    }
    public boolean batteryReduce() {
    	BatteryPower1 +=1;
    	BatteryPower2 -=1;
    	repaint();
    	if (BatteryPower2>25&&BatteryPower2<=60) {
	        	BatteryColorR = 255;
	        	return true;
             }
	          else if (BatteryPower2>0&&BatteryPower2<=25) {
	        	BatteryColorR = 255;
	        	BatteryColorG = 0;
	        	return true;
            	 
             }
          else if(BatteryPower2<=0) {
        	 BatteryPower2=0;
        	 return false;
          } else return true;
    }
    public boolean fuelReduce() {
    	fuelAngle -= 1.2; 
       	Rotation RfuelAngle = new Rotation(200,550,xFuel,yFuel,fuelAngle);
       	xFuelRot=RfuelAngle.Xcoordinate();
       	yFuelRot=RfuelAngle.Ycoordinate();
		repaint();
		if(fuelAngle<=-120) {
			return false;
		}else return true;
    }
    public void reset() {
    	BatteryColorR=0;
		BatteryColorG=255;
		BatteryPower1 = 306;
		BatteryPower2 = 100;
		xFuelRot = xFuel;
		yFuelRot = yFuel;				
		fuelAngle = 0;
		repaint();
    }
    public static double getPropellor1Speed() {
    	return propellors.getPropellor1speed();
    }
    public static double getPropellor2Speed() {
    	return propellors.getPropellor2speed();
    }
 /* public static void main(String[] args) {
		new DrawDashBoard();
		
	}*/
}
