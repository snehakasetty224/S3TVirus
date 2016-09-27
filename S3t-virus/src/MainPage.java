import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainPage {

	private JFrame frame;
	private JTextField usernametextField;
	private JPasswordField passwordField;
	private JPanel LoginPage;
	private JPanel HomePage;
	private JPanel ProfilePage;
	private JTextField TweetsTextField;
	private JTextField FollowingTextfield;
	private JTextField FollowersTextField;
	private JTable TimeLineTabel;
	private JTextField TweetstextField;
	private JTextField ProfileTweetsDispplayTF;
	private JTextField ProfileFollowingTextField;
	private JTextField ProfilefollowersTextField;
	private JTable TweetsTable;
	private JTextField ProfileTweetsTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel LoginPage = new JPanel();
		frame.getContentPane().add(LoginPage, "name_31639761361096");
		LoginPage.setLayout(null);
		LoginPage.setVisible(true);

		JPanel HomePage = new JPanel();
		frame.getContentPane().add(HomePage, "name_31644204931236");
		HomePage.setLayout(null);
		HomePage.setVisible(false);
		
		JPanel ProfilePage = new JPanel();
		frame.getContentPane().add(ProfilePage, "name_31647361786264");
		ProfilePage.setLayout(null);
		ProfilePage.setVisible(false);
		
		JLabel usernamelabel = new JLabel("UserName");
		usernamelabel.setBounds(104, 123, 91, 16);
		LoginPage.add(usernamelabel);
		
		JLabel passwordlabel = new JLabel("Password");
		passwordlabel.setBounds(104, 151, 91, 16);
		LoginPage.add(passwordlabel);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(227, 118, 130, 26);
		LoginPage.add(usernametextField);
		usernametextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(226, 146, 131, 26);
		LoginPage.add(passwordField);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(true);
				LoginPage.setVisible(false);
			}
		});
		loginbutton.setBounds(172, 197, 117, 29);
		LoginPage.add(loginbutton);
		
		JLabel twitterbirdimage = new JLabel("");
		twitterbirdimage.setIcon(new ImageIcon(MainPage.class.getResource("/images/bird.png")));
		twitterbirdimage.setBounds(0, 0, 117, 108);
		LoginPage.add(twitterbirdimage);
		
		JLabel profileimage = new JLabel("");
		profileimage.setIcon(new ImageIcon(MainPage.class.getResource("/images/bird.png")));
		profileimage.setBounds(22, 30, 105, 113);
		HomePage.add(profileimage);
		
		JButton homepagehomebtn = new JButton("Home");
		homepagehomebtn.setBounds(0, 0, 91, 34);
		HomePage.add(homepagehomebtn);
		
		JButton homelogoutbtn = new JButton("Logout");
		homelogoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.setVisible(true);
				HomePage.setVisible(false);
			}
		});
		homelogoutbtn.setBounds(345, 0, 105, 34);
		HomePage.add(homelogoutbtn);
		
		JButton UserProfilebtn = new JButton("UserName");
		UserProfilebtn.setBorder(null);
		UserProfilebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfilePage.setVisible(true);
				HomePage.setVisible(false);
			}
		});
		UserProfilebtn.setBounds(10, 140, 117, 29);
		HomePage.add(UserProfilebtn);
		
		JLabel TweetsLabel = new JLabel("Tweets");
		TweetsLabel.setBounds(10, 169, 45, 16);
		HomePage.add(TweetsLabel);
		
		JLabel Followinglabel = new JLabel("Following");
		Followinglabel.setBounds(66, 169, 61, 16);
		HomePage.add(Followinglabel);
		
		JLabel Followerslabel = new JLabel("Followers");
		Followerslabel.setBounds(137, 169, 61, 16);
		HomePage.add(Followerslabel);
		
		TweetsTextField = new JTextField();
		TweetsTextField.setBounds(22, 190, 32, 26);
		HomePage.add(TweetsTextField);
		TweetsTextField.setColumns(10);
		
		FollowingTextfield = new JTextField();
		FollowingTextfield.setColumns(10);
		FollowingTextfield.setBounds(76, 190, 32, 26);
		HomePage.add(FollowingTextfield);
		
		FollowersTextField = new JTextField();
		FollowersTextField.setColumns(10);
		FollowersTextField.setBounds(137, 190, 32, 26);
		HomePage.add(FollowersTextField);
		
		JScrollPane TimeLineScrolling = new JScrollPane();
		TimeLineScrolling.setBounds(206, 114, 238, 158);
		HomePage.add(TimeLineScrolling);
		
		TimeLineTabel = new JTable();
		TimeLineScrolling.setViewportView(TimeLineTabel);
		
		JLabel Timelinelabel = new JLabel("Timeline");
		Timelinelabel.setBounds(208, 97, 61, 16);
		HomePage.add(Timelinelabel);
		
		TweetstextField = new JTextField();
		TweetstextField.setBounds(192, 46, 190, 39);
		HomePage.add(TweetstextField);
		TweetstextField.setColumns(10);
		
		JLabel Tweetslabel = new JLabel("");
		Tweetslabel.setIcon(new ImageIcon(MainPage.class.getResource("/images/Twt.png")));
		Tweetslabel.setBounds(381, 46, 48, 54);
		HomePage.add(Tweetslabel);

		JButton profilehomebtn = new JButton("Home");
		profilehomebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(true);
				ProfilePage.setVisible(false);
			}
		});
		profilehomebtn.setBounds(0, 0, 91, 34);
		ProfilePage.add(profilehomebtn);
		
		JButton profilelogoutbtn = new JButton("Logout");
		profilelogoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.setVisible(true);
				ProfilePage.setVisible(false);
			}
		});
		profilelogoutbtn.setBounds(345, 0, 105, 34);
		ProfilePage.add(profilelogoutbtn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPage.class.getResource("/images/bird.png")));
		label.setBounds(0, 32, 105, 113);
		ProfilePage.add(label);
		
		JLabel ProfileTL = new JLabel("Tweets");
		ProfileTL.setBounds(150, 105, 45, 16);
		ProfilePage.add(ProfileTL);
		
		JLabel ProfileFollowingL = new JLabel("Following");
		ProfileFollowingL.setBounds(207, 105, 61, 16);
		ProfilePage.add(ProfileFollowingL);
		
		JLabel ProfileFollowersL = new JLabel("Followers");
		ProfileFollowersL.setBounds(280, 105, 61, 16);
		ProfilePage.add(ProfileFollowersL);
		
		ProfileTweetsDispplayTF = new JTextField();
		ProfileTweetsDispplayTF.setColumns(10);
		ProfileTweetsDispplayTF.setBounds(160, 121, 32, 26);
		ProfilePage.add(ProfileTweetsDispplayTF);
		
		ProfileFollowingTextField = new JTextField();
		ProfileFollowingTextField.setColumns(10);
		ProfileFollowingTextField.setBounds(217, 121, 32, 26);
		ProfilePage.add(ProfileFollowingTextField);
		
		ProfilefollowersTextField = new JTextField();
		ProfilefollowersTextField.setColumns(10);
		ProfilefollowersTextField.setBounds(290, 119, 32, 26);
		ProfilePage.add(ProfilefollowersTextField);
		
		JScrollPane TweetsTimeline = new JScrollPane();
		TweetsTimeline.setBounds(150, 179, 281, 93);
		ProfilePage.add(TweetsTimeline);
		
		TweetsTable = new JTable();
		TweetsTimeline.setViewportView(TweetsTable);
		
		JLabel TweetsTimelineLabel = new JLabel("Tweets");
		TweetsTimelineLabel.setBounds(150, 159, 61, 16);
		ProfilePage.add(TweetsTimelineLabel);
		
		ProfileTweetsTextField = new JTextField();
		ProfileTweetsTextField.setColumns(10);
		ProfileTweetsTextField.setBounds(151, 54, 190, 39);
		ProfilePage.add(ProfileTweetsTextField);
		
		JLabel ProfileTweetslabel = new JLabel("");
		ProfileTweetslabel.setIcon(new ImageIcon(MainPage.class.getResource("/images/Twt.png")));
		ProfileTweetslabel.setBounds(345, 46, 48, 54);
		ProfilePage.add(ProfileTweetslabel);
		
		JButton ProfileUsername = new JButton("UserName");
		ProfileUsername.setBorder(null);
		ProfileUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ProfileUsername.setBounds(0, 154, 117, 29);
		ProfilePage.add(ProfileUsername);
	}
}
