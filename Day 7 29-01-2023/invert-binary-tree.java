/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
