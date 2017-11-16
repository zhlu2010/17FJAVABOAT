package Roboat;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
//TODO: Add comments to every file show the author
import javax.swing.*;


/**
 * @author _____
 * Explain what this class does in one sentence
 * 
 * clickmap's constructor is built in this class
 */
public class Automatic extends JPanel {
	//	private DrawDashBoard dashboard;
	private JTextArea Longitude;
	private JTextArea Latitude;
	private boolean openmap = true;
	private static ClickMap clickmap;

	private void setCompassAngle() {
		//		dashboard.setCompassAngle(Math.atan2(ClickMap.DestinationY-ClickMap.CurrentY, ClickMap.DestinationX-ClickMap.CurrentX));
		//   							if (ClickMap.DestinationY-ClickMap.CurrentY > 0) {
   	//							 DrawDashBoard.compassAngle = DrawDashBoard.compassAngle +180;
   	//						}
	}


	public Automatic() { //TODO: Too much in one function.  Break up.
		setBounds(0, 0, 800, 400);
		setLayout(null);
		clickmap = new ClickMap();
		
		JLabel lblAuto = new JLabel("Auto Control"); //TODO: better layout??
		lblAuto.setBounds(100, 0, 200, 100);
		lblAuto.setForeground(Color.red);
		add(lblAuto);
		
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setBounds(50, 100, 80, 30);
		add(lblLongitude);
		Longitude = new JTextArea(""+400);
		Longitude.setEditable(false);
		Longitude.setBounds(130, 100, 165, 30);
		add(Longitude);
		
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(50, 150, 80, 30);
		add(lblLatitude);
		Latitude = new JTextArea(""+250);
		Latitude.setEditable(false);
		Latitude.setBounds(130, 150, 165, 30);
		add(Latitude);
		
		JButton map = new JButton("map");
		map.setBounds(400,90,60,40);
		add(map);
		map.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (openmap == false) {
							clickmap.setVisible(true);
							openmap = true;
						} else {
							clickmap.setVisible(false);
							openmap = false;
						}
					}
				}
			);
		
		JButton go = new JButton("go");
		go.setBounds(400,140,50,40);
		add(go);
		go.addActionListener(
					new ActionListener() {
   						public void actionPerformed(ActionEvent e) {
								/*
									dashboard.setPropeller1Speed(100);
									dashboard.setPropeller2Speed(100);
									setCompass();

								 */								
   							DrawDashBoard.Propellor1speed.setText("100.0"); // TODO: dashboard.setPropeller1Speed(100.0);
   							DrawDashBoard.Propellor2speed.setText("100.0"); // TODO: dashboard.setPropeller2Speed(100.0);
								// TODO: this code should be hidden in the dashboard.  This si a detail of drawing a compass.
   							DrawCompass.xredCompass = DrawCompass.xredCompassOrigin;
   							DrawCompass.yredCompass = DrawCompass.yredCompassOrigin;
   							DrawCompass.xwhiteCompass = DrawCompass.xwhiteCompassOrigin;
   							DrawCompass.ywhiteCompass = DrawCompass.ywhiteCompassOrigin;


								//TODO: setCompassAngle();
   								//TODO: keep all angles internally as radians.  Only convert when reading from user or displaying
   							DrawCompass.compassAngle = clickmap.getDirection();
   							Rotation redcompassAngle = new Rotation(200,200,DrawCompass.xredCompass,DrawCompass.yredCompass,DrawCompass.compassAngle);
   							DrawCompass.xredCompass=redcompassAngle.Xcoordinate();
   							DrawCompass.yredCompass=redcompassAngle.Ycoordinate();
							Rotation whitecompassAngle = new Rotation(200,200,DrawCompass.xwhiteCompass,DrawCompass.ywhiteCompass,DrawCompass.compassAngle);
							DrawCompass.xwhiteCompass=whitecompassAngle.Xcoordinate();
							DrawCompass.ywhiteCompass=whitecompassAngle.Ycoordinate();
							
							
							double directiontheta = (DrawCompass.compassAngle)*(Math.PI/180);					
   							Timer timer = new Timer();
   				        timer.schedule(new TimerTask() {
   				            public void run() {
   				                DrawDashBoard.BatteryPower1 +=1;
   				            	DrawDashBoard.BatteryPower2 -=1;
   				            	DrawDashBoard.oilAngle -= 5; 
   				            	Rotation RoilAngle = new Rotation(200,550,DrawDashBoard.xGas,DrawDashBoard.yGas,DrawDashBoard.oilAngle);
   								DrawDashBoard.xGasRot=RoilAngle.Xcoordinate();
   								DrawDashBoard.yGasRot=RoilAngle.Ycoordinate();   								
   								
   								clickmap.changeLocation(directiontheta);
   								Longitude.setText(""+clickmap.getLongitude());
   								Latitude.setText(""+clickmap.getLatitude());
   				            	Manual.rc1.repaint();
   				            	clickmap.repaint();
   				           if(clickmap.getdistance()<=0) {
   				        	   clickmap.arrived();
   				        	   clickmap.repaint();
   				        	   timer.cancel();   				        	  
   				           }
   				          if (DrawDashBoard.BatteryPower2>25&&DrawDashBoard.BatteryPower2<=60) {
   				        	DrawDashBoard.BatteryColorR = 255;
				             }
   				          else if (DrawDashBoard.BatteryPower2>0&&DrawDashBoard.BatteryPower2<=25) {
   				        	DrawDashBoard.BatteryColorR = 255;
   				        	DrawDashBoard.BatteryColorG = 0;
				            	 
				             }
				          else if(DrawDashBoard.BatteryPower2<=0) {
				        	  DrawDashBoard.BatteryPower2=0;
				        	  //ClickMap.CurrentX = ClickMap.DestinationX;
				        	  //ClickMap.CurrentY = ClickMap.DestinationY;				        	  
				        	  Manual.rc1.repaint();  
   				                	timer.cancel();
   				                }
   				            }
   				        },0,1000);	
   						}
   		        }
   		);
	}
	public static void mapRepaint() {
		clickmap.repaint();
	}
}
