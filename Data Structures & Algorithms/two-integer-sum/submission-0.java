class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0 ; i < nums.length; i++) {
            int number = nums[i];
            int diff = target - number;
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            } else {
                map.put(number, i);
            }
        }

        return new int[] {0, 0};
    }
}
