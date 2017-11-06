package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JFrame{    
	public ControlPanel() {
    	super("Control Panel");
    	setLayout(null);
    	setBounds(550, 10, 800, 400);
    	Container c=getContentPane();
    	addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showConfirmDialog(ControlPanel.this, "Exit Control Panel?","Alert",JOptionPane.OK_CANCEL_OPTION);
				
			}
		});
    	Welcome Welcome = new Welcome();
    	Automatic Auto = new Automatic();
    	Manual Manual = new Manual();
    	
    	JButton btnAuto=new JButton("Automatic");
        btnAuto.setBounds(300, 10, 100, 30);
		JButton btnManual=new JButton("Manual");
		btnManual.setBounds(450, 10, 100, 30);
		JButton btnCharge=new JButton("Charge");
		btnCharge.setBounds(670, 10, 100, 30);
		
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome.setVisible(false);
				Auto.setVisible(true);					
				Manual.setVisible(false);
			}
		});
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome.setVisible(false);
				Auto.setVisible(false);					
				Manual.setVisible(true);
			}
		});
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawDashBoard.xredCompass = DrawDashBoard.xredCompassOrigin;
				DrawDashBoard.yredCompass = DrawDashBoard.yredCompassOrigin;
				DrawDashBoard.xwhiteCompass = DrawDashBoard.xwhiteCompassOrigin;
				DrawDashBoard.ywhiteCompass = DrawDashBoard.ywhiteCompassOrigin;
				DrawDashBoard.xGasRot = DrawDashBoard.xGas;
				DrawDashBoard.yGasRot = DrawDashBoard.yGas;
				DrawDashBoard.BatteryColorR=0;
				DrawDashBoard.BatteryColorG=255;
				DrawDashBoard.oilAngle = 0;
				DrawDashBoard.compassAngle = 0;
				DrawDashBoard.Propellor1speed.setText("0");
				DrawDashBoard.Propellor2speed.setText("0");
				DrawDashBoard.BatteryPower1 = 306;
				DrawDashBoard.BatteryPower2 = 100;
				Manual.rc1.repaint();
	            Main.map.repaint();
			}
		});
		c.add(btnAuto);c.add(btnManual);c.add(btnCharge);
		c.add(Welcome);c.add(Auto);c.add(Manual);
		Welcome.setVisible(true);
		Auto.setVisible(false);					
		Manual.setVisible(false);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}



