class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        long sum=n;
        long res=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                int count=bfs(i,vis,adj,0);
                sum-=count;
                res+=(sum*count);
            }
        }
        return res;
    }
    public int bfs(int i,boolean[] vis,List<List<Integer>> adj,int count){
        Queue<Integer> qu=new LinkedList<>();
        qu.add(i);
        count++;
        while(!qu.isEmpty()){
            int curr=qu.poll();
            for(int adjnode:adj.get(curr)){
                if(!vis[adjnode]){
                    qu.add(adjnode);
                    count++;
                    vis[adjnode]=true;
                }
            }
        }
        return count;
    }
}
