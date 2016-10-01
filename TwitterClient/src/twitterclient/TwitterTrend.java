package twitterclient;
import org.json.JSONException;
import org.json.JSONObject;

//Author: Tran.Pham
//Create date: Oct 1st, 2016
//Desc: hold trend data
public class TwitterTrend {
	private String name;
	private String url;
	
	public TwitterTrend() {
		// TODO Auto-generated constructor stub
	}
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: convert json string to twitter trend object
	public static TwitterTrend convertTrend(JSONObject obj) throws JSONException
	{
		TwitterTrend res=new TwitterTrend();		
		res.setName(obj.getString("name"));
		res.setUrl(obj.getString("url"));
		
		return res;
	}


	String getName() {
		return name;
	}


	void setName(String name) {
		this.name = name;
	}


	String getUrl() {
		return url;
	}


	void setUrl(String url) {
		this.url = url;
	}

}
