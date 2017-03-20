package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EvaluateDivision_google_399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //two hash tables to save route and value
        Map<String, ArrayList<String>> routeMap = new HashMap<String, ArrayList<String>>();
        Map<String, ArrayList<Double>> valueMap = new HashMap<String, ArrayList<Double>>();
        //initial hashmaps
        for(int i=0;i<equations.length;i++){
            if (!routeMap.containsKey(equations[i][0])){
                routeMap.put(equations[i][0], new ArrayList<String>());
                valueMap.put(equations[i][0], new ArrayList<Double>());
            }
            if (!routeMap.containsKey(equations[i][1])){
                routeMap.put(equations[i][1], new ArrayList<String>());
                valueMap.put(equations[i][1], new ArrayList<Double>());
            }
            routeMap.get(equations[i][0]).add(equations[i][1]);
            routeMap.get(equations[i][1]).add(equations[i][0]);
            valueMap.get(equations[i][0]).add(values[i]);
            valueMap.get(equations[i][1]).add(1/values[i]);
        }
        
        double [] res = new double [queries.length];
        
        for(int i=0;i<queries.length;i++){
            res[i] = dfs(routeMap, valueMap, queries[i][0], queries[i][1], 1.0, new HashSet<String>());
            if (res[i]==0) res[i] = -1.0;
        }
        return res;
    }
    
	double dfs(Map<String, ArrayList<String>> routeMap, Map<String, ArrayList<Double>> valueMap, String start, String end, double value, HashSet<String> visitedSet){
        if (!routeMap.containsKey(start)) return 0.0;
        if (visitedSet.contains(start)) return 0.0;
        if (start.equals(end)) return value;
        visitedSet.add(start);
        double temp = 0.0;
        for (int i=0;i<routeMap.get(start).size();i++){
            temp = dfs(routeMap, valueMap, routeMap.get(start).get(i), end, value*valueMap.get(start).get(i), visitedSet);
            if (temp!=0.0)
                break;
        }
        visitedSet.remove(start);
        return temp;
    }

}
