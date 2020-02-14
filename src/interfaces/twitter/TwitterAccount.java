package interfaces.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {
	private String username;
	private List<Tweet> tweets;
	private List<TwitterAccount> following;
	private List<TwitterAccount> followers;
	public TwitterAccount(String username) {
		this.username = username;
		tweets = new ArrayList<>();
		following = new ArrayList<>();
		followers = new ArrayList<>();
	}
	public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator){
		List<TwitterAccount> sortedFollowers = followers;
		Collections.sort(sortedFollowers, comparator);
		return sortedFollowers;
	}
	public void tweet(String text) {
		tweets.add(new Tweet(this,text));
	}
	public void retweet(Tweet tweet) {
		tweets.add(new Tweet(this,tweet));
	}
	public void follow(TwitterAccount account) {
		if(this.isFollowing(account)) {
			throw new IllegalArgumentException("Already following this account.");
		}else {
			following.add(account);
			account.addFollower(this);
			
		}
	}
	public void addFollower(TwitterAccount account) {
		if(followers.contains(account)) {
			throw new IllegalArgumentException("Cannot be followed twice.");
		}else {
			followers.add(account);
		}
	}
	public void unfollow(TwitterAccount account) {
		following.remove(account);
		account.removeFollower(this);
	}
	public void removeFollower(TwitterAccount account) {
		followers.remove(account);
	}
	public boolean isFollowing(TwitterAccount account) {
		return following.contains(account);
	}
	public boolean isFollowedBy(TwitterAccount account) {
		return account.isFollowing(this);
	}
	public String getUserName() {
		return username;
	}
	public Tweet getTweet(int i) {
		if(i < 1) {
			throw new IllegalArgumentException("No tweets before first tweet.");
		}else {
			return tweets.get(tweets.size() - i);
		}
	}
	public int getTweetCount() {
		return tweets.size();
	}
	public int getRetweetCount() {
		int totalRetweetCount = 0;
		for(Tweet tweet : tweets) {
			totalRetweetCount += tweet.getRetweetCount();
		}
		return totalRetweetCount;
	}
	public int getFollowerCount() {
		return followers.size();
	}
}
