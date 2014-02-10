package leetcode.oj.triangle;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by mark on 2/10/14.
 */

public class Solution {
    static int sum = 0;

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        Node head = convertToTree(triangle);
        getMaxSumByPath(head,0);
        return sum;
    }

    public void getMaxSumByPath(Node node,int newValue) {
        if (node.left == null && node.right == null) {
            int newSum = newValue + node.val;
            if (sum == 0)
                sum = newSum;
            else if (sum < newSum)
                sum = newSum;
        } else if (node.left != null) {
            getMaxSumByPath(node.left,newValue+node.val);
        } else if (node.right != null) {
            getMaxSumByPath(node.right,newValue+node.val);
        }
    }

    public Node convertToTree(ArrayList<ArrayList<Integer>> triangle) {
        int height = triangle.size();
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node cnode = new Node(triangle.get(0).get(0), 0, 0);
        Node head = cnode;
        queue.addLast(cnode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.i == height - 1) {
                continue;
            } else {
                Node left = new Node(triangle.get(node.i + 1).get(node.j), node.i + 1, node.j);
                Node right = new Node(triangle.get(node.i + 1).get(node.j + 1), node.i + 1, node.j + 1);
                node.left =left;
                node.right = right;
                queue.addLast(left);
                queue.addLast(right);
            }
        }
        return head;
    }

    class Node {
        public Node(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }

        int val;
        int i;
        int j;
        Node left = null;
        Node right = null;
    }
}
