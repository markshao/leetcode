package leetcode.oj.jumpGameII;

/**
 * Created by mark on 2/12/14.
 */

// http://oj.leetcode.com/problems/jump-game-ii/
    
public class Solution {
    public int jump(int[] A) {
        return jump(A, A.length - 1);
    }

    public int jump(int[] A, int end) {
        if (end == 0) {
            return 0;
        } else {
            int minI = end - 1;
            for (int i = end - 1; i > -1; i--) {
                if (A[i] >= (end - i)) {
                    if (i < minI) {
                        minI = i;
                    }
                }
            }
            return 1 + jump(A, minI);
        }
    }
}
