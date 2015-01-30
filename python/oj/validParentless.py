#!/usr/bin/python
# coding:utf8

'''
@author: shaoyuliang
@contact: mshao@splunk.com
@since: 7/16/14

'''

# https://oj.leetcode.com/problems/valid-parentheses/

class Solution:
    # @return a boolean
    def isValid(self, s):
        brackets = []
        for c in s:
            if c in ('(', ')', '{', '}', '[', ']'):
                brackets.append(c)

        rights = []
        while brackets:
            c = brackets.pop(0)
            if c in ('(', '{', '['):
                rights.append(c)
            else:
                if not rights or (rights[-1], c) not in (('(', ')'), ('{', '}'), ('[', ']')):
                    return False
                else:
                    rights.pop(len(rights) - 1)
        if rights:
            return False
        else:
            return True


print Solution().isValid('()')

