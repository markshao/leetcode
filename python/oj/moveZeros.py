__author__ = 'ramsey'


def moveZeroes(nums):
    """
    :type nums: List[int]
    :rtype: void Do not return anything, modify nums in-place instead.
    """
    length = len(nums)
    count = i = 0
    while count < length:
        if nums[i] != 0:
            i += 1
        else:
            nums.pop(i)
            nums.append(0)
        count += 1


if __name__ == "__main__":
    test_data = [0, 0, 1]
    moveZeroes(test_data)
    print test_data