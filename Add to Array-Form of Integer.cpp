class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {

        std::vector<int> kVec;
        while(k > 0)
        {
            kVec.emplace_back(k % 10);
            k /= 10;
        }

        std::reverse(kVec.begin(), kVec.end());

        int i = num.size() - 1;
        int j = kVec.size() - 1;
        bool carry = false;

        std::vector<int> returnVal;

        while(i >= 0 || j >= 0)
        {
            int sum = carry;

            if(i >= 0) sum += num[i--];
            if(j >= 0) sum += kVec[j--];

            returnVal.emplace_back(sum % 10);
            carry = sum > 9 ? true : false; 
        }

        if(carry == true) returnVal.emplace_back(1);
        std::reverse(returnVal.begin(), returnVal.end());

        return returnVal;
    }
};
