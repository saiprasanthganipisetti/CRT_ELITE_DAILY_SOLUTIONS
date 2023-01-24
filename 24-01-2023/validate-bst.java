class Solution {
    List<Integer> li = new ArrayList<Integer>();
    
    public List<Integer> inorder(TreeNode node){
        if(node == null)
            return new ArrayList<>();
        inorder(node.left);
        li.add(node.val);
        inorder(node.right);
        return li;
    }

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i = 1; i < li.size(); i++){
            if(li.get(i-1) >= li.get(i))
                return false;
        }
        return true;
    }
}
