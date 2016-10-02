package unittest;
import twitterclient.*;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class UnitTest {

	final static String SAMPLE_TWEET = "src/unittest/TestData/JsonTweetSample";
	final static String SAMPLE_TIMELINE = "src/unittest/TestData/JsonTimelineSample";
	final static String SAMPLE_TREND = "src/unittest/TestData/JsonTrendSample";
	final static String SAMPLE_USER = "src/unittest/TestData/JsonUserSample";
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: test converting function from Json string -> Tweet object
	//Test data file: src/unittest/TestData/JsonUserSample
	@Test
	public void ConvertTweet(){
		
		try
		{
			JSONObject tweetObj = readJsonObjectFromFile(SAMPLE_TWEET);
			Tweet.convertTweet(tweetObj);
			
		} catch(org.json.JSONException ex)
		{
			fail("fail to convert to tweet due to json error");			
		} catch (Exception e) {
			 
			fail("fail to convert to tweet");
		}
	}
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: test converting function from Json string -> Twitter Timeline
	//Test data file: src/unittest/TestData/JsonTimelineSample	
	@Test
	public void ConvertTimeline(){
		
		try
		{
			String json = readJsonStringFromFile(SAMPLE_TIMELINE);		
			TwitterTimeline.convertTimeline(json);
			
		} catch(org.json.JSONException ex)
		{
			fail("fail to convert to timeline due to json error");
		} catch(Exception ex)
		{
			fail("fail to convert to timeline");
		}		
	}
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: test converting function from Json string -> Trend object
	//Test data file: src/unittest/TestData/JsonTrendSample
	@Test
	public void ConvertTrend(){
		
		try
		{
			String json = readJsonStringFromFile(SAMPLE_TREND);
			JSONArray jsonArray=new JSONArray(json);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				TwitterTrend.convertTrend(jsonObject);
			}
			
		} catch(org.json.JSONException ex)
		{
			fail("fail to convert to trend due to json error");
		} catch(Exception ex)
		{
			fail("fail to convert to trend");
		}		
	}
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: test converting function from Json string -> Twitter User object(friend, follower)
	//Test data file: src/unittest/TestData/JsonUserSample
	@Test
	public void ConvertUser(){
		
		try
		{
			String json = readJsonStringFromFile(SAMPLE_USER);
			JSONArray jsonArray=new JSONArray(json);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				TwitterUser.convertTwitterUser(jsonObj);
			}
		} catch(org.json.JSONException ex)
		{
			fail("fail to convert to twitter user due to json error");
		} catch(Exception ex)
		{
			fail("fail to convert to twitter user");
		}		
	}
	
	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: utility function, read sample json object from sample file 
	public JSONObject readJsonObjectFromFile(String filepath){
		String jsonData = readJsonStringFromFile(filepath);
		
		JSONObject obj;
		try {
			obj = new JSONObject(jsonData);
			return obj;
		} catch (JSONException e) {		
			e.printStackTrace();
		}
		
		return null;
	}

	//Author: Tran.Pham
	//Create date: Oct 1st, 2016
	//Desc: utility function, read sample json data from sample file
	private String readJsonStringFromFile(String filepath) {
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return jsonData;
	}

}
