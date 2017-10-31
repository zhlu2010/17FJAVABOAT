package robortboat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome extends JPanel {
	public Welcome() {
		setLayout(null);
	       JLabel lw = new JLabel("Welcome to the robortcontrol boat!");
			lw.setBounds(130, 120, 200, 100);
			add(lw);
	}

}
