package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardHand implements CardContainer {
	private List<Card> cards = new ArrayList<>();
	public void addCard(Card card) {
		cards.add(card);
	}
	public int getCardCount() {
		return cards.size();
	}
	public Card getCard(int n) {
		return cards.get(n);
	}
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
	public Card play(int n) {
		Card card = cards.get(n);
		cards.remove(n);
		return card;
	}
}
