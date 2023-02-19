class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
      vector<vector<int>> ans;
      if(!root) return {};
      queue<TreeNode *> q;
      q.emplace(root);
      while(!q.empty()){
        int sz = q.size();
        vector<int> temp;
        for(int i = 0; i < sz; i++){
          auto qf = q.front(); q.pop();
          temp.emplace_back(qf->val);
          if(qf->left) q.emplace(qf->left);
          if(qf->right) q.emplace(qf->right);
        }
        ans.emplace_back(temp);
      }
      for(int i = 0; i < ans.size(); i++){
        if(i % 2) reverse(ans[i].begin(), ans[i].end());
      }
      return ans;
    }
};
