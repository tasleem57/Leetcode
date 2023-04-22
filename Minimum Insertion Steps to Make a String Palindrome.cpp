class Solution {
public:
	int lcs(string s1, string s2) {
		int n=s1.size(),m=s2.size();
		vector<vector<int>> dp(n,vector<int>(m,0));
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(!i  || !j){
					if(s1[i]==s2[j]) dp[i][j]=1;
					else{
						if(!i && !j) dp[0][0]=0;
						else if(!i && j) dp[0][j]=dp[0][j-1];
						else if(i && !j) dp[i][0]=dp[i-1][0];
					}
				}
				else{
					if(s1[i]==s2[j]) dp[i][j]=1+dp[i-1][j-1];
					else dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[n-1][m-1];  
	}

	int minInsertions(string s) {
		return s.size()-lcs(s,string(s.rbegin(),s.rend()));
	}
};
