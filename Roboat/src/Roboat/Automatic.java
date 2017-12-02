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
	private JTextArea Speed;
	private boolean openmap = true;
	private static ClickMap clickmap;
	private static DrawDashBoard drawdashboard;
	private DashBoard dashboard;
	
	public Automatic() { //TODO: Too much in one function.  Break up.
		setBounds(0, 0, 800, 400);
		setLayout(null);
		clickmap = new ClickMap();
		drawdashboard = new DrawDashBoard();
		dashboard=new DashBoard();
		
		JLabel lblAuto = new JLabel("Auto Control"); //TODO: better layout??
		lblAuto.setBounds(30, 30, 200, 100);
		lblAuto.setForeground(Color.red);
		add(lblAuto);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setBounds(50, 100, 80, 30);
		add(lblLongitude);
		Longitude = new JTextArea(""+-74.025192);
		Longitude.setEditable(false);
		Longitude.setBounds(130, 100, 100, 30);
		add(Longitude);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(50, 150, 80, 30);
		add(lblLatitude);
		Latitude = new JTextArea(""+40.741735);
		Latitude.setEditable(false);
		Latitude.setBounds(130, 150, 100, 30);
		add(Latitude);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(50, 200, 80, 30);
		add(lblSpeed);
		Speed = new JTextArea(""+20);
		Speed.setEditable(false);
		Speed.setBounds(130, 200, 100, 30);
		add(Speed);
		
		JButton map = new JButton("map");
		map.setBounds(300,100,60,30);
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
		go.setBounds(300,150,50,30);
		add(go);
		go.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//drawdashboard.resetCompass();
					clickmap.setDistance();
					//TODO: keep all angles internally as radians.  Only convert when reading from user or displaying
															
					Timer timer = new Timer();
				    timer.schedule(new TimerTask() {
				    	public void run() {   				    	
				        	boolean battery = drawdashboard.batteryReduce();
				            drawdashboard.fuelReduce();
							clickmap.changeLocation();
							drawdashboard.setCompassAngle(clickmap.getDirection());
							setLocation(clickmap.getLongitude(),clickmap.getLatitude());
				            drawdashboard.repaint();
				            clickmap.repaint();
				            dashboard.addData();
				            
				            if(clickmap.arrived()==false) {
  				        		//clickmap.arrived();
  				        		timer.cancel();   				        	  
  				            }
				    		if(battery== false) {
				        		timer.cancel();
				            }
				        }
				    },0,1000);
				    Timer timer2 = new Timer();
				    timer2.schedule(new TimerTask() {
				    	public void run() {   				    	
							drawdashboard.setPropellor1Speed(DrawDashBoard.getPropellor1Speed());
							drawdashboard.setPropellor2Speed(DrawDashBoard.getPropellor2Speed());
				            drawdashboard.repaint();
				            clickmap.repaint();
				            if(clickmap.arrived()==false) {
  				        		//clickmap.arrived();
				            	timer2.cancel();   				        	  
  				            }
				        }
				    },0,100);	
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