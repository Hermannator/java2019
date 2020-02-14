package inheritance;

public class CardHand extends CardContainerImpl {
	public CardHand(int maxCardCount) {
		super(maxCardCount);
	}
	public void addCard(Card card) {
		if(getCardCount() == getMaxCardCount()) {
			throw new IllegalStateException("Card count cannot exceed max card count.");
		}
		cards.add(card);
	}
	public Card play(int n) {
		Card card = cards.get(n);
		cards.remove(n);
		return card;
	}
}
