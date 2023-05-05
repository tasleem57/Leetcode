class Solution {
public:
    int maxVowels(string s, int k) {
        int cnt=0;
        string t="aeiou";
        // count vowel in first k item in tring
        for(int i=0;i<k && i<s.size();i++)
        {
            if(t.find(s[i])!=string::npos)
            {
                cnt++;
            }
        }
        int ans=cnt;
        // use slinding window approch
        for(int i=1;i<=s.size()-k;i++)
        {
            if(t.find(s[i-1])!=string::npos)
            {
                cnt--;
            }
            if(t.find(s[i+k-1])!=string::npos)
            {
                cnt++;
            }
            ans=max(ans,cnt);
        }
        return ans;
    }
};
