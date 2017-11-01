package Roboat;

import java.awt.*;
import javax.swing.*;

class DrawDashBoard extends JFrame {
    private int[] xRoboat = {200,100,100,300,300,200};
    private int[] yRoboat = {30, 300,700,700,300,30 };
    private int[] xBattery = {195,195,185,185,215,215,205,205,195};
    private int[] yBattery = {300,305,305,400,400,305,305,300,300};
    private int[] xGas = {200,200,195,200,205};
    private int[] yGas = {560,500,505,500,505};
    
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
            g.setColor(Color.green);
            g.fillPolygon(xBattery, yBattery, xBattery.length);
            g.setColor(Color.black);
            g.drawArc(150, 500, 100, 100, 30, 120);
            g.drawPolyline(xGas, yGas, xGas.length);
            
            g.drawLine((int)xRudder1, (int)yRudder1, (int)xRudder2, (int)yRudder2);
        
        } 
    }
    public static void main(String[] args) {
		new DrawDashBoard();
		
	}
}
