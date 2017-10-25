package ProjectPractice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class TestPanel extends JFrame {
    public TestPanel() {
    	super("Control Panel");
    	setSize(800,800);
    	addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(TestPanel.this, "Exit Control Panel?");
			}
			public void windowActivated(WindowEvent e) {
				setLocationRelativeTo(null);
			}
		});
        JPanel panel = new JPanel();
        JButton b1=new JButton("Automatic"); panel.add(b1);
		JButton b2=new JButton("Manual"); panel.add(b2);
		b1.addActionListener(new B1());
		b2.addActionListener(new B2());
		
        JTextArea textArea = new JTextArea(15, 35);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        //pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    class B1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Automatic");
		}
	}
    class B2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Manual");
		}
	}
    public static void main(String[] args) {
        new TestPanel();
    }
}