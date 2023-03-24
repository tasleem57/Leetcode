class Solution {
    private int res = 0;
    private Set<Pair<Integer, Integer>> roads = new HashSet<>();
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public int minReorder(int n, int[][] connections) {
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            roads.add(new Pair<>(u, v));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        dfs(0, -1);

        return res;
    }

    private void dfs(int u, int parent) {
        if (parent != -1 && roads.contains(new Pair<>(parent, u))) {
            res++;
        }

        for (int v : graph.get(u)) {
            if (v == parent) {
                continue;
            }
            dfs(v, u);
        }
    }
}
