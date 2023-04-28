class Solution{
public:
    vector<vector<int>> chefAndWells(int n,int m,vector<vector<char>> &c){
        // Code here
        vector<vector<int>>res(n, vector<int>(m,-1));
        vector<vector<bool>>vis(n, vector<bool>(m,0));
        queue<pair<int, pair<int,int>>>q;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(c[i][j]=='N'){
                    vis[i][j]=1;
                    res[i][j]=0;
                } if(c[i][j]=='W'){
                    vis[i][j]=1;
                    q.push({0,{i,j}});
                    res[i][j]=0;
                }if(c[i][j]=='.') res[i][j]=0;
            }
        }
        int dx[4]={0,0,1,-1};
        int dy[4]={1,-1,0,0};
        while(!q.empty()){
            auto x= q.front();
            int dist=x.first, row=x.second.first, col=x.second.second;
            q.pop();
            for(int i=0;i<4;i++){
                int r = row + dx[i];
                int co = col + dy[i];
                if(r>=0 and r<n and co>=0 and co<m and !vis[r][co] and (c[r][co]=='H' or c[r][co]=='.')){
                    if(c[r][co]=='H') res[r][co] = 2*(dist +1);
                    q.push({dist+1,{r,co}});
                    vis[r][co]=1;
                }
            }
        }
        return res;
    }
};
