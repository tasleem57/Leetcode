class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        // (a / b) % MOD = (a % MOD * pow(b, MOD - 2) % MOD) % MOD;
        long preSum = 1; //preSum = N * N-1 * N - 2...N - (K - 1)
        int MOD = 1_000_000_007;
        
        for (int i = 0; i <= K - 1; ++i) {
            preSum *= (N - i);
            preSum %= MOD;
        }
        long ans = preSum % MOD * (myPow(N - K, L - K, MOD) % MOD); // means count(N)

        int sign = -1;
        long C_N_i = 1;

        // preSum means i * (i - 1) * (i - 2) *....* (i - (K - 1))
        // So the iterate for preSum is: preSum = preSum * (i - (K - 1)) / (i + 1)
        for (int i = N - 1; i >= K + 1; --i) {
            C_N_i = (C_N_i * (i + 1) % MOD) * myPow(N - i, MOD - 2, MOD) % MOD; // C_N_i = C_N_(i+1) * (i + 1) / (N - i)
            preSum = (preSum * (i - K + 1)) % MOD * myPow(i + 1, MOD - 2, MOD) % MOD; 
            ans = (ans + (MOD + sign * (C_N_i * preSum % MOD * myPow(i - K, L - K, MOD)) % MOD) % MOD) % MOD;
            sign = -sign;

        }
        return (int)(ans % MOD);
    }
    public static long myPow(int a, int b, int mod) {
        if (b == 0) return 1;
        long half = myPow(a, b / 2, mod);
        if (b % 2 == 1) return (half * half) % mod * a % mod;
        return half * half % mod;
    }

}