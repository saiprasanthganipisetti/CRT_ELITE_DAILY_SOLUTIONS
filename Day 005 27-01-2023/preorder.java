class Solution {
    List<Integer> li = new ArrayList<>();
    void main(TreeNode node){
        if(node == null)
            return;
        li.add(node.val);
        main(node.left);
        main(node.right);
       
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        main(root);
        return li;
    }
}
