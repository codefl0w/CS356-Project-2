import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.TimerTask;
import java.util.Timer;

import static javax.swing.BorderFactory.createTitledBorder;

public class UserViewUI extends JFrame {
	private User user;
	private Component root;
	
	private final DefaultListModel<String> followingModel = new DefaultListModel<>();
	private final DefaultListModel<String> newsfeedModel = new DefaultListModel<>();

	UserViewUI(User user, Component root) {
		this.user = user;
		this.root = root;
		
		// Initialize
		initComponents();
		setTitle("User View: " + user);
		
		followingList.setModel(followingModel);
		tweetList.setModel(newsfeedModel);
		
		// A3
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				java.awt.EventQueue.invokeLater(() -> {
					// 'following' list
					followingModel.removeAllElements();
					Set<String> followings = user.getFollowings();
					for (String following : followings)
						followingModel.addElement(following);
					
					// 'tweets' list
					newsfeedModel.removeAllElements();
					List<Tweet> tweets = user.getNewsFeed();
					for (Tweet tweet : tweets)
						newsfeedModel.addElement(tweet.toString());
					
					// Time A3
					creationTimeTxt.setText(user.getCreationTime());
					lastUpdateTxt.setText((user.getLastUpdateTime() == 0 ? "Not available" : user.getLastUpdateTimeString()));
				});
			}
		}, 0, 1000);
		UserPanel.setBorder(createTitledBorder("User: " + user.getId()));

	}
	
	// Copied as template //
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		// Main panel
		UserPanel = new javax.swing.JPanel();

		// Panel
		jPanelFollowing = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		followingList = new javax.swing.JList<>();
		
		// Panel
		jPanelFollowing1 = new javax.swing.JPanel();
		userIdToFollowText = new javax.swing.JTextField();
		btnFollow = new javax.swing.JButton();
		
		// Panel
		jPanelFollowing2 = new javax.swing.JPanel();
		btnPostTweet = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tweetMessageText = new javax.swing.JTextArea();
		
		// Panel
		jPanelFollowing3 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		tweetList = new javax.swing.JList<>();
		
		// Panel
		jPanelFollowing4 = new javax.swing.JPanel();
		creationTimeTxt = new javax.swing.JTextField();
		
		// Panel
		jPanelFollowing5 = new javax.swing.JPanel();
		lastUpdateTxt = new javax.swing.JTextField();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);

		UserPanel.setBorder(createTitledBorder("User:"));

		jPanelFollowing.setBorder(createTitledBorder("Following"));

		followingList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = {  };
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});
		jScrollPane2.setViewportView(followingList);

		javax.swing.GroupLayout jPanelFollowingLayout = new javax.swing.GroupLayout(jPanelFollowing);
		jPanelFollowing.setLayout(jPanelFollowingLayout);
		jPanelFollowingLayout.setHorizontalGroup(
			jPanelFollowingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowingLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(19, Short.MAX_VALUE))
		);
		jPanelFollowingLayout.setVerticalGroup(
			jPanelFollowingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFollowingLayout.createSequentialGroup()
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(33, 33, 33))
		);

		jPanelFollowing1.setBorder(createTitledBorder("Follow"));

		btnFollow.setText("Follow");
		btnFollow.addActionListener(evt -> btnFollowActionPerformed(evt));

		javax.swing.GroupLayout jPanelFollowing1Layout = new javax.swing.GroupLayout(jPanelFollowing1);
		jPanelFollowing1.setLayout(jPanelFollowing1Layout);
		jPanelFollowing1Layout.setHorizontalGroup(
			jPanelFollowing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowing1Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(userIdToFollowText, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnFollow)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanelFollowing1Layout.setVerticalGroup(
			jPanelFollowing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowing1Layout.createSequentialGroup()
				.addGroup(jPanelFollowing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(userIdToFollowText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnFollow))
				.addGap(0, 11, Short.MAX_VALUE))
		);

		jPanelFollowing2.setBorder(createTitledBorder("Tweet"));

		btnPostTweet.setText("Post Tweet");
		btnPostTweet.addActionListener(evt -> btnPostTweetActionPerformed(evt));

		tweetMessageText.setColumns(20);
		tweetMessageText.setRows(2);
		jScrollPane1.setViewportView(tweetMessageText);

		javax.swing.GroupLayout jPanelFollowing2Layout = new javax.swing.GroupLayout(jPanelFollowing2);
		jPanelFollowing2.setLayout(jPanelFollowing2Layout);
		jPanelFollowing2Layout.setHorizontalGroup(
			jPanelFollowing2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFollowing2Layout.createSequentialGroup()
				.addComponent(jScrollPane1)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnPostTweet)
				.addContainerGap())
		);
		jPanelFollowing2Layout.setVerticalGroup(
			jPanelFollowing2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowing2Layout.createSequentialGroup()
				.addComponent(btnPostTweet)
				.addGap(0, 46, Short.MAX_VALUE))
			.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
		);

		jPanelFollowing3.setBorder(createTitledBorder("News Feed"));

		tweetList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = {  };
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});
		jScrollPane3.setViewportView(tweetList);

		javax.swing.GroupLayout jPanelFollowing3Layout = new javax.swing.GroupLayout(jPanelFollowing3);
		jPanelFollowing3.setLayout(jPanelFollowing3Layout);
		jPanelFollowing3Layout.setHorizontalGroup(
			jPanelFollowing3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowing3Layout.createSequentialGroup()
				.addComponent(jScrollPane3)
				.addContainerGap())
		);
		jPanelFollowing3Layout.setVerticalGroup(
			jPanelFollowing3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowing3Layout.createSequentialGroup()
				.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(0, 0, Short.MAX_VALUE))
		);

		jPanelFollowing4.setBorder(createTitledBorder("Creation Time"));

		creationTimeTxt.setEditable(false);

		javax.swing.GroupLayout jPanelFollowing4Layout = new javax.swing.GroupLayout(jPanelFollowing4);
		jPanelFollowing4.setLayout(jPanelFollowing4Layout);
		jPanelFollowing4Layout.setHorizontalGroup(
			jPanelFollowing4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowing4Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(creationTimeTxt)
				.addContainerGap())
		);
		jPanelFollowing4Layout.setVerticalGroup(
			jPanelFollowing4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFollowing4Layout.createSequentialGroup()
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(creationTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
		);

		jPanelFollowing5.setBorder(createTitledBorder("Last Update Time"));

		lastUpdateTxt.setEditable(false);

		javax.swing.GroupLayout jPanelFollowing5Layout = new javax.swing.GroupLayout(jPanelFollowing5);
		jPanelFollowing5.setLayout(jPanelFollowing5Layout);
		jPanelFollowing5Layout.setHorizontalGroup(
			jPanelFollowing5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanelFollowing5Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(lastUpdateTxt)
				.addContainerGap())
		);
		jPanelFollowing5Layout.setVerticalGroup(
			jPanelFollowing5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFollowing5Layout.createSequentialGroup()
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lastUpdateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
		);

		javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
		UserPanel.setLayout(UserPanelLayout);
		UserPanelLayout.setHorizontalGroup(
			UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jPanelFollowing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jPanelFollowing1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jPanelFollowing3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jPanelFollowing2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jPanelFollowing4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jPanelFollowing5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		UserPanelLayout.setVerticalGroup(
			UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(UserPanelLayout.createSequentialGroup()
				.addComponent(jPanelFollowing1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanelFollowing, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanelFollowing2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanelFollowing3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanelFollowing4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanelFollowing5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(UserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(UserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents
	// .. //
	
	// Post a tweet action //
	private void btnPostTweetActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPostTweetActionPerformed
		// TODO add your handling code here:
		String tweet = tweetMessageText.getText();
		
		if (!tweet.equals("")) // if tweet null
			user.tweet(tweet);
		else
			tweetMessageText.setText("");
		
	}//GEN-LAST:event_btnPostTweetActionPerformed

	// Follow user action //
	private void btnFollowActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnFollowActionPerformed
		String userID = userIdToFollowText.getText();
		userIdToFollowText.setText("");
		
		if (!userID.trim().equals(""))
			if (root.contains(userID)) {
				User foundUser = root.getUserByID(userID);
				user.follow(foundUser);
			}

	}//GEN-LAST:event_btnFollowActionPerformed

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel UserPanel;
	private javax.swing.JButton btnFollow;
	private javax.swing.JButton btnPostTweet;
	private javax.swing.JTextField creationTimeTxt;
	private javax.swing.JList<String> followingList;
	private javax.swing.JPanel jPanelFollowing;
	private javax.swing.JPanel jPanelFollowing1;
	private javax.swing.JPanel jPanelFollowing2;
	private javax.swing.JPanel jPanelFollowing3;
	private javax.swing.JPanel jPanelFollowing4;
	private javax.swing.JPanel jPanelFollowing5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextField lastUpdateTxt;
	private javax.swing.JList<String> tweetList;
	private javax.swing.JTextArea tweetMessageText;
	private javax.swing.JTextField userIdToFollowText;
	// End of variables declaration//GEN-END:variables
}
