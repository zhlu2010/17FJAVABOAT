package Roboat;
import java.awt.*;
import java.awt.event.*;
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
	}
}
