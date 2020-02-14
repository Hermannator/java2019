package stateandbehavior;

public class Rectangle {
	int minX,minY,maxX,maxY;
	public int getMinX() {
		return minX;
	}
	public int getMinY() {
		return minY;
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public int getWidth() {
		return maxX-minX;
	}
	public int getHeight() {
		return maxY-minY;
	}
	public boolean isEmpty() {
		if(this.getHeight() == 0 || this.getWidth() == 0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean contains(int x, int y) {
		if(this.isEmpty()) {
			return false;
		}
		if(x >= this.getMinX() && y >= this.getMinY() && x <= this.getMaxX() && y <= this.getMaxY()) {
			return true;
		}
		return false;
	}
	public boolean contains(Rectangle rect) {
		if(this.contains(rect.getMinX(),rect.getMinY()) && this.contains(rect.getMaxX(),rect.getMaxY())){
			return true;
		}else {
			return false;
		}
	}
	public boolean add(int x, int y) {
		if(this.contains(x,y)) {
			return false;
		}else {
			if(x < this.getMinX()){
				minX = x;
			}else if(x > this.getMaxX()) {
				maxX = x;
			}
			if(y < this.getMinY()) {
				minY = y;
			}else if(y > this.getMaxY()) {
				maxY = y;
			}
			return true;
		}
	}
	public boolean add(Rectangle rect) {
		if(rect.isEmpty()) {
			return false;
		}else {
			if(this.contains(rect)){
				return false;
			}else {
				this.add(rect.getMinX(),rect.getMinY());
				this.add(rect.getMaxX(),rect.getMaxY());
				return true;
			}
		}
	}
	public Rectangle union(Rectangle rect) {
		Rectangle unionRect = new Rectangle();
		unionRect.minX = Math.min(this.getMinX(), rect.getMinX());
		unionRect.minY = Math.min(this.getMinY(), rect.getMinY());
		unionRect.maxX = Math.max(this.getMaxX(), rect.getMaxX());
		unionRect.maxY = Math.max(this.getMaxY(), rect.getMaxY());
		return unionRect;
	}
	public boolean intersects(Rectangle rect) {
		if(this.getMaxX() <= rect.getMinX() || this.getMinX() >= rect.getMaxX() || this.getMaxY() <= rect.getMinY() || this.getMinY() >= rect.getMaxY()) {
			return false;
		}
		return true;
	}
	public Rectangle intersection(Rectangle rect) {
		if(this.intersects(rect)) {
			Rectangle intersectionRect = new Rectangle();
			intersectionRect.minX = Math.max(this.getMinX(), rect.getMinX());
			intersectionRect.minY = Math.max(this.getMinY(), rect.getMinY());
			intersectionRect.maxX = Math.min(this.getMaxX(), rect.getMaxX());
			intersectionRect.maxY = Math.min(this.getMaxY(), rect.getMaxY());
			return intersectionRect;
		}else {
			return new Rectangle();
		}
	}
	public String toString() {
		return("[(" + this.getMinX() + "," + this.getMinY() + "),(" + this.getMaxX() + "," + this.getMaxY() + ")], B: " + this.getWidth() + " H: " + this.getHeight());
	}
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle();
		System.out.println(rect1);
		System.out.println(rect2);
		System.out.println("\n");
		rect1.add(2,4);
		rect2.add(-1,-2);
		System.out.println(rect1);
		System.out.println(rect2);
		System.out.println("\n");
		rect1.add(rect2);
		rect2.add(-2,-4);
		System.out.println(rect1);
		System.out.println(rect2);
		System.out.println("\n");
		System.out.println(rect1.union(rect2));
		System.out.println("\n");
		System.out.println(rect1.intersection(rect2));
		System.out.println("\n");
	}
}
