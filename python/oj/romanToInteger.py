#!/usr/bin/python
#coding:utf8

__author__ = 'markshao'

ROMAN_TABLE = {
    'I': 1,
    'V': 5,
    'X': 10,
    'L': 50,
    'C': 100,
    'D': 500,
    'M': 1000
}


class Solution:
    """
        http://oj.leetcode.com/problems/roman-to-integer/

        This solution is copied from the internet

        The table inside the function is used to list all the avilable pairs of the roman numbers, and sort
        it from the top to the end.

        because the roman number is limited to count from top to end.

    """

    def romanToInt(self, s):
        table = [['M', 1000], ['CM', 900], ['D', 500], ['CD', 400], ['C', 100], ['XC', 90], ['L', 50], ['XL', 40],
                 ['X', 10], ['IX', 9], ['V', 5], ['IV', 4], ['I', 1]]

        returnint = 0
        for pair in table:
            continueyes = True

            while continueyes:
                if len(string) >= len(pair[0]):

                    if string[0:len(pair[0])] == pair[0]:
                        returnint += pair[1]
                        string = string[len(pair[0]):]

                    else:
                        continueyes = False
                else:
                    continueyes = False

        return returnint


