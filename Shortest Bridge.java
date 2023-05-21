class Tuple{
    int x,y,dist;
    public Tuple(int x,int y, int dist)
    {
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
class Solution {
    int n,m;
#This function marks any one component as visited by marking it to 2
    public void bfs(int[][] grid,int r,int c, PriorityQueue<Tuple> pq,PriorityQueue<Tuple> pq1)
    {
        int[] del_row={0,1,0,-1};
        int[] del_col={1,0,-1,0};
        pq.add(new Tuple(r,c,0));
        pq1.add(new Tuple(r,c,0));
        while(!pq.isEmpty())
        {
            int x=pq.peek().x;
            int y=pq.peek().y;
            int dist=pq.peek().dist;
            grid[x][y]=2;
            pq.remove();
            for(int i=0;i<4;i++)
            {
                int d_row=x+del_row[i];
                int d_col=y+del_col[i];
                if(d_row>=0 && d_row<n && d_col>=0 && d_col<m && grid[d_row][d_col]==1)
                {
                    grid[d_row][d_col]=2;
                    pq.add(new Tuple(d_row,d_col,0));
                    pq1.add(new Tuple(d_row,d_col,0));
                }
            }


        }
    }
    public int shortestBridge(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        PriorityQueue<Tuple> pq1=new PriorityQueue<>((a,b)->a.dist-b.dist);

        int a,b,c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if (grid[i][j]==1){
                    a=i;
                    b=j;
                    c=1;
                    bfs(grid,a,b,pq,pq1);
                    break;
                }
            }
            if (c==1)
                break;
        }

        int[] del_row={0,1,0,-1};
        int[] del_col={1,0,-1,0};

        while(!pq1.isEmpty())
        {
            int x=pq1.peek().x;
            int y=pq1.peek().y;
            int dist=pq1.peek().dist;
            pq1.remove();
            for(int i=0;i<4;i++)
            {
                int d_row=x+del_row[i];
                int d_col=y+del_col[i];
                if(d_row>=0 && d_row<n && d_col>=0 && d_col<m && grid[d_row][d_col]==1)
                    return dist;
                if(d_row>=0 && d_row<n && d_col>=0 && d_col<m && grid[d_row][d_col]==0)
                {
                    grid[d_row][d_col]=2;
                    pq1.add(new Tuple(d_row,d_col,dist+1));
                }
                
            }
        }
        return 0;
    }
}
