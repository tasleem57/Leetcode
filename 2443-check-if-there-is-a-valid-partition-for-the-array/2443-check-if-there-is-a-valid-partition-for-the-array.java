class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        if(nums[1] == nums[0]) dp[2] = true;
        for (int i = 2; i < n; i++) {

            if (nums[i] == nums[i - 1]) dp[i+1] |= dp[i - 1];
            
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) dp[i+1] |= dp[i - 2];
            
            if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) dp[i+1] |= dp[i-2];
            
        }

        return dp[n];
    }
}