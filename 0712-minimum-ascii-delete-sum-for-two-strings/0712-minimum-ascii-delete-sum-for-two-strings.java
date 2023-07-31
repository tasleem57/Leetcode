class Solution {
    private int[][] dp;
    
    private int remains(String s, int i) {
        int sum = 0;
        for (int j = i; j < s.length(); j++) {
            sum += s.charAt(j);
        }
        return sum;
    }
    
    private int dfs(int i, int j, String s1, String s2) {
        if (i == s1.length() && j == s2.length()) return 0;
        if (i == s1.length() && j < s2.length()) return remains(s2, j);
        if (j == s2.length() && i < s1.length()) return remains(s1, i);
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = dfs(i + 1, j + 1, s1, s2);
        } else {
            return dp[i][j] = Math.min(s1.charAt(i) + dfs(i + 1, j, s1, s2),
                                      s2.charAt(j) + dfs(i, j + 1, s1, s2));
        }
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, s1, s2);
    }
}