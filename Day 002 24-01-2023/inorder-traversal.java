class Solution {
    
    List<Integer> list = new ArrayList<Integer>();
    public void inorder(TreeNode node){
        if(node == null)
            return;
        else{
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
        
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;

    }
}
