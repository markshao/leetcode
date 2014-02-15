package leetcode.oj.populatingNextRightPointToTheNode;

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.right != null && root.next != null && root.next.left != null)
			root.right.next = root.next.left;
		if (root.left != null)
			root.left.next = root.right;
		connect(root.left);
		connect(root.right);
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}