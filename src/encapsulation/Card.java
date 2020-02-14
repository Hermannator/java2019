package encapsulation;

public class Card {
	private char suit;
	private int face;
	public Card(char suit, int face) {
		if(!(suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C')) {
			throw new IllegalArgumentException("Invalid suit.");
		}else {
			this.suit = suit;
		}
		if(face < 1 || face > 13) {
			throw new IllegalArgumentException("Invalid face.");
		}else {
			this.face = face;
		}
	}
	public char getSuit() {
		return suit;
	}
	public int getFace() {
		return face;
	}
	public String toString() {
		return("" + this.getSuit() + this.getFace());
	}
}
