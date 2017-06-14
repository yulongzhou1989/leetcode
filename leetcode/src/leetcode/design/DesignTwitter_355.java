package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DesignTwitter_355 {

	public class Twitter {
		
		int timestamp;
		HashMap<Integer, User> users;
		
		class Tweet {
			public int tweetid;
			public int timestamp;
			Tweet next;
			
			public Tweet(){
				
			}
			
			public Tweet(int tweetid, int timestamp){
				this.tweetid = tweetid;
				this.timestamp = timestamp;
				next = null;
			}
		}
		
		class User{
			public int userid;
			public HashSet<Integer> follow;
			public LinkedHashMap<Integer, Tweet> tweets;
			
			public User(){
				
			}
			
			public User(int userid){
				this.userid = userid;
				follow = new HashSet<>();
				tweets = null;
			}
			
			public void follow(int followid){
				follow.add(followid);
			}
			
			public void unfollow(int unfollowid){
				follow.remove(unfollowid);
			}
		}
		

	    /** Initialize your data structure here. */
	    public Twitter() {
	        timestamp = 0;
			users = new HashMap<>();
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	        Tweet tw = new Tweet(tweetId, ++timestamp);
			if(!users.containsKey(userId)){
				User user = new Users(userId);
			}
			tw.next = users.tweets;
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
			List<Integer> res = new ArrayList<>();
	        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)-> new)
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
			if(users.containsKey(followerId) && users.containsKey(followeeId)){
				User follower = users.get(followerId);
				follower.follow(followeeId);
			}
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        if(users.containsKey(followerId) && users.containsKey(followeeId)){
				User follower = users.get(followerId);
				follower.unfollow(followeeId);
			}
	    }
	}

	/**
	 * Your Twitter object will be instantiated and called as such:
	 * Twitter obj = new Twitter();
	 * obj.postTweet(userId,tweetId);
	 * List<Integer> param_2 = obj.getNewsFeed(userId);
	 * obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
}
