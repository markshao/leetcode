package leetcode.oj.divideTwoIntegers;

// http://oj.leetcode.com/problems/divide-two-integers/

public class Solution {
    public int divide(int dividend, int divisor) {
        long res = 0;

        long absDivisor = Math.abs((long) divisor);
        long absDividend = Math.abs((long) dividend);

        int suffix = 1;

        if (dividend < 0 & divisor >= 0)
            suffix = -1;

        if (dividend >= 0 & divisor < 0)
            suffix = -1;

        long t = 1;
        while (absDividend > 0) {
            if (absDividend >= absDivisor) {
                absDividend -= absDivisor;
                res += t;
                absDivisor <<= 1;
                t <<= 1;
            } else {
                while (absDividend < absDivisor) {
                    absDivisor >>= 1;
                    t >>= 1;
                }
            }
        }

        return (int) res * suffix;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.divide(-100, 1));
    }

}