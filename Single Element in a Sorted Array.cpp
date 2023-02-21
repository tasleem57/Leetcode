class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int n = nums.size();
        int curr_xor=0; //variable will store XOR
        for(int i =0;i<n;i++){
            curr_xor ^= nums[i]; // XOR
        }
        return curr_xor;
    }
};
