package robortboat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public  class Manual extends JPanel{
	public static JSlider rdslider;
	
	public Manual() {
	     // cm.setBounds(0, 100, 500, 500);
	      setLayout(null);

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
	}
}