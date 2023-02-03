class Solution {
    boolean ans = true;
    int depth(TreeNode node){
        
        if(node == null)
            return 0;
        int ld = depth(node.left) + 1;
        int rd = depth(node.right) +1;
        
        
        if(Math.abs(ld-rd)>1)
            ans = false;
        return Math.max(ld,rd);
    }
    public boolean isBalanced(TreeNode root) {
        System.out.println(depth(root));
        return ans;
    }
}
