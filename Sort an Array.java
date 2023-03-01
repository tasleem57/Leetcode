class Solution {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int randomIdx = left + new Random().nextInt(right - left + 1);

        swap(nums, left, randomIdx);

        int pivot = nums[left];

        int lt = left + 1;
        int gt = right;

        while (true) {
            while (lt < right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }

            swap(nums, lt, gt);
            lt++;
            gt--;
        }

        swap(nums, left, gt);

        return gt;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
