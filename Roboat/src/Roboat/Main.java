package Roboat;
import java.io.*;

public class Main {
	public static ClickMap map;
	public static void main(String[] args) throws IOException{
		//new DrawDashBoard();
		new ControlPanel();
		//new Map();
		map = new ClickMap();
	}
}
