package inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer, Iterable<Card> {
	protected List<Card> cards = new ArrayList<>();
	private int maxCardCount;

	public CardContainerImpl(int maxCardCount) {
		this.maxCardCount = maxCardCount;
	}

	public int getCardCount() {
		return cards.size();
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	public int getMaxCardCount() {
		return maxCardCount;
	}

	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
}
