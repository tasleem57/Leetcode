class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0, total = 0, n = satisfaction.length;
        for (int i = n - 1; i >= 0 && satisfaction[i] > -total; --i) {
            total += satisfaction[i];
            res += total;
        }
        return res;
    
    }
}
