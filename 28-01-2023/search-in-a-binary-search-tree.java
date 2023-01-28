//Recursive method
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        if(val < root.val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val);
    }
}


//Iterative method
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
       // TreeNode curr = root;
        while(root!=null && root.val != val){
            if(val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }
}
