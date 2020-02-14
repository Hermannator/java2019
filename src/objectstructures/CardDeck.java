package objectstructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {
	private List<Card> cards = new ArrayList<>();
	private List<Character> suits = Arrays.asList('S','H','D','C');
	public CardDeck(int n) {
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j <= n; j++) {
				cards.add(new Card(suits.get(i),j));
			}
		}
	}
	public int getCardCount() {
		return cards.size();
	}
	public Card getCard(int n) {
		return cards.get(n);
	}
	public void deal(CardHand hand,int n) {
		if(n >= cards.size()) {
			throw new IllegalArgumentException("Not enough cards.");
		}else {
			for(int i = 0; i < n; i++) {
				hand.addCard(cards.get(cards.size() - 1));
				cards.remove(cards.size() - 1);
			}
		}
	}
	public void shufflePerfectly() {
		List<Card> cards1 = new ArrayList<>();
		List<Card> cards2 = new ArrayList<>();
		for(int i = 0; i < cards.size()/2; i++) {
			cards1.add(cards.get(i));
			cards2.add(cards.get(cards.size()/2 + i));
		}
		cards.clear();
		for(int i = 0; i < cards1.size(); i++) {
			cards.add(cards1.get(i));
			cards.add(cards2.get(i));
		}
	}
}
