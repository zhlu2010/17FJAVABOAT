package robortboat;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



    	
    	/*public Dashboard p1sp(double p1sp) {
    		return new Dashboard(p1sp,this.p2speed,this.rudderang);
    	}
    	
    	public Dashboard p2sp(double p2sp) {
    		return new Dashboard(this.p1speed,p2sp,this.rudderang);
    	}
    	public Dashboard rdang(double rdang) {
    		return new Dashboard(this.p1speed,this.p2speed,rdang);
    	}
    	public Dashboard change(double p1sp,double p2sp,double rdang) {
    		return new Dashboard(p1sp,p2sp,rdang);
    	}*/
    
 
public class ControlPanel extends JFrame {
	private JLabel ld1;
	private JLabel ld2;
	private JLabel ld3;
	public ControlPanel(String title) {
        super(title);       
        Container c = getContentPane();
        setLayout(null);
        //c.setBackground(Color.lightGray);
        setSize(500,600);
      
     
       
       JPanel cw = new JPanel();
       cw.setBounds(0, 100, 500, 500);
       cw.setLayout(null);
       JLabel lw = new JLabel("Welcome to the robortcontrol boat!");
		lw.setBounds(130, 120, 200, 100);
		cw.add(lw);
       
       JPanel ca = new JPanel();
       ca.setBounds(0, 100, 500, 500);
       ca.setLayout(null);
       JLabel la = new JLabel("not finished!!!");
		la.setBounds(200, 120, 200, 100);
		ca.add(la);
      
	  Dashboard db1 = new Dashboard(0,0,0);
      JPanel cm = new JPanel();
      cm.setBounds(0, 100, 500, 500);
      cm.setLayout(null);
      JLabel l1 = new JLabel("propellor 1");
      l1.setBounds(30,80, 70, 30);
      cm.add(l1);
      JTextArea t1 = new JTextArea("0");
      t1.setBounds(100, 80, 50, 30);
      cm.add(t1);
      JButton b1 = new JButton("ok");
      b1.setBounds(160, 80, 50, 30);
      cm.add(b1);
     
   
    
      JButton b2 = new JButton("ok");
      b2.setBounds(390, 80, 50, 30);
      cm.add(b2);
      JLabel l2 = new JLabel("propellor 2");
      l2.setBounds(260,80, 70, 30);
      cm.add(l2);
      JTextArea t2 = new JTextArea("0");
      t2.setBounds(330,80, 50, 30);
      cm.add(t2); 
      
      
    
     JButton b3 = new JButton("ok");
      b3.setBounds(160, 130, 50, 30);
      cm.add(b3);
      JLabel l3 = new JLabel("rudder");
      l3.setBounds(30,130, 70, 30);
      cm.add(l3);
      JTextArea t3 = new JTextArea("0");
      t3.setBounds(100,130, 50, 30);
      cm.add(t3);
     
    
      JButton b4 = new JButton("on/off");
      b4.setBounds(100, 180, 100, 30);
      cm.add(b4);
      JLabel l4 = new JLabel("camera:");
      l4.setBounds(30,180, 70, 30);
      cm.add(l4);
      
      b1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e3) {				
						double enterp1sp = 0;						
						enterp1sp = (new Double(t1.getText())).doubleValue(); 
						ld1.setText("Propellor1 speed:  "+enterp1sp+" RPM");
						
					}
	        }
	);
      b2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e4) {		
					    double enterp2sp = 0;					 
						enterp2sp = (new Double(t2.getText())).doubleValue();	
						ld2.setText("Propellor2 speed:  "+enterp2sp+" RPM");		
						
				}
	        }
	);
      b3.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e4) {				
						double enterrdang = 0;							
						enterrdang = (new Double(t3.getText())).doubleValue();				
						ld3.setText("Rudder angle:  "+enterrdang+" Degree");
				}
	        }
	);
        
      
      JPanel scroll= new JPanel();
      scroll.setBounds(0, 0, 500, 100);
      scroll.setLayout(null);
      
      
        JButton bc1 = new JButton("Automatic");
        bc1.setBounds(80,20, 130, 30);
        
        bc1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e1) {	
						cw.setVisible(false);
						ca.setVisible(true);					
						cm.setVisible(false);
						
				}
	        }
	);
       
        
        JButton bc2 = new JButton("Manual");
        bc2.setBounds(270,20, 130, 30);
        bc2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e2) {				
						cw.setVisible(false);
						cm.setVisible(true);
				 	    ca.setVisible(false);
				}
	        }
	);
        scroll.add(bc1);
        scroll.add(bc2);
        
        c.add(scroll);
        c.add(cw);
        c.add(ca);
        c.add(cm);
        
        setVisible(true);
        scroll.setVisible(true);
        cw.setVisible(true);
        ca.setVisible(false);
        cm.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	  
    public class Dashboard extends JFrame{
    
    	public Dashboard(double p1speed,double p2speed,double rudderang) {
    		super("Dashboard");
    		setLayout(null);
    		Container cd = getContentPane();
    		//cd.setBackground(Color.lightGray);
    		setLocation(900,100);
    		setSize(600,600);
    		
    	
    		ld1 = new JLabel("Propellor1 speed:  "+0.0+" RPM");
    		ld1.setBounds(30, 30, 200, 30);
    		cd.add(ld1);
    		
    		ld2 = new JLabel("Propellor2 speed:  "+0.0+" RPM");
    		ld2.setBounds(30, 80, 200, 30);
    		cd.add(ld2);
    		
    		ld3 = new JLabel("Rudder angle:  "+0.0+" Degree");
    		ld3.setBounds(30, 130, 200, 30);
    		cd.add(ld3);
    		
    		setVisible(true);
    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		}
    }
    
    public static void main(String[] args) {
    	
    	ControlPanel cp1= new ControlPanel("Control Panel");
    }
}

