package patterns.observable;

public class HighscoreListProgram implements HighscoreListListener {
	HighscoreList list;
	public void listChanged(HighscoreList list, int index) {
		this.list = list;
		System.out.println("Index: " + index);
		for(int i = 0; i < this.list.size(); i++) {
			System.out.println(this.list.getElement(i));
		}
		System.out.println();
	}
	public void init() {
		list = new HighscoreList(3);
		list.addHighscoreListListener(this);
	}
	public void run() {
		list.addResult(5);
		list.addResult(6);
		list.addResult(2);
		list.addResult(3);
		list.addResult(7);
	}
	public static void main(String[] args) {
		HighscoreListProgram program = new HighscoreListProgram();
		program.init();
		program.run();
	}
}
