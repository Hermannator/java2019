package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {
	private String username;
	private List<Tweet> tweets = new ArrayList<>();
	private List<TwitterAccount> following = new ArrayList<>();
//	private List<TwitterAccount> followers = new ArrayList<>();
	public TwitterAccount(String username) {
		this.username = username;
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
//			account.addFollower(this);
			
		}
	}
//	public void addFollower(TwitterAccount account) {
//		if(followers.contains(account)) {
//			throw new IllegalArgumentException("Cannot be followed twice.");
//		}else {
//			followers.add(account);
//		}
//	}
	public void unfollow(TwitterAccount account) {
		following.remove(account);
//		if(!this.isFollowing(account)) {
//			throw new IllegalArgumentException("Cannot unfollow what you don't follow.");
//		}else {
//			following.remove(account);
//			account.removeFollower(this);
//		}
	}
//	public void removeFollower(TwitterAccount account) {
//		if(!(followers.contains(account))) {
//			throw new IllegalArgumentException("Cannot remove that which isn't there.");
//		}else {
//			followers.remove(account);
//		}
//	}
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
}
