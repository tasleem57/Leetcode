class Solution {
    public boolean solve(int[] nums, int d, int p) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= d) {
                c++;
                i++;
            }
            if (c >= p) {
                return true;
            }
        }
        return false;
    }
    
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (solve(nums, mid, p)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}