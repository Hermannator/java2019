package patterns.observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HighscoreList {
	private Set<HighscoreListListener> listeners;
	private int maxSize;
	private List<Integer> results;
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
		results = new ArrayList<>();
		listeners = new HashSet<>();
	}
	public int getElement(int index) {
		if(index >= results.size()) {
			throw new ArrayIndexOutOfBoundsException("Invalid index.");
		}else {
			return results.get(index);
		}
	}
	public int size() {return results.size();}
	public void addHighscoreListListener(HighscoreListListener listener) {listeners.add(listener);}
	public void removeHighscoreListListener(HighscoreListListener listener) {listeners.remove(listener);}
	public void addResult(int result) {
		for(int i = 0; i < size(); i++) {
			if(result < getElement(i)) {
				addResultToIndex(i, result);
				return;
			}
		}
		addResultToIndex(size(), result);
	}
	public void addResultToIndex(int index, int result) {
		results.add(index, result);
		while(size() > maxSize) {
			results = results.subList(0, maxSize);
		}
		if(index > maxSize - 1) {
			index = -1;
		}
		for(HighscoreListListener listener : listeners) {
			listener.listChanged(this, index);
		}
	}
}
