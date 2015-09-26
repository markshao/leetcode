__author__ = 'ramsey'


def moveZeroes(nums):
    """
    :type nums: List[int]
    :rtype: void Do not return anything, modify nums in-place instead.
    """
    length = len(nums)
    count = 0
    for i, val in enumerate(nums):
        if val == 0:
            nums.pop(i)
            nums.append(0)
        if count == length:
            break
        else:
            count += 1


if __name__ == "__main__":
    test_data = [0, 0, 1]
    moveZeroes(test_data)
    print test_data