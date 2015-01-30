#!/usr/bin/python
# coding:utf8

'''
@author: shaoyuliang
@contact: mshao@splunk.com
@since: 7/16/14

'''

# https://oj.leetcode.com/problems/merge-sorted-array/

class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        for i in range(n):
            A.append(B[i])

        a = 0
        b = m
        while a < b and b < m + n:
            if A[a] < A[b]:
                a += 1
                continue
            else:
                c = A.pop(b)
                b += 1
                A.insert(a, c)


A = [1, 3, 5]
Solution().merge(A, 3, [2, 4], 2)
print A