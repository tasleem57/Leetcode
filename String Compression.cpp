class Solution {
public:
    int compress(vector<char>& chars) {
        int prev = 0;
        int i=0;

        while( i< chars.size()) {
            int cnt = 1;
            char current = chars[i];
            while(++i<chars.size() && chars[i]==current) {
                cnt++;
                // i++;
            }
            chars[prev++] = current;

            if(cnt > 1){ 
                for(char& ch : to_string(cnt)) {
                    chars[prev++] = ch;
                }
            }
        }
        return prev;
    }
};
