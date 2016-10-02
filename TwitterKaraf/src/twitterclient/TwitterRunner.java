package twitterclient;

import java.util.List;

//Author: Tran.Pham
//Create date: Oct 1st, 2016
//Desc: test class, demonstrate all functionalities of TwitterFactory class
public class TwitterRunner {

	private static final String TWITTER_CONSUMER_KEY = "nbt87Jdi8QAfBZcqKRmul6Tx8";
	private static final String TWITTER_SECRET_KEY = "AntAPekDj3bAeaYmEheXDohnA7Uyvmoa7LkDyF6v4a0v4XhMa3";
	private static final String TWITTER_ACCESS_TOKEN = "779387545645817856-fbTRHnvG44fJ0MsNkF8hOahviVgdcpg";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "CHQCY8u6wNMlB8KiOuvencRLmtCelY6FQws7xFYeFCrPe";
	
	public TwitterRunner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwitterFactory tFactory = new TwitterFactory(TWITTER_CONSUMER_KEY, TWITTER_SECRET_KEY
													, TWITTER_ACCESS_TOKEN, TWITTER_ACCESS_TOKEN_SECRET);
		
		System.out.println("User timeline:");
		System.out.println("====================================================");
		TwitterTimeline timeline = tFactory.getUserTimeline();
		if(timeline!=null){
			for(Tweet t:timeline.getLstTweet()){
				System.out.println(t.getText());
			}
		}

		System.out.println("Home timeline:");
		System.out.println("====================================================");
		TwitterTimeline homeTimeline = tFactory.getHomeTimeline();
		if(homeTimeline!=null){
			for(Tweet t:homeTimeline.getLstTweet()){
				System.out.println(t.getText());
			}
		}

		System.out.println("Retweet of me:");
		System.out.println("====================================================");
		TwitterTimeline retweetTimeline = tFactory.getRetweetOfMe();
		if(retweetTimeline!=null){
			for(Tweet t:retweetTimeline.getLstTweet()){
				System.out.println(t.getText());
			}
		}

		System.out.println("Friend Ids:");
		System.out.println("====================================================");
		List<String> friendIds=tFactory.getFriendIds();
		if(friendIds.size()>0){
			for(String id:friendIds)
				System.out.print("["+id+"];");
			System.out.println();
		}

		System.out.println("Friend Names:");
		System.out.println("====================================================");		
		List<String> friends=tFactory.getFriends();
		if(friendIds.size()>0){
			for(String usr:friends)
				System.out.print("["+usr+"];");
			System.out.println();
		}

		System.out.println("Follower Ids:");
		System.out.println("====================================================");
		List<String> followerIds=tFactory.getFollowerIds();
		if(friendIds.size()>0){
			for(String id:followerIds)
				System.out.print("["+id+"];");
			System.out.println();
		}
		
		System.out.println("Follower Names:");
		System.out.println("====================================================");
		List<TwitterUser> followers=tFactory.getFollowers();
		if(friendIds.size()>0){
			for(TwitterUser usr:followers)
				System.out.print("["+usr.getName()+"];");
			System.out.println();
		}
		
		System.out.println("Trends:");
		System.out.println("====================================================");
		List<String> trends=tFactory.getTrends();
		if(trends.size()>0){
			for(String trend:trends){
				System.out.println(trend);
			}
		}
			
	}
}