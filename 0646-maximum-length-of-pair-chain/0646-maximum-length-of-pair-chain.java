import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxChainLength = 0;
        for (int length : dp) {
            maxChainLength = Math.max(maxChainLength, length);
        }

        return maxChainLength;
    }
}