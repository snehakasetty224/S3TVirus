package twitterclient;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//Author: Tran.Pham
//Create date: Oct 1st, 2016
//Desc: hold tweettimeline data
public class TwitterTimeline {

	private List<Tweet> lstTweet;
	
	public TwitterTimeline() {
		// TODO Auto-generated constructor stub
		setLstTweet(new ArrayList<Tweet>()); 
	}
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: convert json string to twitter timeline object
	public static TwitterTimeline convertTimeline(String json) throws JSONException
	{
		TwitterTimeline timeline = new TwitterTimeline();
		
		List<Tweet> lstTweet = new ArrayList<Tweet>();
		
	   JSONArray jsonArray= new JSONArray(json); 
	   for (int i=0;i<jsonArray.length();i++)
		{
			JSONObject tweetObj=jsonArray.getJSONObject(i);
			Tweet timelineTweet = Tweet.convertTweet(tweetObj);
			if(timelineTweet!=null)
				lstTweet.add(timelineTweet);
		}		
	   timeline.setLstTweet(lstTweet);
	   return timeline;		
	}

	public List<Tweet> getLstTweet() {
		return lstTweet;
	}

	public void setLstTweet(List<Tweet> lstTweet) {
		this.lstTweet = lstTweet;
	}
	
	//Author: Sneha Kasetty Sudarshan
	// Converting List of Tweet to List of String 
	public List<String> getLstTweetString(){
		List<String> list = new ArrayList<String>();
		for(Tweet twt:lstTweet){
			list.add(twt.getText());
		}
		return list;
	}

}
