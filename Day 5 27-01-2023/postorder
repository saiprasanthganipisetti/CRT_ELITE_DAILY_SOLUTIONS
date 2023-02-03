class Solution {
    List<Integer> li = new ArrayList<>();
    void main(TreeNode node){
        if(node == null)
            return;
        main(node.left);
        main(node.right);
        li.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        main(root);
        return li;
    }
}
