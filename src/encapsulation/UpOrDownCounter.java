package encapsulation;

public class UpOrDownCounter {
	private int start, end, counter;
	public UpOrDownCounter(int start, int end) {
		if(start == end) {
			throw new IllegalArgumentException("Start and end value must differ.");
		}else {
			this.start = start;
			this.end = end;
			this.counter = start;
		}
	}
	public int getCounter() {
		return counter;
	}
	public boolean count() {
		if(counter == end) {
			return false;
		}else {
			if(start < end) {
				counter++;
			}else {
				counter--;
			}
			return true;
		}
	}
	public static void main(String[] args) {
		UpOrDownCounter c = new UpOrDownCounter(5,3);
		System.out.println(c.getCounter());
		System.out.println(c.count());
		System.out.println(c.getCounter());
		System.out.println(c.count());
		System.out.println(c.getCounter());
		System.out.println(c.count());
		System.out.println(c.getCounter());
	}
}