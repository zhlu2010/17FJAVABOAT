package robortboat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public  class Manual2 extends JFrame{
    public Manual2(String title){
        super(title);
   	 Container cm = getContentPane();
   	 setLayout(null); 
   	 cm.setBackground(Color.lightGray);
   	 setLocation(700,50);
        setSize(500,500);
      
        JButton b1 = new JButton("ok");
        b1.setBounds(160, 100, 50, 30);
        cm.add(b1);
        JLabel l1 = new JLabel("propellor 1");
        l1.setBounds(30,100, 70, 30);
        cm.add(l1);
        JTextArea t1 = new JTextArea(50,30);
        t1.setBounds(100, 100, 50, 30);
        cm.add(t1);
        b1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e3) {				
					System.out.println("faQ");
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
      
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
      }
       
    
  public static void main(String[] args) {
	  Manual2 a1=new Manual2("Manual");
	  a1.setVisible(true);
  }
}
