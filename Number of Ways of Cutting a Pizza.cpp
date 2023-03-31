class Solution {
public:
    int n, m, MOD = 1e9 + 7;
    int memo[51][51][11];
    int pref[51][51];
    int ways(vector<string>& A, int k) {
        n = A.size(), m = A[0].size();
        memset(memo, -1, sizeof(memo));
        memset(pref, 0, sizeof(pref));
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                pref[i][j] = A[i][j] == 'A';
                if(i < n - 1)
                    pref[i][j] += pref[i + 1][j];
                if(j < m - 1)
                    pref[i][j] += pref[i][j + 1];
                if(i < n - 1 && j < m - 1)
                    pref[i][j] -= pref[i + 1][j + 1];
            }
        }
        return dp(A, 0, 0, k - 1);
    }
    int dp(vector<string>& A, int r, int c, int k){
        if(pref[r][c] == 0)
            return 0;
        if(!k)
            return 1;
        if(memo[r][c][k] != -1)
            return memo[r][c][k];
        int ans = 0;
        for(int nr = r + 1; nr < n; nr++){
            if(pref[r][c] - pref[nr][c] > 0)
                ans += dp(A, nr, c, k - 1) % MOD, ans %= MOD;
        }
        for(int nc = c + 1; nc < m; nc++){
            if(pref[r][c] - pref[r][nc] > 0)
                ans += dp(A, r, nc, k - 1) % MOD, ans %= MOD;
        }
        return memo[r][c][k] = ans;
    }
};
