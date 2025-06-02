class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        permutations=[]
        current=[]

        def collect():
            if len(nums)==0:
                permutations.append(current.copy())
                return

            for i in range(len(nums)):
                number = nums.pop(i)
                current.append(number)
                collect()
                current.pop(-1)
                bisect.insort(nums, number)

            return

        collect()
        return permutations