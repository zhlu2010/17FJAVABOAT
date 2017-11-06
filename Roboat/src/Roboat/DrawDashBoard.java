package Roboat;

import java.awt.*;
import javax.swing.*;

class DrawDashBoard extends JFrame {
    private int[] xRoboat = {200,100,100,300,300,200};
    private int[] yRoboat = {30, 300,700,700,300,30 };
    private int[] xBattery = {195,195,185,185,215,215,205,205,195};
    private int[] yBattery = {300,305,305,406,406,305,305,300,300};
    public static int[] xGas = {200,243,236,243,241};
    public static int[] yGas = {550,525,524,525,532};
    public static int[] xGasRot = xGas;
    public static int[] yGasRot = yGas;
    public static int[] xPropellor1={130,130,125,130,125,130,135,130,135,130,130};
   	public static int[] yPropellor1={700,750,745,750,755,750,755,750,745,750,700};
   	public static int[] xPropellor2={270,270,265,270,265,270,275,270,275,270,270};
   	public static int[] yPropellor2={700,750,745,750,755,750,755,750,745,750,700};
    public double rad = Math.PI / 180;
	private int xCompass=150, yCompass=150, rCompass=50;
	public static int[] xredCompass={200,195,205};
    public static int[] yredCompass={170,200,200};
	public static int[] xwhiteCompass={200,195,205};
	public static int[] ywhiteCompass={230,200,200};
	public static int[] xredCompassOrigin={200,195,205};
    public static int[] yredCompassOrigin={170,200,200};
	public static int[] xwhiteCompassOrigin={200,195,205};
	public static int[] ywhiteCompassOrigin={230,200,200};
    
    public static double xRudder1=200;
	public static double yRudder1=700;
	public static double xRudder2=200;
	public static double yRudder2=740;
	public static double XX;
	public static double YY;
	public static JLabel Propellor1speed;
	public static JLabel Propellor2speed;
	public static int BatteryPower1 = 306;
	public static int BatteryPower2 = 100;
	public static int BatteryColorR=0;
	public static int BatteryColorG=255;
	public static double oilAngle = 0;
	public static double compassAngle = 0;
	
	public static JLabel lblRudder;
    public DrawDashBoard() {
    	super("Dash Board");
    	setLayout(null);
    	setBounds(0, 0, 500, 1000);
    	Container c=getContentPane();
    	lblRudder = new JLabel("Rudder: "+90+"бу");
    	lblRudder.setBounds(160,660,150,30);
    	dashPanel dashPanel=new dashPanel();
    	dashPanel.setBounds(-10,-20,400,800);
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    class dashPanel extends JPanel {
    	public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawPolyline(xRoboat, yRoboat, xRoboat.length);
            //g.drawLine(200, 0, 200, 800);
            g.drawOval(150, 150, 100, 100);
            g.drawPolyline(xBattery, yBattery, xBattery.length);          
            g.setColor(new Color(BatteryColorR,BatteryColorG,0));
            g.fillRect(186, BatteryPower1, 29, BatteryPower2);
            g.setColor(Color.black);
            g.drawArc(150, 500, 100, 100, 30, 120);
            g.drawPolyline(xGasRot, yGasRot, xGasRot.length);
            g.drawPolyline(xPropellor1, yPropellor1, xPropellor1.length);
            g.drawPolyline(xPropellor2, yPropellor2, xPropellor2.length);
            g.drawLine((int)xRudder1, (int)yRudder1, (int)xRudder2, (int)yRudder2);
            
            /*g.drawPolyline(xCompassArrow, yCompassArrow, xCompassArrow.length);
            g.setColor(Color.red);
            g.drawPolyline(xCompassArrowN, yCompassArrowN, xCompassArrowN.length);
            g.setColor(Color.black);*/
            g.drawOval(xCompass, yCompass, rCompass*2, rCompass*2);
            g.setColor(Color.red);
            int x1 = (int) ((rCompass - 10) * Math.sin(rad));  
            int y1 = (int) ((rCompass - 10) * Math.cos(rad));  
            g.drawString("N", xCompass + rCompass + x1 - 4, xCompass + rCompass - y1 + 5);
            int x2 = (int) ((rCompass - 10) * Math.sin(rad*90));  
            int y2 = (int) ((rCompass - 10) * Math.cos(rad*90));
            g.drawString("E", xCompass + rCompass + x2 - 4, xCompass + rCompass - y2 + 5);
            int x3 = (int) ((rCompass - 10) * Math.sin(rad*180));  
            int y3 = (int) ((rCompass - 10) * Math.cos(rad*180));
            g.drawString("S", xCompass + rCompass + x3 - 4, xCompass + rCompass - y3 + 5);
            int x4 = (int) ((rCompass - 10) * Math.sin(rad*270));  
            int y4 = (int) ((rCompass - 10) * Math.cos(rad*270));
            g.drawString("W", xCompass + rCompass + x4 - 4, xCompass + rCompass - y4 + 5);
            g.setColor(Color.black);
            int d = 0;  
            for (int i = 0; i < 60; i++) {  
                int x5 = (int) ((rCompass - 2) * Math.sin(rad * d));  
                int y5 = (int) ((rCompass - 2) * Math.cos(rad * d));  
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
    }
 /* public static void main(String[] args) {
		new DrawDashBoard();
		
	}*/
}
