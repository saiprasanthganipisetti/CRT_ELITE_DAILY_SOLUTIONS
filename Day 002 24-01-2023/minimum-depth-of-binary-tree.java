class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int l = 0, r = 0;
        l += minDepth(root.left);
        r += minDepth(root.right);
        return l == 0 || r == 0 ? l + r + 1 : Math.min(l,r)+ 1;
    }
}
