class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null)
            return newNode;
        TreeNode curr = root;
        TreeNode parent = null;
        while(curr != null){
            parent = curr;
            if(val < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        if(parent.val < val)
            parent.right = newNode;
        else
            parent.left = newNode;
        return root;
    }
}
