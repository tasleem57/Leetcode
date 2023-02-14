class Solution {
public:
    string addBinary(string a, string b) {
        int n = max(a.size(), b.size()) + 1;
        vector<int> digits(n,0);
        for (int p = 0; p < a.size(); p++) {
            digits[p] = a[a.size() - 1 - p] - '0';
        }
        for (int p = 0; p < b.size(); p++) {
            digits[p] += b[b.size() - 1 - p] - '0';
        }
        stringstream ss;
        int P = 0;
        for (int p = 0; p < n - 1; p++) {
            if (digits[p])
                P = p;
            if (digits[p] >= 2) {
                digits[p] -= 2;
                digits[p + 1]++;
            }
        }
        for (int p = digits[n - 1] ? n - 1 : P; p >= 0; p--) {
            ss << digits[p];
        }
        return ss.str();
    }
};
