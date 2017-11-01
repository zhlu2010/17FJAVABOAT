package robortboat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RudderControl extends JFrame {
	public static double x1=300;
	public static double y1=620;
	public static double x2=300;
	public static double y2=700;
	public static double XX;
	public static double YY;
	public static final double pi = 3.1415926;
	public static JLabel l1;
         class MyPanel extends JPanel {
 
                   public void paint(Graphics graphics) {
                            super.paint(graphics);
                            Graphics g2d = (Graphics2D) graphics;
                            g2d.setColor(Color.black);
                            int xBoat[] = {300,200,200,400,400,300};
                            int yBoat[] = {50,190,620,620,190,50};
                            g2d.drawPolyline(xBoat, yBoat,6 );
                            g2d.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
                   }
         }
 
         public RudderControl() {
                  setLayout(null);
                  MyPanel p1 = new MyPanel();
        	 		this.add(p1);
        	 		p1.setBounds(0,0,600,800);
                   this.setSize(600, 1000);
                   p1.setLayout(null);
                   setLocation(1200,0);
                   
                   l1 = new JLabel("Rudder angle is 90 degree");
                   l1.setBounds(220,700,200,30);
                   p1.add(l1);
                  setVisible(true);
         }
}


