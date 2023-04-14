class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        dp[s.length()-1][0] = 1;
        
        for(int i=s.length()-2; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                setValue(i, j, s, dp);
            }
        }
        return dp[0][s.length()-1];
    }
    
    void setValue(int i, int j, String s, int[][] dp){
        if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1] > 0)){
            if(j-i <= 2){
                dp[i][j] = j-i+1;
            }else{
                // taking middle part
                dp[i][j] = dp[i+1][j-1] + 2;
            }
        }else{
            // max of without current character, without starting character
            dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
        }
    }
}
