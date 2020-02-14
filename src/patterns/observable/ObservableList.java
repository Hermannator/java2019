package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public abstract class ObservableList {
	protected Collection<ObservableListListener> listeners;
	protected List<Object> elements;
	public ObservableList() {
		listeners = new HashSet<>();
		elements = new ArrayList<>();
	}
	public int size() {return elements.size();}
	public Object getElement(int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return elements.get(index);
	}
	public void addObservableListListener(ObservableListListener listener) {listeners.add(listener);}
	public void removeObservableListListener(ObservableListListener listener) {listeners.remove(listener);}
	public abstract boolean acceptsElement(Object object);
	protected void addElement(int index, Object object) {
		if(!acceptsElement(object)) {
			throw new IllegalArgumentException("Invalid object type.");
		}
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		elements.add(index, object);
		for(ObservableListListener listener : listeners) {
			listener.listChanged(this, index);
		}
	}
	protected void addElement(Object object) {
		addElement(size(), object);
	}
	protected void removeElement(int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		elements.remove(index);
	}
}
