package twitterservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitterclient.TwitterFactory;

/**
 * Servlet implementation class TwitterKarafServlet
 * @author Sneha Kasetty Sudarshan
 */
@WebServlet("/TwitterKarafServlet")
public class TwitterKarafServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String TWITTER_CONSUMER_KEY = "nbt87Jdi8QAfBZcqKRmul6Tx8";
	private static final String TWITTER_SECRET_KEY = "AntAPekDj3bAeaYmEheXDohnA7Uyvmoa7LkDyF6v4a0v4XhMa3";
	private static final String TWITTER_ACCESS_TOKEN = "779387545645817856-fbTRHnvG44fJ0MsNkF8hOahviVgdcpg";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "CHQCY8u6wNMlB8KiOuvencRLmtCelY6FQws7xFYeFCrPe";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterKarafServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @author Sneha Kasetty Sudarshan
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TwitterFactory tFactory = new TwitterFactory(TWITTER_CONSUMER_KEY, TWITTER_SECRET_KEY
				, TWITTER_ACCESS_TOKEN, TWITTER_ACCESS_TOKEN_SECRET);
		
		request.setAttribute("count",tFactory.getHomeTimeline().getLstTweet().size());
		request.setAttribute("followers",tFactory.getFollowers().size());
		request.setAttribute("following",tFactory.getFriendIds().size());
		request.setAttribute("tweets",tFactory.getHomeTimeline().getLstTweetString());
		request.setAttribute("trends",tFactory.getTrends());
		request.setAttribute("timeline",tFactory.getUserTimeline().getLstTweetString());
		request.setAttribute("friendsNames",tFactory.getFriends());
		request.setAttribute("follwerNames",tFactory.getFollowerNames());
		request.setAttribute("reTweets", tFactory.getRetweetOfMe().getLstTweetString());
		request.getRequestDispatcher("twitterUi.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
