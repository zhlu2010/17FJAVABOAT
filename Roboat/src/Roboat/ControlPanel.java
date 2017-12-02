package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JFrame{
	private Welcome welcome;
	private Automatic auto;
	private Manual manual;
	
	
	public ControlPanel() {
    	super("Control Panel");
    	setLayout(null);
    	setBounds(300, 10, 400, 350);
    	Container c=getContentPane();
    	addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int Answer=JOptionPane.showConfirmDialog(ControlPanel.this, "Exit Control Panel?","Alert",JOptionPane.OK_CANCEL_OPTION);
				if (Answer == JOptionPane.OK_OPTION) {
	                System.exit(0);
	            }
				if (Answer == JOptionPane.CANCEL_OPTION) {
					new ControlPanel();
	            }
			}
		});
    	welcome = new Welcome();
    	auto = new Automatic();
    	manual = new Manual();
    	
    	
    	JButton btnAuto=new JButton("Automatic");
        btnAuto.setBounds(50, 10, 100, 30);
		JButton btnManual=new JButton("Manual");
		btnManual.setBounds(200, 10, 100, 30);
		JButton btnCharge=new JButton("Charge");
		btnCharge.setBounds(300, 60, 80, 30);

		//TODO: Java convention use lowercase letters for variables btnAuto (good), Welcome -> welcome
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome.setVisible(false);
				auto.setVisible(true);					
				manual.setVisible(false);
			}
		});
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome.setVisible(false);
				auto.setVisible(false);					
				manual.setVisible(true);
			}
		});
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Automatic.DrawDashBoardReset();		
				Automatic.DrawDashBoardRepaint();
	            Automatic.mapRepaint();
			}
		});
		
		c.add(btnAuto);c.add(btnManual);c.add(btnCharge);
		c.add(welcome);c.add(auto);c.add(manual);
		welcome.setVisible(true);
		auto.setVisible(false);					
		manual.setVisible(false);
        setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
