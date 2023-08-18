class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = graph[i].size() + graph[j].size();
                if (graph[i].contains(j) || graph[j].contains(i)) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        
        return maxRank;
    }
}