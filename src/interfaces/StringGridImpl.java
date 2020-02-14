package interfaces;

import java.util.Iterator;

public class StringGridImpl implements StringGrid {
	private int rows, columns;
	private String[][] grid;
	public StringGridImpl(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		grid = new String[rows][columns];
	}
	public int getRowCount() {return rows;}
	public int getColumnCount() {return columns;}
	public String getElement(int row, int column) {return grid[row][column];}
	public void setElement(int row, int column, String element) {grid[row][column] = element;}
	public Iterator<String> iterator() {return new StringGridIterator(this, true);}
	public static void main(String[] args) {
		StringGrid sg = new StringGridImpl(2,2);
		sg.setElement(0,0,"1");
		sg.setElement(0,1,"2");
		sg.setElement(1,0,"3");
		sg.setElement(1,1,"4");
		for(String s : sg) {
			System.out.println(s);
		}
	}
}
