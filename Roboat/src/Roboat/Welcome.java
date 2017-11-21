package Roboat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JPanel {
	public Welcome() {
		setBounds(0, 0, 550, 400);
		setLayout(null);
		JLabel lblWelcome = new JLabel("Welcome To Roboat !");
		lblWelcome.setBounds(50, 50, 400, 200);
		lblWelcome.setFont(new java.awt.Font("Dialog",1,25));
		add(lblWelcome);
	}
}
