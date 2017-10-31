package robortboat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Dashboard extends JFrame{
	public static JLabel ld1;
	public static JLabel ld2;
	public static JLabel ld3;
	public Dashboard() {
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


