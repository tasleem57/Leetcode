class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // Step 1: Build adjacency list graph
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        // Step 2: Perform BFS from the target node
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        queue.add(new Pair<>(target, 0));
        visited.add(target);
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int distance = pair.getValue();
            
            if (distance == K) {
                result.add(node.val);
            }
            
            if (distance > K) {
                break;
            }
            
            for (TreeNode neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new Pair<>(neighbor, distance + 1));
                }
            }
        }
        
        return result;
    }
    
    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) {
            return;
        }
        
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}