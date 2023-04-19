public class Solution {
    public int longestZigZag(TreeNode root) {
        int[] res = dfs(root);
        return res[2];
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{-1, -1, -1};
        }
        
        int[] leftSubtree = dfs(node.left);
        int[] rightSubtree = dfs(node.right);
        
        int leftLength = leftSubtree[1] + 1;
        int rightLength = rightSubtree[0] + 1;
        int maxLen = Math.max(Math.max(leftLength, rightLength), Math.max(leftSubtree[2], rightSubtree[2]));
        
        return new int[]{leftLength, rightLength, maxLen};
    }
}
