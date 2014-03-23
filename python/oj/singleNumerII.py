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
        result = 0
        for i in range(32):
            count = 0
            for num in A:
                count += (num >> i) & 1

            result |= (count % 3) << i
        return result
