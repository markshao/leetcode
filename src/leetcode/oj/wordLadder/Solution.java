package leetcode.oj.wordLadder;

import java.util.HashSet;
import java.util.Set;

//http://oj.leetcode.com/problems/word-ladder/

public class Solution {

	static int count = 0;
	static Set<String> duplicated = new HashSet<String>();
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
		ladder(start, end, dict, new HashSet<String>());
		return count;
	}

	public void ladder(String start, String end, HashSet<String> dict,
			HashSet<String> path) {
		if (cmp(start, end) == 1) {
			int c = path.size() + 2;
			if (count == 0)
				count = c;
			else if (c < count)
				count = c;
		} else {
			for (String s : dict) {
				if (duplicated.contains(s))
					continue;
				else
					duplicated.add(s);
				if (cmp(start, s) == 1) {
					HashSet<String> newdict = (HashSet<String>) dict.clone();
					newdict.remove(s);
					HashSet<String> newpath = (HashSet<String>) path.clone();
					path.add(s);
					ladder(s, end, newdict, newpath);
				}
			}
		}
	}

	public int cmp(String x, String y) {
		int length = x.length();
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (x.charAt(i) != y.charAt(i))
				result++;
		}
		return result;
	}
}