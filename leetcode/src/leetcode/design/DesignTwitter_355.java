package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class DesignTwitter_355 {

	public class Twitter {
		
		int timestamp;
		HashMap<Integer, User> users;
		
		class Tweet {
			public int tweetid;
			public int time;
			public Tweet next;
			
			public Tweet(){
				
			}
			
			public Tweet(int tweetid, int time){
				this.tweetid = tweetid;
				this.time = time;
				next = null;
			}
		}
		
		class User{
			public int userid;
			public HashSet<Integer> follow;
			public Tweet tweets;
			
			public User(){
				
			}
			
			public User(int userid){
				this.userid = userid;
				follow = new HashSet<>();
				tweets = null;
			}
			
			public void follow(int followid){
			    if(followid == userid) return;
				follow.add(followid);
			}
			
			public void unfollow(int unfollowid){
				follow.remove(unfollowid);
			}
			
			public void post(Tweet tweet){
				tweet.next = tweets;
				tweets = tweet;
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
			    users.put(userId, new User(userId));	
			}
			User user = users.get(userId);
			user.post(tw);
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
			List<Integer> res = new ArrayList<>();
			if(!users.containsKey(userId)) return res;
			HashSet<Integer> followees = users.get(userId).follow;
			PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(followees.size()+1, (a,b)->(b.time-a.time));
			if(users.get(userId).tweets!=null){
				pq.offer(users.get(userId).tweets);
			}
			for(int uid:followees){
				User u = users.get(uid);
				if(u!=null && u.tweets!=null)
					pq.offer(u.tweets);
			}
			int n=0;
			while(!pq.isEmpty() && n<10){
				Tweet tw = pq.poll();
				res.add(tw.tweetid);
				n++;
				if(tw.next!=null)
				    pq.offer(tw.next);
			}
			
			return res;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	        if(!users.containsKey(followerId)){
	            users.put(followerId, new User(followerId));
	        }
	        if(!users.containsKey(followeeId)){
				users.put(followeeId, new User(followeeId));
			}
			User follower = users.get(followerId);
			follower.follow(followeeId);
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        if(!users.containsKey(followerId)){
	            users.put(followerId, new User(followerId));
	        }
	        if(!users.containsKey(followeeId)){
				users.put(followeeId, new User(followeeId));
			}
			
			User follower = users.get(followerId);
			if(follower.follow.contains(followeeId))
		        follower.unfollow(followeeId);
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
