class Solution {
public:
    static bool check(vector<int> &nums, int k) {
        long long have=0;
        for (int n: nums)
        {
            if (n<=k)
            {
                have += k-n;
            }
            else
            {
                if (have < n-k)
                    return 0; 
                else
                    have -= (n-k);
            }
        }
        return 1;
    }

    int minimizeArrayValue(vector<int> &nums) {
        int left=0, right = *max_element(nums.begin(), nums.end());
        while (left<right)
        { 
            int mid = left+(right-left)/2;
            if (check(nums, mid))
                right=mid;
            else
                left= mid + 1;
        }
        return left;
    }
};
