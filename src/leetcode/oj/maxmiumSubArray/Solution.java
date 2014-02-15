package leetcode.oj.maxmiumSubArray;

public class Solution {
	public int maxSubArray(int[] A) {
		int res = A[0];
		int length = A.length;
		int[][] data = new int[length][length];

		for (int i = 0; i < length; i++) {
			data[i][0] = A[i];
		}

		for (int i = 1; i < length; i++) {

		}

		return res;
	}
}
