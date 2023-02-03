class Solution {
    List<Integer> li = new ArrayList<>();
    void main(TreeNode node){
        if(node == null)
            return;
        main(node.left);
       li.add(node.val);
        main(node.right);
        
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        main(root);
        return li;
    }
}
