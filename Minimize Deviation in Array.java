class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2);
        }
        int minDev = Integer.MAX_VALUE;
        while (true) {
            int max = set.last();
            int min = set.first();
            minDev = Math.min(minDev, max - min);
            if (max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else {
                break;
            }
        }
        return minDev;
    }
}
