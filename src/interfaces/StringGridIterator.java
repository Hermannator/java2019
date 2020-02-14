package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {
	private StringGrid grid;
	private boolean horizontal;
	private int rowIndex, columnIndex;
	public StringGridIterator(StringGrid grid, boolean horizontal) {
		this.grid = grid;
		this.horizontal = horizontal;
		rowIndex = -1;
		columnIndex = -1;
	}
	public boolean hasNext() {
		return rowIndex != grid.getRowCount() - 1 || columnIndex != grid.getColumnCount() - 1;
	}
	public String next() {
		if(!hasNext()) {
			return null;
		}else {
			if(horizontal) {
				if(columnIndex == grid.getColumnCount() - 1) {
					columnIndex = -1;
				}
				columnIndex++;
				if(columnIndex == 0) {
					rowIndex++;
				}
			}else {
				if(rowIndex == grid.getRowCount() - 1) {
					rowIndex = -1;
				}
				rowIndex++;
				if(rowIndex == 0) {
					columnIndex++;
				}
			}
			return grid.getElement(rowIndex, columnIndex);
		}
	}
	public void remove() {throw new UnsupportedOperationException("Removal unsupported.");}
}
