package leetcode.oj.divideTwoIntegers;

// http://oj.leetcode.com/problems/divide-two-integers/

public class Solution {
	public int divide(int dividend, int divisor) {
		int res = 0;

		int absDivisor = Math.abs(divisor);
		int absDividend = Math.abs(dividend);

		int suffix = 1;

		if (dividend < 0 & divisor >= 0)
			suffix = -1;

		if (dividend >= 0 & divisor < 0)
			suffix = -1;

		while (absDividend >= absDivisor) {
			absDividend -= absDivisor;
			res++;
		}

		return res * suffix;
	}

	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		solution.divide(274471171, 1);
	}

}