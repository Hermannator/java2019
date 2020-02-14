package interfaces;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardComparator implements Comparator<Card> {
	boolean aceHighest;
	char trump;
	public CardComparator(boolean aceHighest, char trump) {
		this.aceHighest = aceHighest;
		this.trump = trump;
	}
	public int compare(Card card1, Card card2) {
		Map<Character, Integer> suits = new HashMap<>();
		suits.put('S', 3);
		suits.put('H', 2);
		suits.put('D', 1);
		suits.put('C', 0);
		suits.put(trump, 4);
		if(suits.get(card1.getSuit()) - suits.get(card2.getSuit()) != 0) {
			return suits.get(card1.getSuit()) - suits.get(card2.getSuit());
		}
		if(aceHighest) {
			if(card1.getFace() == 1 && card2.getFace() == 1) {
				return 0;
			}else if(card1.getFace() == 1) {
				return 14 - card2.getFace();
			}else if(card2.getFace() == 1) {
				return card1.getFace() - 14;
			}
		}
		return card1.getFace() - card2.getFace();
	}
	public static void main(String[] args) {
		Card c1 = new Card('D',10);
		Card c2 = new Card('D',1);
		CardComparator cc = new CardComparator(true,'D');
		System.out.println(cc.compare(c1,c2));
	}
}
