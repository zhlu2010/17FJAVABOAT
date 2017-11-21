package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JFrame{
	public ControlPanel() {
    	super("Control Panel");
    	setLayout(null);
    	setBounds(300, 10, 400, 350);
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
        btnAuto.setBounds(50, 10, 100, 30);
		JButton btnManual=new JButton("Manual");
		btnManual.setBounds(200, 10, 100, 30);
		JButton btnCharge=new JButton("Charge");
		btnCharge.setBounds(300, 60, 80, 30);

		//TODO: Java convention use lowercase letters for variables btnAuto (good), Welcome -> welcome
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
				Automatic.DrawDashBoardReset();				
				DrawDashBoard.setPropellor1Speed(0);;
				DrawDashBoard.setPropellor2Speed(0);;				
				Automatic.DrawDashBoardRepaint();
	            Automatic.mapRepaint();
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
