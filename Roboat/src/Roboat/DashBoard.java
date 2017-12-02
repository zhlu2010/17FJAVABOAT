package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashBoard extends JFrame{
	String[] colName={"Speed","Propellor1","Propellor2","Battery","Fuel","Longitude","Latitude"};
	Object[][] data={
		{20,500,500,DrawDashBoard.BatteryPower2*100/100+"%",(DrawDashBoard.fuelAngle+120)*100/120+"%",ClickMap.getLongitude(),ClickMap.getLatitude()}

	};
	private JTable table;
	public DashBoard() {
		super("Roboat Information");
		setBounds(300,500,700,400);
		Container c=getContentPane();
		table=new JTable(data,colName);
		table.setRowHeight(50);
		JScrollPane sp=new JScrollPane(table);    
		c.add(sp);
		//pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void addData() {
		
		table.updateUI();
    }
	public static void main(String[] args) {
		new DashBoard();
	}
}
