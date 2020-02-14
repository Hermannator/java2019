package interfaces;

import java.util.Comparator;

import interfaces.twitter.TwitterAccount;

public class UserNameComparator implements Comparator<TwitterAccount>{
	public int compare(TwitterAccount account1, TwitterAccount account2) {
		return account1.getUserName().compareTo(account2.getUserName());
	}
}
