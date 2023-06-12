public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();
        int ind = 0;
        while(ind < nums.length) {
            int j = ind + 1;
            while(j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }

            result.add(addRange(nums, ind, j - 1));
            ind = j;
        }
        return result;
    }
    
    private String addRange(int[] nums, int i, int j) {
        if(i == j) {
            return String.valueOf(nums[i]);
        } else {
            return String.format("%d->%d", nums[i], nums[j]);
        }
    }
}