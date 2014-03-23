#!/usr/bin/python
#coding:utf8

__author__ = 'markshao'

"""

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

"""

# http://oj.leetcode.com/problems/pascals-triangle/

class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        res = []
        if numRows > 0:
            res.append([1])

            for x in range(1, numRows):
                row = res[x - 1]
                res.append([1] + [row[k - 1] + row[k] for k in range(1, len(row))] + [1])

        return res


print Solution().generate(5)

