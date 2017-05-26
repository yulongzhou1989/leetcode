package leetcode.StringArray;

import java.util.stream.Stream;

public class KeyboardRow_500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] findWords(String[] words) {
        return Stream.of(words).filter(s->s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
