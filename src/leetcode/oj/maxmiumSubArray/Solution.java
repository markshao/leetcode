package leetcode.oj.maxmiumSubArray;

public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        System.out.println(new Solution().maxSubArray(A));
    }
}
