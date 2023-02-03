/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    TreeNode create(ArrayList<Integer> list){
        if(list.isEmpty()){
            return null;
        }
        int n = list.size();
        TreeNode root = new TreeNode(list.get(n/2));
        root.left = create(new ArrayList<>(list.subList(0,n/2)));
        root.right = create(new ArrayList<>(list.subList(n/2+1,n)));
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return create(list);

    }
}
