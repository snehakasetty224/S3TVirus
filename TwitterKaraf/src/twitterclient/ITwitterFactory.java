package twitterclient;
import java.util.List;

public interface ITwitterFactory {
	
	public TwitterTimeline getUserTimeline();
	public TwitterTimeline getHomeTimeline();
	public TwitterTimeline getRetweetOfMe();
	public List<String> getFriendIds();	
	public List<String> getFriendNames();
	public List<String> getFriends();
	public List<String> getFollowerNames();
	public List<String> getFollowerIds();
	public List<TwitterUser> getFollowers();
	public List<String> getTrends();	
}
