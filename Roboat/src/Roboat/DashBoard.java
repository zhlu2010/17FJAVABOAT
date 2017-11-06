package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashBoard extends JFrame{
	public static JLabel lblRudder;
	public static JLabel lblSpeed;
	public static JLabel lblPropellor1;
	public static JLabel lblPropellor2;
	
	public static JLabel lblBattery;
	public static JLabel lblTemperature;

	public DashBoard() {
		super("Dash Board");
		setLayout(null);
		Container c=getContentPane();
		setBounds(1200, 50, 700, 400);
		
		lblSpeed = new JLabel("Speed: "+0.0);
		lblSpeed.setBounds(50, 100, 200, 30);
		c.add(lblSpeed);
		
		lblRudder = new JLabel("Rudder: "+0.0+" degree");
		lblRudder.setBounds(50, 150, 200, 30);
		c.add(lblRudder);
		
		lblPropellor1 = new JLabel("Propellor 1: "+0.0);
		lblPropellor1.setBounds(50, 200, 200, 30);
		c.add(lblPropellor1);
		
		lblPropellor2 = new JLabel("Propellor 1: "+0.0);
		lblPropellor2.setBounds(50, 250, 200, 30);
		c.add(lblPropellor2);
		
		JLabel lblAccelaration = new JLabel("Accelaration");
		lblAccelaration.setBounds(400, 100, 200, 30);
		c.add(lblAccelaration);

		JLabel lblRotation = new JLabel("Rotation");
		lblRotation.setBounds(400, 150, 200, 30);
		c.add(lblRotation);
		
		lblBattery = new JLabel("Battery: "+100+"%");
		lblBattery.setBounds(400, 200, 200, 30);
		c.add(lblBattery);
		
		lblTemperature = new JLabel("Temperature");
		lblTemperature.setBounds(400, 250, 200, 30);
		c.add(lblTemperature);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}		
}
