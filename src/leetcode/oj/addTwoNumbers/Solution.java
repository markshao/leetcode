package leetcode.oj.addTwoNumbers;

//http://oj.leetcode.com/problems/add-two-numbers/

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null)
			return null;

		ListNode head = new ListNode(-1);
		ListNode current = head;

		int appendix = 0;

		while (true) {
			if (l1 == null || l2 == null)
				break;

			int l1val = l1.val;
			int l2val = l2.val;
			l1 = l1.next;
			l2 = l2.next;

			int sum = l1val + l2val + appendix;
			int res = sum;
			if (sum >= 10) {
				res = sum % 10;
			}

			ListNode nod = new ListNode(res);
			current.next = nod;
			current = current.next;

			if (sum >= 10) {
				appendix = 1;
			} else {
				appendix = 0;
			}
		}

		if (l1 == null && l2 == null) {
			if (appendix != 0) {
				ListNode no = new ListNode(appendix);
				current.next = no;
			}

		} else if (l1 != null) {
			current.next = addTwoNumbers(l1, new ListNode(appendix));
		} else if (l2 != null) {
			current.next = addTwoNumbers(l2, new ListNode(appendix));
		}

		return head.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}