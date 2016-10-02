package twitterclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

//Author: Tran.Pham
//Create date: Oct 1st, 2016
//Desc: Twitter API wrapper class, provide abstract layer and easy access to Twitter
public class TwitterFactory implements ITwitterFactory {

	String consumer_key;
	String consumer_secret;
	String application_key;
	String application_secret;
	OAuthConsumer oauth_consumer;
	
	private static final String TWITTER_USER_TIMELINE = "https://api.twitter.com/1.1/statuses/user_timeline.json";
	private static final String TWITTER_HOME_TIMELINE = "https://api.twitter.com/1.1/statuses/home_timeline.json";
	private static final String TWITTER_FRIEND_ID = "https://api.twitter.com/1.1/friends/ids.json";
	private static final String TWITTER_FRIEND = "https://api.twitter.com/1.1/friends/list.json";
	private static final String TWITTER_FOLLOWER_ID = "https://api.twitter.com/1.1/followers/ids.json";
	private static final String TWITTER_FOLLOWER = "https://api.twitter.com/1.1/followers/list.json";
	private static final String TWITTER_TREND_PLACE = "https://api.twitter.com/1.1/trends/available.json";
	private static final String TWITTER_RETWEET_OF_ME = "https://api.twitter.com/1.1/statuses/retweets_of_me.json";

	public TwitterFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public TwitterFactory(String consumer_key, String consumer_secret
						, String application_key, String application_secret) {
		
		oauth_consumer = new CommonsHttpOAuthConsumer(consumer_key, consumer_secret);
		oauth_consumer.setTokenWithSecret(application_key, application_secret);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get twitter timeline of default user
	public TwitterTimeline getUserTimeline() 
	{
		
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_USER_TIMELINE);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TwitterTimeline timeline = null;
		try {
			timeline = TwitterTimeline.convertTimeline(jsonData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
	   
		return timeline;
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get home timeline of default user
	
	public TwitterTimeline getHomeTimeline()
	{
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_HOME_TIMELINE);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TwitterTimeline timeline = null;
		try {
			timeline = TwitterTimeline.convertTimeline(jsonData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
	   
		return timeline;		
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get retweet timeline of default user
	
	public TwitterTimeline getRetweetOfMe() {
		// TODO Auto-generated method stub
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_RETWEET_OF_ME);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TwitterTimeline timeline = null;
		try {
			timeline = TwitterTimeline.convertTimeline(jsonData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
	   
		return timeline;	
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get list of friend id of default user
	public List<String> getFriendIds()
	{
		List<String> friends=new ArrayList<String>();
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_FRIEND_ID);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {

			JSONObject json3=new JSONObject(jsonData);				
			JSONArray Followersid= json3.getJSONArray("ids");
			for(int i=0;i<Followersid.length();i++){
				friends.add(Followersid.getString(i));
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
		
		return friends;
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get list of friend names of default user
	public List<String> getFriendNames()
	{
		List<String> friendNames=new ArrayList<String>();
		List<String> friends=getFriends();
		for(String user:friends)
			friendNames.add(user);
		return friendNames;	
	}
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get list of friends of default user
	
	public List<String> getFriends()
	{
		List<String> friends=new ArrayList<String>();
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_FRIEND);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {

			 JSONObject json4= new JSONObject(jsonData);
			 JSONArray friendslist= json4.getJSONArray("users");
			 for (int i=0;i<friendslist.length();i++){
					TwitterUser friend=TwitterUser.convertTwitterUser(friendslist.getJSONObject(i));
					friends.add(friend.getName());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
		
		return friends;	
	}

	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get list of followers name of default user
	public List<String> getFollowerNames()
	{
		List<String> followerNames=new ArrayList<String>();
		List<TwitterUser> followers=getFollowers();
		for(TwitterUser user:followers)
			followerNames.add(user.getName());

		return followerNames;	
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get list of followers id of default user
	public List<String> getFollowerIds()
	{
		List<String> followerIds=new ArrayList<String>();
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_FOLLOWER_ID);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {

			JSONObject json3=new JSONObject(jsonData);				
			JSONArray Followersid= json3.getJSONArray("ids");
			for(int i=0;i<Followersid.length();i++){
				followerIds.add(Followersid.getString(i));
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
		
		return followerIds;	
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get list of followers of default user
	public List<TwitterUser> getFollowers(){
		List<TwitterUser> followers=new ArrayList<TwitterUser>();
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_FOLLOWER);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {

			 JSONObject json4= new JSONObject(jsonData);
			 JSONArray friendslist= json4.getJSONArray("users");
			 for (int i=0;i<friendslist.length();i++){
					TwitterUser follower=TwitterUser.convertTwitterUser(friendslist.getJSONObject(i));
					followers.add(follower);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
		
		return followers;			
	}
	
	@Override
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: get list of places which is trend now
	public List<String> getTrends() {
		
		List<String> trends=new ArrayList<String>();
		String jsonData="";
		try {
			jsonData = executeMethod(oauth_consumer,TWITTER_TREND_PLACE);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 JSONArray jsonArray= new JSONArray(jsonData);			 
			 for (int i=0;i<jsonArray.length();i++){
				 TwitterTrend trend = TwitterTrend.convertTrend(jsonArray.getJSONObject(i));
				 trends.add(trend.getName()+" ("+ trend.getUrl()+")");				 
			 }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	
		
		return trends;			
	}

	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: execute the http call to url
	public String executeMethod(OAuthConsumer consumer, String url)
			throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException,
			IOException, ClientProtocolException, JSONException {
		HttpGet getRequest1 = new HttpGet(url);
		
	    getRequest1.addHeader("accept", "application/json");
	    consumer.sign(getRequest1);
	    DefaultHttpClient httpClient1 = new DefaultHttpClient();
	
	    HttpResponse response1 = httpClient1.execute(getRequest1);
	    if (response1.getStatusLine().getStatusCode() != 200) 
	     {
		throw new RuntimeException("Failed : HTTP error code : "+ response1.getStatusLine().getStatusCode());
	     }
	   BufferedReader br = new BufferedReader(new InputStreamReader((response1.getEntity().getContent())));
	
	   String jsonData="";
	   String line;
	   while ((line = br.readLine()) != null) 
			jsonData += line + "\n";
		
	   httpClient1.getConnectionManager().shutdown();
	   
	   return jsonData;
	}

}
