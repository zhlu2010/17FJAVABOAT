package robortboat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import test.data;

  
    class data extends JFrame{
    	public data(String dat) {
    		super("data");
    		setLayout(null);
    		Container cd = getContentPane();
    		cd.setBackground(Color.lightGray);
    		setLocation(900,400);
    		setSize(360,200);
    		int i = new Integer(dat).intValue();
    		
    		JLabel ld = new JLabel("The speed is "+i+" mph");
    		ld.setBounds(100, 70, 200, 30);
    		cd.add(ld);
    		
    		setVisible(true);
    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		
    	}
    }
    class Automatic extends JFrame {
    	public Automatic(String title) {
    		super(title);
    		setLayout(null);
    		Container ca = getContentPane();
    		ca.setBackground(Color.lightGray);
    		setLocation(700,50);
    		setSize(500,500);
    		
    		JLabel la = new JLabel("not finished!!!");
    		la.setBounds(200, 150, 200, 100);
    		ca.add(la);
    		

    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		
    	}
    }
    class Manual extends JFrame{
        public Manual(String title){
         super(title);
         setLayout(null);
    	 Container cm = getContentPane();
    	 cm.setBackground(Color.lightGray);
    	 setLocation(700,50);
         setSize(500,500);
       
       
         JLabel l1 = new JLabel("propellor 1");
         l1.setBounds(30,100, 70, 30);
         cm.add(l1);
         JTextArea t1 = new JTextArea(1,3);
         t1.setBounds(100, 100, 50, 30);
         cm.add(t1);
         JButton b1 = new JButton("ok");
         b1.setBounds(160, 100, 50, 30);
         cm.add(b1);
         b1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e3) {				
						data a1 = new data(t1.getText());
				}
	        }
	);
      
       
         JButton b2 = new JButton("ok");
         b2.setBounds(390, 100, 50, 30);
         cm.add(b2);
         JLabel l2 = new JLabel("propellor 2");
         l2.setBounds(260,100, 70, 30);
         cm.add(l2);
         JTextArea t2 = new JTextArea(50,30);
         t2.setBounds(330,100, 50, 30);
         cm.add(t2); 
         b2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e4) {				
						data a2 = new data(t2.getText());
				}
	        }
	);
       
        JButton b3 = new JButton("ok");
         b3.setBounds(160, 150, 50, 30);
         cm.add(b3);
         JLabel l3 = new JLabel("rudder");
         l3.setBounds(30,150, 70, 30);
         cm.add(l3);
         JTextArea t3 = new JTextArea(50,30);
         t3.setBounds(100,150, 50, 30);
         cm.add(t3);
       
         JButton b4 = new JButton("on/off");
         b4.setBounds(100, 200, 100, 30);
         cm.add(b4);
         JLabel l4 = new JLabel("camera:");
         l4.setBounds(30,200, 70, 30);
         cm.add(l4);
         
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
       }
        }
    
public class ControlPanel extends JFrame {
    public ControlPanel(String title) {
        super(title);       
        Container c = getContentPane();
        setLayout(null);
        c.setBackground(Color.lightGray);
        setSize(600,600);
        
        Automatic a1=new Automatic("Automatic");
        Manual a2 = new Manual("Manual");
      
        
        JButton bc1 = new JButton("Automatic");
        bc1.setBounds(50,220, 200, 50);
        c.add(bc1); 
        bc1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e1) {	
						a1.setVisible(true);
						a2.setVisible(false);
						
				}
	        }
	);
       
        
        JButton bc2 = new JButton("Manual");
        bc2.setBounds(330,220, 200, 50);
        c.add(bc2); 
        bc2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e2) {				
						a2.setVisible(true);
				 	    a1.setVisible(false);
				}
	        }
	);
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
    	
    	ControlPanel cp1= new ControlPanel("Control Panel");
    }
}
