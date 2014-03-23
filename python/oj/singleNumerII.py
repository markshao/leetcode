#!/usr/bin/python
#coding:utf8

__author__ = 'markshao'

"""
http://oj.leetcode.com/problems/single-number-ii/
"""


class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        bit = [0 for i in xrange(32)]
        for x in A:
            for i in xrange(32):
                if x & (1 << i) == 1 << i:
                    bit[i] += 1
        res = 0
        if bit[31] % 3 == 0: # posivie
            for i in xrange(31):
                if bit[i] % 3 == 1: res += 1 << i
        else: # negative
            for i in xrange(31):
                if bit[i] % 3 == 0: res += 1 << i
            res = -(res + 1)
        return res


print Solution().singleNumber([2, 2, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5])