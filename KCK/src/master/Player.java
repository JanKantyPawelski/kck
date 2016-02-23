package master;

public class Player {
	public static int xn=4;
	public static int yn=9;
	public static void set(int x,int y){
		xn=x;
		yn=y;
	}
	private int x;
	private int y;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int x() {
		return this.x;
	}
	
	public int y() {
		return this.y;
	}
}
