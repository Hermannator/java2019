package patterns.observable;

public class ObservableHighscoreList extends ObservableList {
	private int maxSize;
	public ObservableHighscoreList(int maxSize) {
		this.maxSize = maxSize;
	}
	public boolean acceptsElement(Object object) {
		return object instanceof Integer;
	}
	public void addResult(int result) {
		for(int i = 0; i < size(); i++) {
			if(result < (int) getElement(i)) {
				if(size() + 1 > maxSize) {
					removeElement(size() - 1);
				}
				addElement(i, result);
				return;
			}
		}
		if(size() < maxSize) {
			addElement(result);
		}
	}
}
