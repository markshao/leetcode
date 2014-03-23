#!/usr/bin/python
#coding:utf8

__author__ = 'markshao'

"""
http://oj.leetcode.com/problems/merge-two-sorted-lists/
"""
#Definition for singly-linked list.

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):

        if not l1:
            return l2
        if not l2:
            return l1

        root = ListNode(-1)
        current = root

        x = l1
        y = l2

        while x is not None and y is not None:
            if x.val <= y.val:
                current.next = x
                current = current.next
                x = x.next
            else:
                current.next = y
                current = current.next
                y = y.next

        if x:
            while x:
                current.next = x
                current = current.next
                x = x.next

        if y:
            while y:
                current.next = y
                current = current.next
                y = y.next

        return root.next


l1 = ListNode(2)
l2 = ListNode(1)

print Solution().mergeTwoLists(l1, l2)

