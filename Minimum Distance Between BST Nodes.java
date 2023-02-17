class Solution {
    public void dfs(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        int minimumDiff = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            minimumDiff = Math.min(minimumDiff, Math.abs(list.get(i - 1) - list.get(i)));
        }
        return minimumDiff;
    }
}
