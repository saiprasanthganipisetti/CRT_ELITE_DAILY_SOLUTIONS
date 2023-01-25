class Solution {
    int diameter = 0;
    int height(TreeNode node){
        if(node == null)
            return 0;
        
        int l = height(node.left);
        int r = height(node.right);

        if(diameter < l + r + 1)
            diameter = l + r;
        
        return Math.max(l,r)+1;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}
