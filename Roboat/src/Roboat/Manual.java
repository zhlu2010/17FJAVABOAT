package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Manual extends JPanel {
	private JTextArea mtaSpeed;
	//private JTextArea mtaRudder;
	private JTextArea mtaPropellor1;
	private JTextArea mtaPropellor2;
	private JSlider sliderRudder;
	
	public Manual() {
		setLayout(null);
		setBounds(0, 0, 800, 400);
		JLabel lblManual = new JLabel("Manual Control");
		lblManual.setBounds(30, 30, 200, 100);
		lblManual.setForeground(Color.red);
		add(lblManual);

		JLabel mlblSpeed = new JLabel("Speed");
		mlblSpeed.setBounds(50, 100, 80, 30);
		add(mlblSpeed);
		mtaSpeed = new JTextArea("20");
		mtaSpeed.setBounds(130, 100, 80, 30);
		add(mtaSpeed);	
		JButton mbtnSpeed=new JButton("ok");
		mbtnSpeed.setBounds(300, 100, 70, 30);
		add(mbtnSpeed);
		mbtnSpeed.addActionListener(new mbtnSpeed());
		
		JLabel mlblRudder = new JLabel("Rudder");
		mlblRudder.setBounds(50, 150, 80, 30);
		add(mlblRudder);
		sliderRudder = new JSlider(JSlider.HORIZONTAL);
		sliderRudder.setBounds(120,150,180,30);
		sliderRudder.setMinimum(0);
		sliderRudder.setMaximum(180);
		sliderRudder.setValue(90);
		add(sliderRudder);
		JLabel lblforSlider = new JLabel(90+"бу");
		lblforSlider.setBounds(320,150,50,30);
	    add(lblforSlider);

		
	    sliderRudder.addChangeListener(new ChangeListener()  {
	    	public void stateChanged(ChangeEvent e) {
     			double rdang = 0;						
     			rdang = (new Double(sliderRudder.getValue())).doubleValue();
				Automatic.setRudder(rdang);
	            lblforSlider.setText(""+sliderRudder.getValue()+"бу");		
	    	}
	    });
	    
		JLabel mlblPropellor1 = new JLabel("Propellor 1");
		mlblPropellor1.setBounds(50, 200, 80, 30);
		add(mlblPropellor1);
		mtaPropellor1 = new JTextArea("500");
		mtaPropellor1.setBounds(130, 200, 80, 30);
		add(mtaPropellor1);
		JButton mbtnPropellor1=new JButton("ok");
		mbtnPropellor1.setBounds(300, 200, 70, 30);
		add(mbtnPropellor1);
		mbtnPropellor1.addActionListener(new mbtnPropellor1());
		
		JLabel mlblPropellor2 = new JLabel("Propellor 2");
		mlblPropellor2.setBounds(50, 250, 80, 30);
		add(mlblPropellor2);
		mtaPropellor2 = new JTextArea("500");
		mtaPropellor2.setBounds(130, 250, 80, 30);
		add(mtaPropellor2);
		JButton mbtnPropellor2=new JButton("ok");
		mbtnPropellor2.setBounds(300, 250, 70, 30);
		add(mbtnPropellor2);
		mbtnPropellor2.addActionListener(new mbtnPropellor2());
	}   

    class mbtnSpeed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double numSpeed = 0;						
			numSpeed = (new Double(mtaSpeed.getText())).doubleValue(); 
			//DrawDashBoard.Propellor1speed.setText("Speed: "+numSpeed);
		}
	}
    class mbtnPropellor1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double numPropellor1 = 0;						
			numPropellor1 = (new Double(mtaPropellor1.getText())).doubleValue(); 
			//drawdashboard.setPropellor1Speed(numPropellor1);
		}
	}
    class mbtnPropellor2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double numPropellor2 = 0;						
			numPropellor2 = (new Double(mtaPropellor2.getText())).doubleValue(); 
			//drawdashboard.setPropellor2Speed(numPropellor2);
		}
	}
}