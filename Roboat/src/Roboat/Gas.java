package Roboat;
import java.awt.*;
import javax.swing.*;

public class Gas extends JFrame {

	
	private int gasnum;
	
	public Gas(int g) {
		gasnum =g;
	}
	
	public int getGas() {
		return gasnum;
	}
	
	public void paint(Graphics e) {
		e.drawRect(100, 300, 390, getGas());
	}
	
	public void addGas(int num) {
		gasnum += num;
	}
	public static void main(String[] args) {
		Gas Gas1 = new Gas(5);
		System.out.println("lol");
		Gas1.paint(null);
		
	}
}
