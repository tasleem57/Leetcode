class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ops = 0;

        int prev = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > prev) {
                int k = (int) Math.ceil(nums[i] / (double) prev);
                ops += k - 1;
                prev = nums[i] / k;
            } else {
                prev = nums[i];
            }
        }
        return ops;
    }
}