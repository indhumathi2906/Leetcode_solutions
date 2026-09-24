class Solution:
    def rob(self, nums: list[int]) -> int:
        n=len(nums)
        if n<=3:
            return max(nums)
        def rob2(nums,n):
            if n==3:
                return max(nums[0]+nums[2], nums[1])
            prev, prev1, prev2= nums[0]+nums[2], nums[1], nums[0]
            for i in range(3, n):
                prev, prev1, prev2=nums[i]+max(prev1, prev2), prev, prev1

            return max(prev, prev1)
        return max(rob2(nums[1:],n-1), rob2(nums[:-1], n-1))