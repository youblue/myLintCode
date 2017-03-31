/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        /* My way
        // write your code here
        if(root == NULL || p == NULL || p == root && root->right == NULL){
            return NULL;
        }
        stack<TreeNode*>st;
        while(root != NULL || !st.empty()){
            while(root != NULL && root->val != p->val){
                st.push(root);
                root = root->left;
            }
            if(root != NULL){
                if(root->right == NULL){
                    if(!st.empty()){
                        root = st.top();
                        return root;
                    }else{
                        return NULL;
                    }
                }else{
                    root = root->right;
                    while(root->left != NULL){
                        root = root->left;
                    }
                    return root;
                }
            }else{
                root = st.top();
                st.pop();
                root = root->right;
            }
        }
        return NULL;
  */      
        
      
        TreeNode *successor = NULL;
        while(root != NULL && root->val != p->val){
            if(p->val < root->val){
                successor = root;
                root = root->left;
            }else{
                root = root->right;
            }
        }
        if(root == NULL){
            return NULL;
        }
        
        if(root->right == NULL){
            return successor;
        }
        
        
        root = root->right;
        while(root->left != NULL){
            root = root->left;
        }
        
        return root;
      

        
    }
    
};