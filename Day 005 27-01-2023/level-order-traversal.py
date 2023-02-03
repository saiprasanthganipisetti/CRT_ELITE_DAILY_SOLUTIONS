class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        arr = []
        arr.append([root.val])
        print(arr)
        temp = [root]
        while len(temp):
            n = len(temp)
            a = []
            for i in range(n):
                curr = temp.pop(0)
                if(curr.left != None):
                    temp.append(curr.left)
                    a.append(curr.left.val)
                if(curr.right != None):
                    temp.append(curr.right)
                    a.append(curr.right.val)
            if len(a) != 0:
                arr.append(a)
        return arr
 
