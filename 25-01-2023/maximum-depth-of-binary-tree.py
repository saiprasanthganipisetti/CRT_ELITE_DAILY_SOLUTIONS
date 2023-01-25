class Solution {
    int lh = 1,rh = 1;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
        
            
    }
}
