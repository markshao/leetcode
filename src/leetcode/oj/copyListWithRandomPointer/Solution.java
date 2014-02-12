package leetcode.oj.copyListWithRandomPointer;

import java.util.HashMap;

/**
 * Created by mark on 2/12/14.
 */

// http://oj.leetcode.com/problems/copy-list-with-random-pointer/

public class Solution {
    static HashMap<RandomListNode, RandomListNode> dict = new HashMap<RandomListNode, RandomListNode>();

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead = copyNextList(head);
        copyRandomList(newHead, head);
        return newHead;
    }

    public RandomListNode copyNextList(RandomListNode head) {
        if (head == null) {
            return null;
        } else {
            RandomListNode node = new RandomListNode(head.label);
            node.next = copyNextList(head.next);
            dict.put(head, node);
            return node;
        }
    }

    public void copyRandomList(RandomListNode newHead, RandomListNode head) {
        RandomListNode currentHead = newHead;
        while (head != null) {
            currentHead.random = dict.get(head.random);
            head = head.next;
            currentHead = currentHead.next;
        }
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};