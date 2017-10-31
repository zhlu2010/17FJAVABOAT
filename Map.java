package Roboat;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Map extends JFrame{
	//public static int i=1;
	public Map() throws IOException{
		super("Map");
		setBounds(800,300,1000,550);
		MyMouseListener ml=new MyMouseListener();
		addMouseListener(ml);
		Container c=getContentPane();
		String picPath="C:"+File.separator+"1Stevens Stuff"+File.separator+"3EE552-Engineering Programming-Java"+File.separator+"earthmap.jpg";
		File sourceimage = new File(picPath);
		Image image = ImageIO.read(sourceimage);
		JLabel label = new JLabel(new ImageIcon(image));
		c.add(label);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	class MyMouseListener implements MouseListener {
		public void mouseEntered(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
		public void mouseExited(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
}
