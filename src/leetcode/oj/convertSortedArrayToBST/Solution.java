package leetcode.oj.convertSortedArrayToBST;

/**
 * Created by mark on 2/10/14.
 */

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }

        int middle = num.length / 2;
        TreeNode head = new TreeNode(num[middle]);
        addNode(head, num, 0, middle, true);
        addNode(head, num, middle + 1, num.length, false);
        return head;
    }

    public void addNode(TreeNode parent, int[] num, int left, int right, boolean isLeft) {
        if (right > left) {
            int middle = (right + left) / 2;
            TreeNode node = new TreeNode(num[middle]);
            if (isLeft) {
                parent.left = node;
            } else {
                parent.right = node;
            }

            addNode(node, num, left, middle, true);
            addNode(node, num, middle + 1, right, false);
        }
    }

    public static void main(String[] args) {
        new Solution().sortedArrayToBST(new int[] {3,5,7});
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