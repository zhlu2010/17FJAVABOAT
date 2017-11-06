package Roboat;
import java.awt.*;
import javax.swing.*;

public class DrawDashBoard extends JFrame {
    private int[] xRoboat = {200,100,100,300,300};
    private int[] yRoboat = {30, 300,700,700,300};
    
    double rad = Math.PI / 180;
	private int xCompass=150, yCompass=150, rCompass=50;
	private int[] xredCompass={200,195,205};
    private int[] yredCompass={170,200,200};
	private int[] xwhiteCompass={200,195,205};
	private int[] ywhiteCompass={230,200,200};	
	
    private int[] xBattery = {195,195,185,185,215,215,205,205};
    private int[] yBattery = {300,305,305,400,400,305,305,300};
    private int xPower = 186;
    public static int yPower = 305;
    private int xPowerw = 29;
    public static int yPowerh = 95;
    private int[] xGas = {200,200,195,200,205};
    private int[] yGas = {560,500,505,500,505};
    
    public static int[] xPropellor1={130,130,125,130,125,130,135,130,135,130,130};
	public static int[] yPropellor1={700,750,745,750,755,750,755,750,745,750,700};
	public static int[] xPropellor2={270,270,265,270,265,270,275,270,275,270,270};
	public static int[] yPropellor2={700,750,745,750,755,750,755,750,745,750,700};
	
    public static double xRudder1=200;
	public static double yRudder1=700;
	public static double xRudder2=200;
	public static double yRudder2=760;
	public static double XX;
	public static double YY;
	
	public static JLabel lblRudder;
    public DrawDashBoard() {
    	super("Dash Board");
    	setLayout(null);
    	setBounds(0, 0, 400, 800);
    	Container c=getContentPane();
    	lblRudder = new JLabel("Rudder: "+0.0);
    	lblRudder.setBounds(160,660,150,30);
    	dashPanel dashPanel=new dashPanel();
    	dashPanel.setBounds(-10,-20,400,800);
        c.add(lblRudder); c.add(dashPanel);

        //PowerClock.setPriority(PowerClock.getPriority()+3);
        PowerClock.start();
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
	Thread PowerClock=new Thread() { 
        public void run() {
        	while(true) {
        	    yPower+=1;
        	    yPowerh-=1;
        	    try {
        	    	Thread.sleep(1000);
        	    } catch (InterruptedException ex) {}
        	    repaint();
        	}
    	}
	};
    class dashPanel extends JPanel {
    	public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawPolygon(xRoboat, yRoboat, xRoboat.length);
            
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
            
            g.drawPolygon(xBattery, yBattery, xBattery.length);
            g.setColor(Color.green);
            g.fillRect(xPower, yPower, xPowerw, yPowerh);
            
            g.setColor(Color.black);
            g.drawString((yPowerh*100/94)+"%",190,410);
            DashBoard.lblBattery.setText("Power: "+(yPowerh*100/94)+"%");
            g.drawArc(150, 500, 100, 100, 30, 120);
            g.drawPolyline(xGas, yGas, xGas.length);
            
            g.drawPolyline(xPropellor1, yPropellor1, xPropellor1.length);
            g.drawPolyline(xPropellor2, yPropellor2, xPropellor2.length);
            g.drawLine((int)xRudder1, (int)yRudder1, (int)xRudder2, (int)yRudder2);
        
        } 
    }
}
