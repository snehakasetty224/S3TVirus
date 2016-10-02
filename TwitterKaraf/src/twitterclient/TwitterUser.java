package twitterclient;

import org.json.JSONException;
import org.json.JSONObject;

//Author: Tran.Pham
//Create date: Oct 1st, 2016
//Desc: hold user data
public class TwitterUser {

	private String name="";
	public TwitterUser() {
		// TODO Auto-generated constructor stub
	}
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: convert json string to twitter user object
	public static TwitterUser convertTwitterUser(JSONObject jsonObj) throws JSONException{
		TwitterUser usr=new TwitterUser();
		usr.name=jsonObj.getString("name");
		return usr;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

}
