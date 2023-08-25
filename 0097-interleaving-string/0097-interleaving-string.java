import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

    private Map<Pair, Boolean> dp = new HashMap<>();
    private boolean dfs(int i, int j, String s1, String s2, String s3) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        Pair pair = new Pair(i, j);
        if (dp.containsKey(pair)) {
            return dp.get(pair);
        }

        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(i + 1, j, s1, s2, s3)) {
            result = true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(i, j + 1, s1, s2, s3)) {
            result = true;
        }

        dp.put(pair, result);
        return result;
    }

    private class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return first * 31 + second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return first == other.first && second == other.second;
        }
    }
}