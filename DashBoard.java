package ProjectPractice;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class DashBoard extends JFrame {
	
	private JPanel contentPane;
	private JTextField GPS;
	private JTextField Speed;
	private JTextField Propellor1;
	private JTextField Propellor2;
	private JTextField Accelaration;
	private JTextField Rotation;
	private JTextField Battery;
	private JTextField Temperature;

// Create the frame.
	public DashBoard() {
		super("Dash Board");
		setFont(new Font("Dialog", Font.BOLD, 20));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(DashBoard.this, "Exit Control Panel");
			}
			public void windowActivated(WindowEvent e) {
				setLocationRelativeTo(null);
			}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		//setSize(800,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bAuto = new JButton("Automatic");
		bAuto.setBounds(250, 20, 100, 30);
		bAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(DashBoard.this, "Automatic Control");
				GPS.setText(null);//empty text
				Speed.setText(null);
				Propellor1.setText(null);
				Propellor2.setText(null);
			}
		});
		contentPane.add(bAuto);
		JButton bManual = new JButton("Manual");
		bManual.setBounds(450, 20, 100, 30);
		bManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(DashBoard.this, "Manual Control");
				GPS.setText(null);//empty text
				Speed.setText(null);
				Propellor1.setText(null);
				Propellor2.setText(null);	
			}
		});
		contentPane.add(bManual);
		
		JLabel lblGPS = new JLabel("GPS");
		lblGPS.setBounds(50, 100, 80, 30);
		contentPane.add(lblGPS);
		GPS = new JTextField();
		GPS.setBounds(130, 100, 165, 30);
		contentPane.add(GPS);
		GPS.setColumns(10);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(50, 150, 80, 30);
		contentPane.add(lblSpeed);
		Speed = new JTextField();
		Speed.setBounds(130, 150, 165, 30);
		contentPane.add(Speed);
		Speed.setColumns(10);
		
		JLabel lblPropellor1 = new JLabel("Propellor 1");
		lblPropellor1.setBounds(50, 200, 80, 30);
		contentPane.add(lblPropellor1);
		Propellor1 = new JTextField();
		Propellor1.setBounds(130, 200, 165, 30);
		contentPane.add(Propellor1);
		Propellor1.setColumns(10);
		
		JLabel lblPropellor2 = new JLabel("Propellor 2");
		lblPropellor2.setBounds(50, 250, 80, 30);
		contentPane.add(lblPropellor2);
		Propellor2 = new JTextField();
		Propellor2.setBounds(130, 250, 165, 30);
		contentPane.add(Propellor2);
		Propellor2.setColumns(10);
		
		JLabel lblAccelaration = new JLabel("Accelaration");
		lblAccelaration.setBounds(450, 100, 80, 30);
		contentPane.add(lblAccelaration);
		Accelaration = new JTextField();
		Accelaration.setBounds(530, 100, 165, 30);
		contentPane.add(Accelaration);
		Accelaration.setColumns(10);

		JLabel lblRotation = new JLabel("Rotation");
		lblRotation.setBounds(450, 150, 80, 30);
		contentPane.add(lblRotation);
		Rotation = new JTextField();
		Rotation.setBounds(530, 150, 165, 30);
		contentPane.add(Rotation);
		Rotation.setColumns(10);
		
		JLabel lblBattery = new JLabel("Battery");
		lblBattery.setBounds(450, 200, 80, 30);
		contentPane.add(lblBattery);
		Battery = new JTextField();
		Battery.setBounds(530, 200, 165, 30);
		contentPane.add(Battery);
		Battery.setColumns(10);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setBounds(450, 250, 80, 30);
		contentPane.add(lblTemperature);
		Temperature = new JTextField();
		Temperature.setBounds(530, 250, 165, 30);
		contentPane.add(Temperature);
		Temperature.setColumns(10);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//Launch the application.
		public static void main(String[] args) {
			new DashBoard();
		}
}

