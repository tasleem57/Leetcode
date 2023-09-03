public class Solution {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        // Initialize dp grid with -1 values
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(m, n, 0, 0);
    }

    private int solve(int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = solve(m, n, i + 1, j) + solve(m, n, i, j + 1);
    }
}