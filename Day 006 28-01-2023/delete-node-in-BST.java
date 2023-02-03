class Solution {
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null)
            return root;
        // IF ROOT IS TO BE DELETED
        if(root.val == val){
            if(root.left == null && root.right == null)
                return null;
            else if(root.right == null){
                root = root.left;
                return root;
            }
            else if(root.left == null ){
                root = root.right;
                root.left = null;
                return root;
            }
        }

        //SEARCH
        TreeNode parent = null;
        TreeNode curr = root;
        while(curr.val != val){
            parent = curr;
            if(val < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
            if(curr == null)    
                return root;
        }
        //FOR TWO CHILDREN NODE
        if(curr.left != null && curr.right != null){
            //search for predecessor(greatest least number) i.e., in the left sub tree
            TreeNode temp = curr.right;
            parent = curr;
            while(temp.left != null){
                parent = temp;
                temp = temp.left;
            }
            //Now predecessor is found on the left subtree of curr, swap them
            System.out.println("curr,parent,temp" +curr.val+" "+parent.val+" "+temp.val);
            int a = curr.val;
            curr.val = temp.val;
            temp.val = a;
            //System.out.println("curr,parent,temp" +curr.val+" "+parent.val+" "+temp.val);
            //Now the curr is swapped to temp i.e., the node that has to be deleted is broght down to make its children count one or zero.
            //Now, since we don't have a right child at curr, we can link parent with curr.left by compaing parent.data and curr.left.data
            //System.out.println(curr.val+" "+temp.val+" "+parent.val);
            if(parent.left == temp){
                if(temp.right != null)
                    parent.left = temp.right;
                else
                    parent.left = null;
            }
            else{
                if(temp.right != null)
                    parent.right = temp.right;
                else
                    parent.right = null;
            }
            return root;
        }
        //FOR NO CHILD
        if(curr.left == null && curr.right == null){
            if(curr.val > parent.val)
                parent.right = null;
            else
                parent.left = null;
            return root;
        }
        
        //FOR ONE CHILD
        if(curr.left == null && curr.right != null){
            if(curr.right.val < parent.val)
                parent.left = curr.right;
            else
                parent.right = curr.right;
        }
        else{
            if(curr.left.val < parent.val)
                parent.left = curr.left;
            else
                parent.right = curr.left;
            return root;
        }


        return root;
    }
 
}
