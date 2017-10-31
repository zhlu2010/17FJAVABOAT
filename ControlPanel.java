package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JFrame{
	JPanel welcom = new JPanel();
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
		welcom.setBounds(0, 0, 800, 400);
		welcom.setLayout(null);
		JLabel lblwelcom = new JLabel("Welcome To Roboat !");
		lblwelcom.setBounds(300, 100, 200, 100);
		welcom.add(lblwelcom);
		
		auto.setBounds(0, 0, 800, 400);
		auto.setLayout(null);
		JLabel lblauto = new JLabel("Auto Control !!!");
		lblauto.setBounds(300, 100, 200, 100);
		auto.add(lblauto);
		
		manual.setBounds(0, 0, 800, 400);
		manual.setLayout(null);
		JLabel lblmanual = new JLabel("Manual Control !!!");
		lblmanual.setBounds(300, 100, 200, 100);
		manual.add(lblmanual);
		c.add(welcom);c.add(auto);c.add(manual);
		
		welcom.setVisible(true);
		auto.setVisible(false);					
		manual.setVisible(false);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);      
    }
//ButtonListener
    class bAuto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			welcom.setVisible(false);
			auto.setVisible(true);					
			manual.setVisible(false);
		}
	}
    class bManual implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			welcom.setVisible(false);
			auto.setVisible(false);					
			manual.setVisible(true);
		}
	}
    class bMap implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
