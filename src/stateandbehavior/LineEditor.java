package stateandbehavior;

public class LineEditor {
	String text;
	int insertionIndex;
	public String getText() {
		return text;
	}
	public void setText(String s) {
		this.text = s;
		this.setInsertionIndex(s.length());
	}
	public int getInsertionIndex() {
		return insertionIndex;
	}
	public void setInsertionIndex(int i) {
		if(i > this.text.length()) {
			this.insertionIndex = this.text.length();
		}else if(i < 0) {
			this.insertionIndex = 0;
		}else {
			this.insertionIndex = i;
		}
	}
	public void left() {
		this.setInsertionIndex(insertionIndex-1);
	}
	public void right() {
		this.setInsertionIndex(insertionIndex+1);
	}
	public void insertString(String s) {
		this.text = this.text.substring(0,insertionIndex) + s + this.text.substring(insertionIndex);
		insertionIndex += s.length();
	}
	public void deleteLeft() {
		if(!(insertionIndex == 0)) {
			this.text = this.text.substring(0,insertionIndex-1) + this.text.substring(insertionIndex);
			this.left();
		}
	}
	public void deleteRight() {
		if(!(insertionIndex == this.text.length())) {
			this.text = this.text.substring(0,insertionIndex) + this.text.substring(insertionIndex+1);
		}
	}
	public String toString() {
		return(this.text.substring(0,insertionIndex) + "|" + this.text.substring(insertionIndex));
	}
	public static void main(String[] args) {
		LineEditor t = new LineEditor();
		t.setText("test");
		System.out.println(t);
		t.left();
		System.out.println(t);
		t.deleteLeft();
		System.out.println(t);
		t.insertString("ks");
		System.out.println(t);
		t.setInsertionIndex(10);
		System.out.println(t);
		t.right();
		System.out.println(t);
		t.deleteRight();
		System.out.println(t);
	}
}
