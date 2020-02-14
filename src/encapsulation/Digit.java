package encapsulation;

public class Digit {
	private int base,value;
	public Digit(int base) {
		if(base > 0) {
			this.base = base;
		}else {
			throw new IllegalArgumentException("Invalid base.");
		}
	}
	public int getValue() {
		return value;
	}
	public int getBase() {
		return base;
	}
	public boolean increment() {
		value++;
		if(value == base) {
			value = 0;
			return true;
		}else {
			return false;
		}
	}
	public String toString() {
		return((Integer.toString(this.getValue(),this.getBase())).toUpperCase());
	}
	public static void main(String[] args) {
		Digit d1 = new Digit(16);
		Digit d2 = new Digit(16);
		Digit d3 = new Digit(16);
		do {
			do {
				do {
					System.out.println(d1.toString() + d2.toString() + d3.toString());
				}while(!d3.increment());
			}while(!d2.increment());
		}while(!d1.increment());
		System.out.println(d1.toString() + d2.toString() + d3.toString());
	}
}
