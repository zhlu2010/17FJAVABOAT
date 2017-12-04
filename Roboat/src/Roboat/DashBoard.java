package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DashBoard extends JFrame{
	private JTable table;
	private DefaultTableModel model;
	private JButton button_1,button_2;
	public DashBoard() {
		super("Roboat Information");
		setBounds(300,500,700,400);
		Container c=getContentPane();
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(1,2));
		button_1 = new JButton("Clear Data");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeData();
            }
        });
        button_2 = new JButton("Save Data");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        //button_1.setBounds(50, 10, 100, 30);
        //button_2.setBounds(150, 10, 100, 30);
        p.add(button_1);p.add(button_2);
        c.add(p, BorderLayout.NORTH);
		//table=new JTable(data,colName);
		model = new DefaultTableModel(); 
		table = new JTable(model); 
		table.setBounds(0,30,700,400);
		model.addColumn("Speed");
		model.addColumn("Propellor1");
		model.addColumn("Propellor2");
		model.addColumn("Battery");
		model.addColumn("Fuel");
		model.addColumn("Longitude");
		model.addColumn("Latitude");
		
		//model.addRow(new Object[]{20,500,500,DrawDashBoard.BatteryPower2*100/100+"%",(DrawDashBoard.fuelAngle+120)*100/120+"%",ClickMap.getLongitude(),ClickMap.getLatitude()});
		table.setRowHeight(50);
		JScrollPane sp=new JScrollPane(table);    
		c.add(sp);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void addData() {
		model.addRow(new Object[]{20,500,500,(int)DrawDashBoard.BatteryPower2*100/100+"%",(int)(DrawDashBoard.fuelAngle+120)*100/120+"%",ClickMap.getLongitude(),ClickMap.getLatitude()});
		table.updateUI();
    }
	private void removeData() {
        model.removeRow(1);
        table.updateUI();
    }
	private void saveData() {
        int col = model.getColumnCount();
        int row = model.getRowCount();
        for (int i = 0; i < col; i++) {
            System.out.print(model.getColumnName(i) + "\t");
        }
        System.out.print("\r\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(model.getValueAt(i, j) + "\t");
            }
            System.out.print("\r\n");
        }
        System.out.println("------------------------------------");
    }
	public static void main(String[] args) {
		new DashBoard();
	}
}
