#!/usr/bin/python
#coding:utf8

__author__ = 'markshao'

"""
http://oj.leetcode.com/problems/symmetric-tree/
"""

# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# to compute whether the tree is the symmetric,
# we could do it from bottom to the top



class Solution:
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
        if root == None: return True
        return self.checkSym(root.left, root.right)

    def checkSym(self, left, right):
        if left == right == None: return True
        if not (left and right): return False
        if left.val != right.val: return False
        return self.checkSym(left.left, right.right) and self.checkSym(left.right, right.left)