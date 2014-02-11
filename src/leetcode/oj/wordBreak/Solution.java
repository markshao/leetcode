package leetcode.oj.wordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mark on 2/11/14.
 */

//http://oj.leetcode.com/problems/word-break/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        boolean[] can = new boolean[length+1];
        can[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && dict.contains(s.substring(j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[length];
    }

    public static void main(String[] args) {
        String[] arg = new String[]{"cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a", "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb"};
        Set<String> dict = new HashSet<String>(Arrays.asList(arg));
        System.out.println(new Solution().wordBreak("bccdbacdbdacddabbaaaadababadad", dict));
    }
}