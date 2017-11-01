package robortboat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public  class Manual extends JPanel{
	public static JTextArea t1;
	public static JTextArea t2;
	//public static JTextArea t3;
	public static JSlider rdslider;
	
	public Manual() {
	     // cm.setBounds(0, 100, 500, 500);
	      setLayout(null);
	      JLabel l1 = new JLabel("propellor 1");
	      l1.setBounds(30,80, 70, 30);
	      add(l1);
	      t1 = new JTextArea("0");
	      t1.setBounds(100, 80, 50, 30);
	      add(t1);
	      JButton b1 = new JButton("ok");
	      b1.setBounds(160, 80, 50, 30);
	      add(b1);
	     
	   
	    
	      JButton b2 = new JButton("ok");
	      b2.setBounds(390, 80, 50, 30);
	      add(b2);
	      JLabel l2 = new JLabel("propellor 2");
	      l2.setBounds(260,80, 70, 30);
	      add(l2);
	      t2 = new JTextArea("0");
	      t2.setBounds(330,80, 50, 30);
	      add(t2); 
	      
	      
	    
	     /*JButton b3 = new JButton("ok");
	      b3.setBounds(160, 130, 50, 30);
	      add(b3);	     
	      
	      t3 = new JTextArea("0");
	      t3.setBounds(100,130, 50, 30);
	      add(t3);*/
	      JLabel l3 = new JLabel("rudder");
	      l3.setBounds(30,130, 70, 30);
	      add(l3);
	      rdslider = new JSlider(JSlider.HORIZONTAL);
	      rdslider.setBounds(100,130,200,30);
	      rdslider.setMinimum(0);
	      rdslider.setMaximum(180);
	      rdslider.setValue(90); 
	      add(rdslider);
	      JLabel lbforSlider = new JLabel(""+90);
	      lbforSlider.setBounds(310,130,50,30);
	      add(lbforSlider);
	      RudderControl rc1 = new RudderControl();
	      
	     
	    
	      JButton b4 = new JButton("on/off");
	      b4.setBounds(100, 180, 100, 30);
	      add(b4);
	      JLabel l4 = new JLabel("camera:");
	      l4.setBounds(30,180, 70, 30);
	      add(l4);
	      
	      b1.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e3) {				
							double enterp1sp = 0;						
							enterp1sp = (new Double(t1.getText())).doubleValue(); 
							Dashboard.ld1.setText("Propellor1 speed:  "+enterp1sp+" RPM");
							
						}
		        }
		);
	      b2.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e4) {		
						    double enterp2sp = 0;					 
							enterp2sp = (new Double(t2.getText())).doubleValue();	
							Dashboard.ld2.setText("Propellor2 speed:  "+enterp2sp+" RPM");		
							
					}
		        }
		);
	      rdslider.addChangeListener(
            	  new ChangeListener()  {
       			public void stateChanged(ChangeEvent e) {
       				double rdang = 0;						
						rdang = (new Double(rdslider.getValue())).doubleValue();
						rdang = (rdang-90) * (RudderControl.pi/180);
						RudderControl.x2 = 300;
						RudderControl.y2 = 700;
						double mycos = Math.cos(rdang);
			            double mysin = Math.sin(rdang);
			            RudderControl.XX = RudderControl.x2 - RudderControl.x1;
			            RudderControl.YY = RudderControl.y2 - RudderControl.y1;
			            RudderControl.x2=(double)(-(RudderControl.XX*mycos-RudderControl.YY*mysin));
			            RudderControl.y2=(double)(RudderControl.XX*mysin+RudderControl.YY*mycos);
			            RudderControl.x2=RudderControl.x2+RudderControl.x1;
			            RudderControl.y2=RudderControl.y2+RudderControl.y1;
			            rc1.repaint();
       				    RudderControl.l1.setText("Rudder angle is "+rdslider.getValue()+" degree");
       				    lbforSlider.setText(""+rdslider.getValue());
       			}
       		}
            	  );
	/*      b3.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e4) {				
							double enterrdang = 0;							
							enterrdang = (new Double(t3.getText())).doubleValue();				
							Dashboard.ld3.setText("Rudder angle:  "+enterrdang+" Degree");
					}
		        }
		);*/
	}
}