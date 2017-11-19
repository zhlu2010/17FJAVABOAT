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
 * clickmap's constructor is built in this class, as well as drawdashboard's, there are some functions to reset or repaint these two panel
 */
public class Automatic extends JPanel {
	//	private DrawDashBoard dashboard;
	private JTextArea Longitude;
	private JTextArea Latitude;
	private boolean openmap = true;
	private static ClickMap clickmap;
	private static DrawDashBoard drawdashboard;

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
		drawdashboard = new DrawDashBoard();
		
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
   							DrawDashBoard.setPropellor1Speed(100.0);
   							DrawDashBoard.setPropellor2Speed(100.0);
								// TODO: this code should be hidden in the dashboard.  This si a detail of drawing a compass.
   							drawdashboard.resetCompass();


								//TODO: setCompassAngle();
   								//TODO: keep all angles internally as radians.  Only convert when reading from user or displaying
   							drawdashboard.setCompassAngle(clickmap.getDirection());
							double directiontheta = (clickmap.getDirection())*(Math.PI/180);					
   							Timer timer = new Timer();
   				        timer.schedule(new TimerTask() {
   				            public void run() {   				             
   				                drawdashboard.batteryReduce();
   				            	drawdashboard.oilReduce();
   								clickmap.changeLocation(directiontheta);
   								setLocation(clickmap.getLongitude(),clickmap.getLatitude());
   				            	drawdashboard.repaint();
   				            	clickmap.repaint();
   				            	if(clickmap.getdistance()<=0) {
      				        	   clickmap.arrived();
      				        	   timer.cancel();   				        	  
      				           }
      				         if(drawdashboard.batteryReduce()&&drawdashboard.oilReduce()== false) {
   				        	    timer.cancel();
      				           }
   				          
   				            }
   				        },0,1000);	
   						}
   		        }
   		);
	}
	public void setLocation(double x, double y) {
		Longitude.setText(""+x);
		Latitude.setText(""+y);
	}
	public static void mapRepaint() {
		clickmap.repaint();
	}
	public static void DrawDashBoardRepaint() {
		drawdashboard.repaint();
	}
	public static void setRudder(double rdang) {
		drawdashboard.setRudderAngle(rdang);
	}
	public static void DrawDashBoardReset() {
		drawdashboard.reset();
	}
}
