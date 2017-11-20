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
    private final static int[] xPropellor1={130,130,125,130,125,130,135,130,135,130,130};
    private final static int[] yPropellor1={700,750,745,750,755,750,755,750,745,750,700};
    private final static int[] xPropellor2={270,270,265,270,265,270,275,270,275,270,270};
    private final static int[] yPropellor2={700,750,745,750,755,750,755,750,745,750,700};
   
    private int[] xBattery = {195,195,185,185,215,215,205,205,195};
    private int[] yBattery = {300,305,305,406,406,305,305,300,300};
    private int BatteryPower1 = 306;
	private int BatteryPower2 = 100;
	private int BatteryColorR=0;
	private int BatteryColorG=255;
	
   
	private int[] xGas = {200,243,236,243,241};
    private int[] yGas = {550,525,524,525,532};
    private int[] xGasRot = xGas;
    private int[] yGasRot = yGas;
	private double oilAngle = 0;
    
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
	
    public DrawDashBoard() {
    	super("Dash Board");
    	setLayout(null);
    	setBounds(0, 0, 500, 1000);
    	Container c=getContentPane();
    	lblRudder = new JLabel("Rudder: "+90+"бу");
    	lblRudder.setBounds(160,660,150,30);
    	dashPanel dashPanel=new dashPanel();
    	dashPanel.setBounds(-10,-20,400,800);
    	compass=new DrawCompass();
        compass.setBounds(-10,-20,400,400);
        c.add(compass);
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
    }

    class dashPanel extends JPanel {
    	public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawPolyline(xRoboat, yRoboat, xRoboat.length);
            g.drawPolyline(xBattery, yBattery, xBattery.length);          
            g.setColor(new Color(BatteryColorR,BatteryColorG,0));
            g.fillRect(186, BatteryPower1, 29, BatteryPower2);
            g.setColor(Color.black);
            g.drawString((BatteryPower2*100/100)+"%",186,420);
            g.drawArc(150, 500, 100, 100, 30, 120);
            g.drawPolyline(xGasRot, yGasRot, xGasRot.length);
            g.drawString(((int)(oilAngle+120)*100/120)+"%",186,570);
            g.drawPolyline(xPropellor1, yPropellor1, xPropellor1.length);
            g.drawPolyline(xPropellor2, yPropellor2, xPropellor2.length);
            g.drawLine((int)xRudder1, (int)yRudder1, (int)xRudder2, (int)yRudder2);
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
    	rdang = (newRA-90)*(Math.PI/180);
    	xRudder2=200;
		yRudder2=740;
		double mycos = Math.cos(rdang);
        double mysin = Math.sin(rdang);
        XX = xRudder2 - xRudder1;
        YY = yRudder2 - yRudder1;
        xRudder2=(double)(-(XX*mycos-YY*mysin));
        yRudder2=(double)(XX*mysin+YY*mycos);
        xRudder2+=xRudder1;
        yRudder2+=yRudder1;
        lblRudder.setText("Rudder: "+newRA+"бу");
        repaint();
    }
    public static void setPropellor1Speed(double p1sp) {
    	Propellor1speed.setText(""+p1sp);
    }
    public static void setPropellor2Speed(double p2sp) {
    	Propellor2speed.setText(""+p2sp);
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
    public boolean oilReduce() {
    	oilAngle -= 1.2; 
       	Rotation RoilAngle = new Rotation(200,550,xGas,yGas,oilAngle);
		xGasRot=RoilAngle.Xcoordinate();
		yGasRot=RoilAngle.Ycoordinate();
		repaint();
		if(oilAngle<=-120) {
			return false;
		}else return true;
			
    }
    public void reset() {
    	BatteryColorR=0;
		BatteryColorG=255;
		BatteryPower1 = 306;
		BatteryPower2 = 100;
		xGasRot = xGas;
		yGasRot = yGas;				
		oilAngle = 0;
		repaint();
    }
 /* public static void main(String[] args) {
		new DrawDashBoard();
		
	}*/
}
