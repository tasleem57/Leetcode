class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0);

        for (int i = 0; i < n; i++) {
            for (int k : dp.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step != 0 && dp.containsKey(stones[i] + step)) {
                        dp.get(stones[i] + step).add(step);
                    }
                }
            }
        }

        return !dp.get(stones[n - 1]).isEmpty();
    }
}