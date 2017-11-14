package Roboat;
import java.awt.*;
import javax.swing.*;

public class Gas extends JFrame {

	//TODO: Make this double, store in Joules (use real physical units)
	//toDO: change name to fuel?
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

	public void usePower(double watts, double time) {
    //TODO: fuel -= watts * time;
	}
	//TODO: move this to a separate test class.  Make a test package, inside have a test class for each one. For example TestGas
	public static void main(String[] args) {
		Gas Gas1 = new Gas(5);
		System.out.println("lol");
		Gas1.paint(null);
		
	}
}
