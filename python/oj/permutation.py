__author__ = 'ramsey'

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 1:
            return [nums]
        else:
            result = []
            for i,v in enumerate(nums):
                for s in self.permute(nums[:i] + nums[i+1:]):
                    sub_result = [v]
                    sub_result.extend(s)
                    result.append(sub_result)
            return result


if __name__ == "__main__":
    solution = Solution()
    print solution.permute([1,2,3])