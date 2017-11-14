package Roboat;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
//TODO: Add comments to every file show the author
import javax.swing.*;
/**
 * @author _____
 * Explain what this class does in one setence
 */
public class Automatic extends JPanel {
	//	private DrawDashBoard dashboard;
	public static JTextArea Longitude; //TODO: make variables private and non-static so we can support more than one boat
	public static JTextArea Latitude;
	public static boolean openmap = false;

	private void setCompassAngle() {
		//		dashboard.setCompassAngle(Math.atan2(ClickMap.DestinationY-ClickMap.CurrentY, ClickMap.DestinationX-ClickMap.CurrentX));
		//   							if (ClickMap.DestinationY-ClickMap.CurrentY > 0) {
   	//							 DrawDashBoard.compassAngle = DrawDashBoard.compassAngle +180;
   	//						}
	}


	public Automatic() { //TODO: Too much in one function.  Break up.
		setBounds(0, 0, 800, 400);
		setLayout(null);
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
							Main.map.setVisible(true);
							openmap = true;
						} else {
							Main.map.setVisible(false);
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
   							DrawDashBoard.xredCompass = DrawDashBoard.xredCompassOrigin;
   							DrawDashBoard.yredCompass = DrawDashBoard.yredCompassOrigin;
   							DrawDashBoard.xwhiteCompass = DrawDashBoard.xwhiteCompassOrigin;
   							DrawDashBoard.ywhiteCompass = DrawDashBoard.ywhiteCompassOrigin;


								//TODO: setCompassAngle();
   							DrawDashBoard.compassAngle = - Math.toDegrees(Math.atan((double)(ClickMap.DestinationX-ClickMap.CurrentX)/(double)(ClickMap.DestinationY-ClickMap.CurrentY)));
   							if (ClickMap.DestinationY-ClickMap.CurrentY > 0) {
   								 DrawDashBoard.compassAngle = DrawDashBoard.compassAngle +180;
   							}
   							Rotation redcompassAngle = new Rotation(200,200,DrawDashBoard.xredCompass,DrawDashBoard.yredCompass,DrawDashBoard.compassAngle);
   							DrawDashBoard.xredCompass=redcompassAngle.Xcoordinate();
							DrawDashBoard.yredCompass=redcompassAngle.Ycoordinate();
							Rotation whitecompassAngle = new Rotation(200,200,DrawDashBoard.xwhiteCompass,DrawDashBoard.ywhiteCompass,DrawDashBoard.compassAngle);
   							DrawDashBoard.xwhiteCompass=whitecompassAngle.Xcoordinate();
							DrawDashBoard.ywhiteCompass=whitecompassAngle.Ycoordinate();
							
							ClickMap.Xdistance = Math.abs(ClickMap.DestinationX-ClickMap.CurrentX);
							
							//TODO: keep all angles internally as radians.  Only convert when reading from user or displaying
							double directiontheta = (DrawDashBoard.compassAngle)*(Math.PI/180);					
   							Timer timer = new Timer();
   				        timer.schedule(new TimerTask() {
   				            public void run() {
   				                DrawDashBoard.BatteryPower1 +=10;
   				            	DrawDashBoard.BatteryPower2 -=10;
   				            	DrawDashBoard.oilAngle -= 12; 
   				            	Rotation RoilAngle = new Rotation(200,550,DrawDashBoard.xGas,DrawDashBoard.yGas,DrawDashBoard.oilAngle);
   								DrawDashBoard.xGasRot=RoilAngle.Xcoordinate();
   								DrawDashBoard.yGasRot=RoilAngle.Ycoordinate();   								
   								ClickMap.CurrentX += (int)ClickMap.boatspeed*Math.sin(directiontheta);   								
   								ClickMap.CurrentY -= (int)ClickMap.boatspeed*Math.cos(directiontheta);
   								ClickMap.Xdistance -= Math.abs((int)40*Math.sin(directiontheta));
   								Longitude.setText(""+ClickMap.CurrentX);
   								Latitude.setText(""+ClickMap.CurrentY);
   				            	Manual.rc1.repaint();
   				            	Main.map.repaint();
   				           if(ClickMap.Xdistance<=0) {
   				        	   ClickMap.CurrentX = ClickMap.DestinationX;
   				        	   ClickMap.CurrentY = ClickMap.DestinationY;
   				        	   Main.map.repaint();
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
}
