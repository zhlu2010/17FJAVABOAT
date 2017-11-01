package robortboat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


 
public class RudderControl extends JFrame {
	public double x1=300;
	public double y1=620;
	public double x2=300;
	public double y2=700;
	public double XX;
	public double YY;
	public static final double pi = 3.1415926;
         class MyPanel extends JPanel {
 
                   /**
                    *
                    */
                 //  private static final long serialVersionUID = 1L;
 
                   public void paint(Graphics graphics) {
                            super.paint(graphics);
                            Graphics g2d = (Graphics2D) graphics;
                            g2d.setColor(Color.black);
                            g2d.drawLine(300,50,200,190);
                            g2d.drawLine(200,190,200,620);
                            g2d.drawLine(200,620,400,620);
                            g2d.drawLine(400,620,400,190);
                            g2d.drawLine(400,190,300,50);
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
                   JTextArea t1 = new JTextArea("0");
                   p1.add(t1);
                   t1.setBounds(0,0,70,30);
                   JButton b1 = new JButton("get");
                   b1.setBounds(100,0,70,30);
                   p1.add(b1);
                   b1.addActionListener(
       					new ActionListener() {
       						public void actionPerformed(ActionEvent e) {				
       							double rdang = 0;						
       							rdang = (new Double(t1.getText())).doubleValue();
       							rdang = rdang * (pi/180);
       							x2 = 300;
       							y2 = 700;
       							double mycos = Math.cos(rdang);
       				            double mysin = Math.sin(rdang);
       				            XX = x2 - x1;
       				            YY = y2 - y1;
       				         x2=(double)(XX*mycos-YY*mysin);
       				         y2=(double)(XX*mysin+YY*mycos);
       						x2=x2+x1;
       						y2=y2+y1;
       						repaint();
       							
       						}
       		        }
       		);
                   
                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  setVisible(true);
         }
 
         public static void main(String[] args) {
                   RudderControl frame = new RudderControl();
               
         }
}