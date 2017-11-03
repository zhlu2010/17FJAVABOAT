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
    private int[] xPropellor1 = {135,135,115,155};
    private int[] yPropellor1 = {700,720,720,720};
    private int[] xPropellor2 = {265,265,245,285};
    private int[] yPropellor2 = {700,720,720,720};
    
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
        
        } 
    }
 /* public static void main(String[] args) {
		new DrawDashBoard();
		
	}*/
}
