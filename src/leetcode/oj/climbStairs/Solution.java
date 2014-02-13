package leetcode.oj.climbStairs;

public class Solution {

	public int climbStairs(int n) {
		int[] data = new int[n + 1];

		data[0] = 1;
		data[1] = 1;

		for (int i = 2; i <= n; i++) {
			data[i] = data[i - 2] + 2 + data[i - 1];
		}

		return data[n];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(3));
		System.out.println(new Solution().climbStairs(4));
		System.out.println(new Solution().climbStairs(2));
	}
}
