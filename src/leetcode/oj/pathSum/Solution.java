package leetcode.oj.pathSum;

//http://oj.leetcode.com/problems/path-sum/

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.val == sum && root.left == null && root.right == null) {
			return true;
		} else {

			int newSum = sum - root.val;
			return hasPathSum(root.left, newSum)
					|| hasPathSum(root.right, newSum);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
