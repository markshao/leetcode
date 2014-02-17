package leetcode.oj.maxmiumSubArray;

public class Solution {
    public int maxSubArray(int[] A) {
        int ans = 0, maxn = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (ans < 0) ans = 0;
            ans += A[i];
            maxn = Math.max(maxn, ans);
        }
        return maxn;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        System.out.println(new Solution().maxSubArray(A));
    }
}
