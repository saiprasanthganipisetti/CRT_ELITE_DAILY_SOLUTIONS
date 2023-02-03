/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList<>();
        int a = 0;
        if(root == null)
            return li;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(a % 2 == 0){
                    temp.add(curr.val);
                }
                else{
                    temp.add(0,curr.val);
                }

                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);
            }
            li.add(temp);
            a++;
        }
        return li;
    }
}
