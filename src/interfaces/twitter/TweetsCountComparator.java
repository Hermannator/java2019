package interfaces.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {
	public int compare(TwitterAccount a1, TwitterAccount a2) {
		return a2.getTweetCount() - a1.getTweetCount();
	}
}
