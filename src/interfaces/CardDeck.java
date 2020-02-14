package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CardDeck implements CardContainer {
	private List<Card> cards = new ArrayList<>();
	private List<Character> suits = Arrays.asList('S','H','D','C');
	public CardDeck(int n) {
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j <= n; j++) {
				cards.add(new Card(suits.get(i),j));
			}
		}
	}
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
	public boolean hasCard(Predicate<Card> predicate) {
		for(Card card : cards) {
			if(predicate.test(card)) {
				return true; 
			}
		}
		return false;
	}
	public int getCardCount(Predicate<Card> predicate) {
		int count = 0;
		for(Card card : cards) {
			if(predicate.test(card)) {
				count++;
			}
		}
		return count;
	}
	public List<Card> getCards(Predicate<Card> predicate){
		List<Card> newCards = new ArrayList<>();
		for(Card card : cards) {
			if(predicate.test(card)) {
				newCards.add(card);
			}
		}
		return newCards;
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
	public static void main(String[] args) {
		CardDeck cd = new CardDeck(3);
		Iterator<Card> it = cd.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		Predicate<Card> predicate = x -> x.getSuit() == 'H';
		System.out.println("\n" + cd.hasCard(predicate));
		System.out.println(cd.getCardCount(predicate));
		List<Card> newCards = cd.getCards(predicate);
		for(Card card : newCards) {
			System.out.println(card);
		}
	}
}
