package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DashBoard extends JFrame{
	
	
	
	
	public DashBoard() {
		super("Dash Board");
		setLayout(null);
		Container c=getContentPane();
		setBounds(10, 50, 800, 500);
		
		JTextField GPS;
		JLabel lblGPS = new JLabel("GPS");
		lblGPS.setBounds(50, 100, 80, 30);
		c.add(lblGPS);
		GPS = new JTextField();
		GPS.setBounds(130, 100, 165, 30);
		c.add(GPS);
		GPS.setColumns(10);
		
		JTextField Speed;
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(50, 150, 80, 30);
		c.add(lblSpeed);
		Speed = new JTextField();
		Speed.setBounds(130, 150, 165, 30);
		c.add(Speed);
		Speed.setColumns(10);
		
		JTextField Propellor1;
		JLabel lblPropellor1 = new JLabel("Propellor 1");
		lblPropellor1.setBounds(50, 200, 80, 30);
		c.add(lblPropellor1);
		Propellor1 = new JTextField();
		Propellor1.setBounds(130, 200, 165, 30);
		c.add(Propellor1);
		Propellor1.setColumns(10);
		
		JTextField Propellor2;
		JLabel lblPropellor2 = new JLabel("Propellor 2");
		lblPropellor2.setBounds(50, 250, 80, 30);
		c.add(lblPropellor2);
		Propellor2 = new JTextField();
		Propellor2.setBounds(130, 250, 165, 30);
		c.add(Propellor2);
		Propellor2.setColumns(10);
		
		JTextField Accelaration;
		JLabel lblAccelaration = new JLabel("Accelaration");
		lblAccelaration.setBounds(450, 100, 80, 30);
		c.add(lblAccelaration);
		Accelaration = new JTextField();
		Accelaration.setBounds(530, 100, 165, 30);
		c.add(Accelaration);
		Accelaration.setColumns(10);

		JTextField Rotation;
		JLabel lblRotation = new JLabel("Rotation");
		lblRotation.setBounds(450, 150, 80, 30);
		c.add(lblRotation);
		Rotation = new JTextField();
		Rotation.setBounds(530, 150, 165, 30);
		c.add(Rotation);
		Rotation.setColumns(10);
		
		JTextField Battery;
		JLabel lblBattery = new JLabel("Battery");
		lblBattery.setBounds(450, 200, 80, 30);
		c.add(lblBattery);
		Battery = new JTextField();
		Battery.setBounds(530, 200, 165, 30);
		c.add(Battery);
		Battery.setColumns(10);
		
		JTextField Temperature;
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setBounds(450, 250, 80, 30);
		c.add(lblTemperature);
		Temperature = new JTextField();
		Temperature.setBounds(530, 250, 165, 30);
		c.add(Temperature);
		Temperature.setColumns(10);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}		
}
