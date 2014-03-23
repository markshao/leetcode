#!/usr/bin/python
#coding:utf8

__author__ = 'markshao'

"""
    Implement base on the new style class
"""


class Singleton(object):
    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(Singleton, cls).__new__(cls, *args, **kwargs)

        return cls._instance

    def __init__(self):
        pass


instance1 = Singleton()
instance2 = Singleton()

print id(instance1)
print id(instance2)