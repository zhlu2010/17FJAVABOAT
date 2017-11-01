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
	public double x1=300;
	public double y1=620;
	public double x2=300;
	public double y2=700;
	public double XX;
	public double YY;
	public static final double pi = 3.1415926;
	public JSlider lrc;
         class MyPanel extends JPanel {
 
                   /**
                    *
                    */
                 //  private static final long serialVersionUID = 1L;
 
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
                   
                   JLabel l1 = new JLabel("Rudder angle is 90 degree");
                   l1.setBounds(20,80,200,30);
                   p1.add(l1);
                   
                   lrc = new JSlider(JSlider.HORIZONTAL);
                   lrc.setMinimum(0);
                   lrc.setMaximum(180);
                   lrc.setValue(90);                   
                  lrc.addChangeListener(
                	  new ChangeListener()  {
           			public void stateChanged(ChangeEvent e) {
           				double rdang = 0;						
							rdang = (new Double(lrc.getValue())).doubleValue();
							rdang = (rdang-90) * (pi/180);
							x2 = 300;
							y2 = 700;
							double mycos = Math.cos(rdang);
				            double mysin = Math.sin(rdang);
				            XX = x2 - x1;
				            YY = y2 - y1;
				         x2=(double)(-(XX*mycos-YY*mysin));
				         y2=(double)(XX*mysin+YY*mycos);
						x2=x2+x1;
						y2=y2+y1;
						repaint();
           				l1.setText("Rudder angle is "+lrc.getValue()+" degree");           				
           			}
           		}
            );
                   p1.add(lrc);
                   lrc.setBounds(0,50,200,30);
                   
                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  setVisible(true);
         }
 
         public static void main(String[] args) {
                   RudderControl frame = new RudderControl();
                   
               
         }
}