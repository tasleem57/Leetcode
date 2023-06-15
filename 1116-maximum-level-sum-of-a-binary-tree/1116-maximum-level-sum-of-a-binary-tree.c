int maxLevelSum(struct TreeNode* root){
    struct TreeNode** EvenArray = malloc(5000 * sizeof(struct TreeNode*));
    struct TreeNode** OddArray = malloc(5000 * sizeof(struct TreeNode*));
    int EvenIdx = 0;
    int OddIdx = 0;
    EvenArray[0] = root;
    EvenIdx = 1;
    int maxSum = INT_MIN;
    int maxId = -1;
    int level = 1;
    while(EvenIdx || OddIdx){
        int sum = 0;
        if(EvenIdx != 0){
            for(int i = 0; i < EvenIdx; i++){
                sum += EvenArray[i]->val;
                if(EvenArray[i]->left){
                    OddArray[OddIdx] = EvenArray[i]->left;
                    OddIdx++;
                }
                if(EvenArray[i]->right){
                    OddArray[OddIdx] = EvenArray[i]->right;
                    OddIdx++;
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                maxId = level;
            }
            EvenIdx = 0;
            level++;
        }
        else{
            for(int i = 0; i < OddIdx; i++){
                sum += OddArray[i]->val;
                if(OddArray[i]->left){
                    EvenArray[EvenIdx] = OddArray[i]->left;
                    EvenIdx++;
                }
                if(OddArray[i]->right){
                    EvenArray[EvenIdx] = OddArray[i]->right;
                    EvenIdx++;
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                maxId = level;
            }
            OddIdx = 0;
            level++;
        }
    }
    return maxId;    

}