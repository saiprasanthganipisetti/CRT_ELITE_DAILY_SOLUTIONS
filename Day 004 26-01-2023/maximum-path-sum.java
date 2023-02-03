/*Approach is to check whether we gain anything from the  subtrees. There are two cases here, one is we get profit from subtree. If so, then we add it to the root, or else we skip. The maximum method below returns the best path among the left subtree and right subtree.*/
class Solution {
    int ans = -10000;
    public int maximum(TreeNode t){
        if(t == null)
            return 0;
        int l = Math.max(maximum(t.left),0);
        int r = Math.max(maximum(t.right),0);
       
        ans =  Math.max(ans, t.val+l+r);
        //System.out.println("At root : "+t.val+" : The maximum sum is : "+Math.max(t.val, Math.max(t.val+l,t.val+r)));
        return Math.max(t.val+l, t.val+r);
    }
    public int maxPathSum(TreeNode root) {
        maximum(root);
        return ans;
    }
}

