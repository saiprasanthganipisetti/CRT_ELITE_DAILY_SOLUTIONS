class Solution {
    void main(TreeNode root){
        if(root == null)
            return ;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        main(root.left);
        main(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        main(root);
        return root;
        

    }
}
