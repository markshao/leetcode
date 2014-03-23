#!/usr/bin/python
#coding:utf8

__author__ = 'markshao'

l1 = [[1, 2, 3], 1, 2, 3]
t1 = tuple(l1)  # the tuple factory method create a new object with the copy , not the deepcopy

t1[0].append(4)

print t1
print l1