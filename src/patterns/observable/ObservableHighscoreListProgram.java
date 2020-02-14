package patterns.observable;

public class ObservableHighscoreListProgram implements ObservableListListener {
	ObservableHighscoreList list;
	public void init() {
		list = new ObservableHighscoreList(3);
		list.addObservableListListener(this);
	}
	public void run() {
		list.addResult(5);
		list.addResult(6);
		list.addResult(2);
		list.addResult(2);
		list.addResult(7);
	}
	public void listChanged(ObservableList list, int index) {
		System.out.println("Index: " + index);
		for(int i = 0; i < this.list.size(); i++) {
			System.out.println(this.list.getElement(i));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ObservableHighscoreListProgram program = new ObservableHighscoreListProgram();
		program.init();
		program.run();
	}
}
