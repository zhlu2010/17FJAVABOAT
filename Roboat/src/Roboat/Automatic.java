package Roboat;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Automatic extends JPanel {
	public Automatic() {
		setBounds(0, 0, 800, 400);
		setLayout(null);
		JLabel lblAuto = new JLabel("Auto Control");
		lblAuto.setBounds(100, 0, 200, 100);
		lblAuto.setForeground(Color.red);
		add(lblAuto);
		
		JTextArea Longitude;
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setBounds(50, 100, 80, 30);
		add(lblLongitude);
		Longitude = new JTextArea();
		Longitude.setBounds(130, 100, 165, 30);
		add(Longitude);
		
		JTextArea Latitude;
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(50, 150, 80, 30);
		add(lblLatitude);
		Latitude = new JTextArea();
		Latitude.setBounds(130, 150, 165, 30);
		add(Latitude);
		
		JButton go = new JButton("go");
		go.setBounds(400,140,50,40);
		add(go);
		go.addActionListener(
					new ActionListener() {
   						public void actionPerformed(ActionEvent e) {				
   							DrawDashBoard.Propellor1speed.setText("100.0");
   							DrawDashBoard.Propellor2speed.setText("100.0");
   							
   							Timer timer = new Timer();
   				        timer.schedule(new TimerTask() {
   				            public void run() {
   				                DrawDashBoard.BatteryPower1 +=10;
   				            	DrawDashBoard.BatteryPower2 -=10;
   				            	Manual.oilAngle -= 12; 
   				            	Rotation r1 = new Rotation(200,550,DrawDashBoard.xGas,DrawDashBoard.yGas,Manual.oilAngle);
   								DrawDashBoard.xGasRot=r1.Xcoordinate();
   								DrawDashBoard.yGasRot=r1.Ycoordinate();	
   				            	Manual.rc1.repaint();
   				          if (DrawDashBoard.BatteryPower2>25&&DrawDashBoard.BatteryPower2<=60) {
   				        	DrawDashBoard.BatteryColorR = 255;
				             }
   				          else if (DrawDashBoard.BatteryPower2>0&&DrawDashBoard.BatteryPower2<=25) {
   				        	DrawDashBoard.BatteryColorR = 255;
   				        	DrawDashBoard.BatteryColorG = 0;
				            	 
				             }
				          else if(DrawDashBoard.BatteryPower2<=0) {
				        	  DrawDashBoard.BatteryPower2=0;
				        	  Manual.rc1.repaint();  
   				                	timer.cancel();
   				                }
   				            }
   				        },0,1000);
   						
   							
   						}
   		        }
   		);
	}
}
