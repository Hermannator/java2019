package stateandbehavior;

public class Location {
	int x, y;
	public void up() {
		y--;
	}
	public void down() {
		y++;
	}
	public void right() {
		x++;
	}
	public void left() {
		x--;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return("X: " + this.getX() + "\nY: " + this.getY() + "\n");
	}
	public static void main(String[] args) {
		Location l = new Location();
		System.out.println(l);
		l.down();
		System.out.println(l);
		l.right();
		System.out.println(l);
		l.up();
		System.out.println(l);
		l.left();
		System.out.println(l);
	}
}
