class Solution {
    public int search(int[] nums, int target) {
        int st = 0,end = nums.length-1,mid;
        while(st<=end) {
            mid = (end-st)/2 + st;
            if(target < nums[mid])
                end = mid-1;
            else if(target>nums[mid])
                st = mid+1;
            else
                return mid;
        }
        return -1;
    }
}
