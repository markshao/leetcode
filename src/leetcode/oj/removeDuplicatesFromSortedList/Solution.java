package leetcode.oj.removeDuplicatesFromSortedList;

import leetcode.ListNode;

public class Solution {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return null;

		ListNode current = head;
		ListNode next = current.next;

		while (current != null && next != null) {
			if (current.val == next.val) {
				next = next.next;
			} else {
				current.next = next;
				current = next;
			}
		}

		current.next = next;
		return head;
	}
}
