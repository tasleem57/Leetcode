class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        
        def helper(root):
            if not root:
                return '#'
            subTree = str(root.val) + ',' + helper(root.left) + ',' + helper(root.right)
            if seen[subTree] == 1:
                ans.append(root)
            seen[subTree] += 1
            return subTree
        
        ans, seen = [], defaultdict(int)
        helper(root)
        return ans
