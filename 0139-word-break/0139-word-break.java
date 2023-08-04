class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n];    // dp array
        HashSet<String> set = new HashSet<>(wordDict); // for easy searching
        return canBreakWord(0, n, s, set, dp);
    }

    private boolean canBreakWord(int ind, int n, String s, HashSet<String> set, Boolean[] dp){
        if (ind == n)
            return true;
        if (dp[ind] != null)
            return dp[ind];
        
        for (int i = ind; i < n; i++){
            if (set.contains(s.substring(ind, i + 1))){
                if (canBreakWord(i + 1, n, s, set, dp))
                    return dp[ind] = true;
            }
        }
        return dp[ind] = false;
    }
}