package objectstructures;

public class Tweet {
	private TwitterAccount owner;
	private String text;
	private Tweet originalTweet;
	private int retweetCount;
	public Tweet(TwitterAccount owner, String text) {
		this.owner = owner;
		this.text = text;
		originalTweet = null;
	}
	public Tweet(TwitterAccount owner, Tweet tweet) {
		if(owner == tweet.getOwner()) {
			throw new IllegalArgumentException("Cannot retweet self.");
		}else {
			this.owner = owner;
			Tweet retweetTarget = tweet;
			while(retweetTarget.getOriginalTweet() != null) {
				retweetTarget = retweetTarget.getOriginalTweet();
			}
			this.originalTweet = retweetTarget;
			this.text = retweetTarget.getText();
			retweetTarget.incrementRetweetCount();
		}
	}
	public TwitterAccount getOwner() {
		return owner;
	}
	public String getText() {
		return text;
	}
	public Tweet getOriginalTweet() {
		return originalTweet;
	}
	public int getRetweetCount() {
		return retweetCount;
	}
	public void incrementRetweetCount() {
		retweetCount++;
	}
	
}
