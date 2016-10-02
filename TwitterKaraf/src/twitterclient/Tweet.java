package twitterclient;
import org.json.JSONException;
import org.json.JSONObject;

//Author: Tran.Pham
//Create date: Oct 1st, 2016
//Desc: hold tweet data
public class Tweet {

	private String text;
	private int like_count ;
	private int retweet_count;
	private String created_date;
	private String location;

	public Tweet() {

	}

	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: convert JSONObject to tweet object
	public static Tweet convertTweet(JSONObject tweetObj) throws JSONException {
		// TODO Auto-generated constructor stub
		Tweet res = new Tweet();

		res.setText(tweetObj.getString("text"));
		res.setRetweet_count(tweetObj.getInt("retweet_count"));
		res.setCreated_date(tweetObj.getString("created_at"));
		res.setLocation(tweetObj.getString("place"));
		
		return res;
			
	}

	public String getText() {
		return text;
	}

	protected void setText(String text) {
		this.text = text;
	}
	
	public int getLike_count() {
		return like_count;
	}

	protected void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	protected String getCreated_date() {
		return created_date;
	}

	protected void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	protected int getRetweet_count() {
		return retweet_count;
	}

	protected void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	protected String getLocation() {
		return location;
	}

	protected void setLocation(String location) {
		this.location = location;
	}
	

}
