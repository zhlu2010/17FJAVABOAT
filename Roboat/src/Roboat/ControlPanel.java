package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JFrame{
	JPanel welcome = new JPanel();
	JPanel auto = new JPanel();
	JPanel manual = new JPanel();
	
    public ControlPanel() {
    	super("Control Panel");
    	setLayout(null);
    	setBounds(10, 550, 800, 400);
    	Container c=getContentPane();
    	addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int n=JOptionPane.showConfirmDialog(ControlPanel.this, "Exit Control Panel?","Alert",JOptionPane.OK_CANCEL_OPTION);
				
			}
		});
//Button
        JButton bAuto=new JButton("Automatic");
        bAuto.setBounds(300, 10, 100, 30);
		JButton bManual=new JButton("Manual");
		bManual.setBounds(450, 10, 100, 30);
		JButton bMap=new JButton("Map");
		bMap.setBounds(700, 10, 70, 30);
		
		c.add(bAuto);c.add(bManual);c.add(bMap);
		bAuto.addActionListener(new bAuto());
		bManual.addActionListener(new bManual());
		bMap.addActionListener(new bMap());
//Panel		
		welcome.setBounds(0, 0, 800, 400);
		welcome.setLayout(null);
		JLabel lblWelcome = new JLabel("Welcome To Roboat !");
		lblWelcome.setBounds(250, 50, 400, 200);
		lblWelcome.setFont(new java.awt.Font("Dialog",1,25));
		welcome.add(lblWelcome);
//Auto Control
		auto.setBounds(0, 0, 800, 400);
		auto.setLayout(null);
		JLabel lblauto = new JLabel("Auto Control");
		lblauto.setBounds(100, 0, 200, 100);
		lblauto.setForeground(Color.red);
		auto.add(lblauto);
		
		JTextField GPS;
		JLabel lblGPS = new JLabel("GPS");
		lblGPS.setBounds(50, 100, 80, 30);
		auto.add(lblGPS);
		GPS = new JTextField();
		GPS.setBounds(130, 100, 165, 30);
		auto.add(GPS);
		GPS.setColumns(10);
		
//Manual Control		
		manual.setBounds(0, 0, 800, 400);
		manual.setLayout(null);
		JLabel lblManual = new JLabel("Manual Control");
		lblManual.setBounds(100, 0, 200, 100);
		manual.add(lblManual);
		
		JTextField mGPS;
		JLabel lblmGPS = new JLabel("GPS");
		lblmGPS.setBounds(50, 100, 80, 30);
		manual.add(lblmGPS);
		mGPS = new JTextField();
		mGPS.setBounds(130, 100, 165, 30);
		manual.add(mGPS);
		mGPS.setColumns(10);
		
		c.add(welcome);c.add(auto);c.add(manual);
		welcome.setVisible(true);
		auto.setVisible(false);					
		manual.setVisible(false);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);      
    }
//ButtonListener
    class bAuto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			welcome.setVisible(false);
			auto.setVisible(true);					
			manual.setVisible(false);
		}
	}
    class bManual implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			welcome.setVisible(false);
			auto.setVisible(false);					
			manual.setVisible(true);
		}
	}
    class bMap implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
