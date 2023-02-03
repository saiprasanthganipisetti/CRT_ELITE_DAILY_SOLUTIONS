class Solution {
    int preindex = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    TreeNode create(int[] pre, int start,int end){
        if(start > end)
            return null;
        int data = pre[preindex++];
        TreeNode root = new TreeNode(data);
        root.left = create(pre, start, map.get(data) - 1);
        root.right = create(pre, map.get(data)+1, end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return(create(preorder, 0, preorder.length - 1));
    }
}

