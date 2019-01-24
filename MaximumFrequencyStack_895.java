//solution 1 : Stack way.
// Time O1,
// Space On
class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        Integer freq = freqMap.get(x);
        int nextFreq = freq == null ? 1 : freq + 1;
        freqMap.put(x, nextFreq);
        group.putIfAbsent(nextFreq, new Stack<>());
        group.get(nextFreq).push(x);
        maxFreq = Math.max(maxFreq, nextFreq);
    }
    
    public int pop() {
        if (maxFreq == 0) {
            return -1;
        }
        int x = group.get(maxFreq).pop();
        freqMap.put(x, maxFreq - 1);
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }

        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */