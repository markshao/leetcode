package leetcode.oj.binaryBalanceTree;

//http://oj.leetcode.com/problems/balanced-binary-tree/

public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			int left = getHeight(root.left);
			int right = getHeight(root.right);
			boolean res = Math.abs(left - right) <= 1;
			return res && isBalanced(root.left) && isBalanced(root.right);
		}

	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);

			if (leftHeight <= rightHeight)
				return 1 + rightHeight;
			else
				return 1 + leftHeight;
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
