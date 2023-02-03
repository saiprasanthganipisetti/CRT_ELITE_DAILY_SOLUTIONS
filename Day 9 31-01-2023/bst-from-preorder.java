class Solution {
    int index = 0;
    TreeNode construct(int[] pre, int bound){
        if(index == pre.length || pre[index] > bound)
            return null;
        TreeNode node = new TreeNode(pre[index++]);
        node.left = construct(pre, pre[index - 1]);
        node.right = construct(pre, bound);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MAX_VALUE);
    }
}
