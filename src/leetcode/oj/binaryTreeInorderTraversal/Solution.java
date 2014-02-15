package leetcode.oj.binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		Set<TreeNode> dict = new HashSet<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				if (!dict.contains(node.left)){
					stack.add(node);
					stack.add(node.left);
					continue;
				}
			}
			result.add(node.val);
			dict.add(node);
			if (node.right != null) {
				if (!dict.contains(node.right)){
					stack.add(node.right);
					continue;
				}
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		System.out.println(new Solution().inorderTraversal(root));
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