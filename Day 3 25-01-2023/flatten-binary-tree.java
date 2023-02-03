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

    List<Integer> li = new ArrayList<Integer>();

    void preorder(TreeNode node){
        if(node == null)
            return;
        li.add(node.val);
        preorder(node.left);
        preorder(node.right);
       
    }
    public void flatten(TreeNode root) {
        preorder(root);
        for(int i = 1; i < li.size(); i++){
            root.right = new TreeNode(li.get(i),null,null);
            root.left = null;
            root = root.right; 
        }
    }
}
