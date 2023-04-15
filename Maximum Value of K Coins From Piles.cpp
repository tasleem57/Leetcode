class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        int n = piles.size();
        
        int dp[n+1][k+1];
        memset(dp,0,sizeof(dp));

        for(int i=1; i<=n; i++)
        {
            int sz = piles[i-1].size();
            for(int j=1; j<=k; j++)
            {
                int tmp = dp[i-1][j];
                int curr = 0, s = 0;
                for(int t=1; t<=sz; t++)
                {
                    s += piles[i-1][t-1];
                    if(j-t >= 0)
                        curr = max(curr, dp[i-1][j-t] + s);

                    dp[i][j] = max(dp[i-1][j], curr);
                }
            }
        }

        return dp[n][k];
    }
};
