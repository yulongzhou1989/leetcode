package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_google_359 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Logger {

	    Map<String, Integer> logMap;

	    /** Initialize your data structure here. */
	    public Logger() {
	        logMap = new HashMap<String, Integer>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        if (!logMap.containsKey(message)||(timestamp-logMap.get(message)>=10)){
	            logMap.put(message,timestamp);
	            return true;
	        }
	        return false;
	    }
	}

	/**
	 * Your Logger object will be instantiated and called as such:
	 * Logger obj = new Logger();
	 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
	 */
}


