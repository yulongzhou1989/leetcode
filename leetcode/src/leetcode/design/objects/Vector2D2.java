package leetcode.design.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D2 implements Iterator<Integer> {
    
    List<Integer> res;

    public Vector2D2(List<List<Integer>> vec2d) {
        res = new ArrayList<Integer>();
        
        for(List<Integer> list: vec2d){
            for(Integer val: list){
                res.add(val);
            }
        }
    }

    @Override
    public Integer next() {
        Integer val = null;
        if(hasNext())
           val =  res.remove(0);
        return val;
    }

    @Override
    public boolean hasNext() {
        return res.size()!=0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */