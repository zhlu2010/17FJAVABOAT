package robortboat;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

 
public class ControlPanel extends JFrame {
	public ControlPanel() {
		super("Control Panel");       
		Container c = getContentPane();
		setLayout(null);
		setSize(500,600);
		
		Manual cm = new Manual();
	    Welcome cw = new Welcome();
	    Automatic ca = new Automatic();
	    	
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
        cw.setBounds(0, 100, 500, 500);
        c.add(ca);
        ca.setBounds(0, 100, 500, 500);
        c.add(cm);
        cm.setBounds(0, 100, 500, 500);
        
        setVisible(true);
        //scroll.setVisible(true);
        //cw.setVisible(true);
        ca.setVisible(false);
        cm.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}