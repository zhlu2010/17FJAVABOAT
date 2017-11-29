package Roboat;

public class Rotation {
	private int[] XX;
	private int[] YY;
	private int[] Xcoordinate;
	private int[] Ycoordinate;
	public Rotation(int x1,int y1,int[] a, int[] b,double theta) {
		theta = (theta)*(Math.PI/180);
		double mycos = Math.cos(theta);
        double mysin = Math.sin(theta);
        XX = new int[a.length];
        YY = new int[a.length];
        Xcoordinate = new int[a.length];
        Ycoordinate = new int[a.length];
        for(int i = 0; i < a.length; i++) {
        XX[i]= a[i]-x1;
        YY[i]= b[i]-y1;
        Xcoordinate[i]=(int)(XX[i]*mycos-YY[i]*mysin);
        Ycoordinate[i]=(int)(XX[i]*mysin+YY[i]*mycos);
        Xcoordinate[i]+=x1;
        Ycoordinate[i]+=y1;
        }
	}
	public int[] Xcoordinate() {
		return Xcoordinate;
	}
	public int[] Ycoordinate() {
		return Ycoordinate;
	}
/*	public static void main(String[] args) {
		Rotation r1 = new Rotation (200,560,DrawDashBoard.xGas,DrawDashBoard.yGas,60);
		System.out.println(r1.Xcoordinate()[3]);
	}*/
}
