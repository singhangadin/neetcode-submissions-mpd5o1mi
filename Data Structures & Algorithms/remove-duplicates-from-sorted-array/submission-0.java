class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int i = 0;
        for (int num: set) {
            nums[i++] = num;
        }

        return set.size();
    }
}