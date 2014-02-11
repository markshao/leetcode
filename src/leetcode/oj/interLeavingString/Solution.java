package leetcode.oj.interLeavingString;

/**
 * Created by mark on 2/11/14.
 */

//http://oj.leetcode.com/problems/interleaving-string/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        boolean[] bool = new boolean[s3.length()];

        for (int i = 0; i < s1.length(); i++) {
            boolean found = false;
            for (int j = 0; j < s3.length(); j++) {
                if (s1.charAt(i) == s3.charAt(j)) {
                    if (bool[j] == false) {
                        bool[j] = true;
                        found = true;
                        break;
                    } else {
                        continue;
                    }
                }
            }

            if (!found)
                return false;

        }

        for (int i = 0; i < s2.length(); i++) {
            boolean found = false;
            for (int j = 0; j < s3.length(); j++) {
                if (s2.charAt(i) == s3.charAt(j)) {
                    if (bool[j] == false) {
                        bool[j] = true;
                        found = true;
                        break;
                    } else {
                        continue;
                    }
                }
            }

            if (!found)
                return false;
        }

        for (boolean b : bool) {
            if (b == false)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("a", "b", "a"));
    }
}