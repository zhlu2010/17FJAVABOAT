package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Manual extends JPanel {
	public static JTextArea mtaSpeed;
	public static JTextArea mtaRudder;
	public static JTextArea mtaPropellor1;
	public static JTextArea mtaPropellor2;
	public static JSlider sliderRudder;
	//public static JSlider slideroil;	
	public static DrawDashBoard rc1;
	
	public Manual() {
		setLayout(null);
		setBounds(0, 0, 800, 400);
		JLabel lblManual = new JLabel("Manual Control");
		lblManual.setBounds(100, 0, 200, 100);
		lblManual.setForeground(Color.red);
		add(lblManual);

		JLabel mlblSpeed = new JLabel("Speed");
		mlblSpeed.setBounds(50, 100, 80, 30);
		add(mlblSpeed);
		mtaSpeed = new JTextArea("0");
		mtaSpeed.setBounds(130, 100, 165, 30);
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
	    rc1 = new DrawDashBoard();
	    
	    /*slideroil = new JSlider(JSlider.HORIZONTAL);
	    slideroil.setBounds(350,150,180,30);
	    slideroil.setMinimum(30);
	    slideroil.setMaximum(150);
		slideroil.setValue(90);
		add(slideroil);*/
		
	    sliderRudder.addChangeListener(new ChangeListener()  {
	    	public void stateChanged(ChangeEvent e) {
     			double rdang = 0;						
     			rdang = (new Double(sliderRudder.getValue())).doubleValue();
				rdang = (rdang-90)*(Math.PI/180);
				DrawDashBoard.xRudder2=200;
				DrawDashBoard.yRudder2=740;
				double mycos = Math.cos(rdang);
	            double mysin = Math.sin(rdang);
	            DrawDashBoard.XX = DrawDashBoard.xRudder2 - DrawDashBoard.xRudder1;
	            DrawDashBoard.YY = DrawDashBoard.yRudder2 - DrawDashBoard.yRudder1;
	            DrawDashBoard.xRudder2=(double)(-(DrawDashBoard.XX*mycos-DrawDashBoard.YY*mysin));
	            DrawDashBoard.yRudder2=(double)(DrawDashBoard.XX*mysin+DrawDashBoard.YY*mycos);
	            DrawDashBoard.xRudder2+=DrawDashBoard.xRudder1;
	            DrawDashBoard.yRudder2+=DrawDashBoard.yRudder1;
	            rc1.repaint();
	            DrawDashBoard.lblRudder.setText("Rudder: "+sliderRudder.getValue()+"бу");
	            lblforSlider.setText(""+sliderRudder.getValue()+"бу");		
	    	}
	    });
	    /*slideroil.addChangeListener(new ChangeListener()  {
	    	public void stateChanged(ChangeEvent e) {
     			double oilang = 0;						
     			oilang = (new Double(slideroil.getValue())).doubleValue();
				Rotation r1 = new Rotation(200,550,DrawDashBoard.xGas,DrawDashBoard.yGas,oilang);
				DrawDashBoard.xGasRot=r1.Xcoordinate();
				DrawDashBoard.yGasRot=r1.Ycoordinate();				
	            rc1.repaint();
	            
	           		
	    	}
	    });*/
	    
		JLabel mlblPropellor1 = new JLabel("Propellor 1");
		mlblPropellor1.setBounds(50, 200, 80, 30);
		add(mlblPropellor1);
		mtaPropellor1 = new JTextArea("0");
		mtaPropellor1.setBounds(130, 200, 165, 30);
		add(mtaPropellor1);
		JButton mbtnPropellor1=new JButton("ok");
		mbtnPropellor1.setBounds(300, 200, 70, 30);
		add(mbtnPropellor1);
		mbtnPropellor1.addActionListener(new mbtnPropellor1());
		
		JLabel mlblPropellor2 = new JLabel("Propellor 2");
		mlblPropellor2.setBounds(50, 250, 80, 30);
		add(mlblPropellor2);
		mtaPropellor2 = new JTextArea("0");
		mtaPropellor2.setBounds(130, 250, 165, 30);
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
			DrawDashBoard.Propellor1speed.setText(""+numPropellor1);
		}
	}
    class mbtnPropellor2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double numPropellor2 = 0;						
			numPropellor2 = (new Double(mtaPropellor2.getText())).doubleValue(); 
			DrawDashBoard.Propellor2speed.setText(""+numPropellor2);
		}
	}
}


