package interfaces;

import java.util.Arrays;
import java.util.Map;

public class Card implements Comparable<Card> {
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
	public int compareTo(Card card){
		Map<Character, Integer> suits = Map.of('S',3, 'H',2, 'D',1, 'C',0);
		if(suits.get(this.getSuit()) - suits.get(card.getSuit()) != 0) {
			return suits.get(this.getSuit()) - suits.get(card.getSuit());
		}
		return this.getFace() - card.getFace();
	}
	public static void main(String[] args) {
		Card[] cards = {new Card('D',13), new Card('S',5), new Card('C',10), new Card('H',7), new Card('S',6), new Card('C',11)};
		Arrays.sort(cards);
		for(Card c : cards) {
			System.out.println(c);
		}
	}
}
