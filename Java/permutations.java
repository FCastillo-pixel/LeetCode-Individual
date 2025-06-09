class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        collect(numsList, current, permutations);
        return permutations;
    }

    private void collect(List<Integer> nums, List<Integer> current, List<List<Integer>> permutations) {
        if (nums.isEmpty()) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            int number = nums.remove(i);
            current.add(number);
            collect(nums, current, permutations);
            current.remove(current.size() - 1);
            nums.add(i, number);
        }
    }
}