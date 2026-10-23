
class Solution {
    public int[] runningSum(int[] nums) {
        int result = 0;
        int[] list = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            list[i] = result;
        }

        return list;
    }
}
