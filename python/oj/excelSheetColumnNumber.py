#!/usr/bin/python
# coding:utf8

'''
@author: shaoyuliang
@contact: mshao@splunk.com
@since: 7/16/14

'''

# https://oj.leetcode.com/problems/excel-sheet-column-number/

class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        if not s:
            return 0
        else:
            sum = 0
            gap = 1
            s_l = list(s)
            while s_l:
                c = s_l.pop(-1)
                number = (ord(c) - ord('A') + 1) * gap
                sum += number
                gap *= 26

        return sum