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
    Stack<TreeNode> stack = new Stack<>();
    void push(int k){
        TreeNode temp = stack.pop();
        
        TreeNode curr = temp.right;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode temp = root;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        for(int i = 1; i < k; i++){
            push(k);
        }
        return stack.pop().val;
    }
} 
