class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        int mod = (int)1e9 + 7;
        for (int i = 1; i <= high; i++) {
            
            int z = dp.getOrDefault(i - zero, 0);
            
            
            int o = dp.getOrDefault(i - one, 0);
            
            
            int n = (z + o) % mod;
            
            
            dp.put(i, n);
        }
        
        
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp.getOrDefault(i, 0)) % mod;
        }
        
       
        return ans;
    }
}
