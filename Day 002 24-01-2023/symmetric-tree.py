class Solution:
    
    a = []
    def inorder(self,node):
        if node == None:
            return
            
        if node.right == None and node.left == None :
            # self.a.append(101)
            self.a.append(node.val)
            # self.a.append(101)
            return

        if node.left == None and node.right != None:
            self.a.append(101)
            self.a.append(node.val)
            self.inorder(node.right)
            return
        if node.left != None and node.right == None:
            self.inorder(node.left)
            self.a.append(node.val)
            self.a.append(101)
            return
        
        self.inorder(node.left)
        self.a.append(node.val)
        self.inorder(node.right)
        return
   
   
    def isSymmetric(self, node: Optional[TreeNode]) -> bool:
        
        self.a = []
        print(self.a)
        self.inorder(node)
        l = self.a
        i, j = 0, len(l)-1
        print(self.a)
        while(i<=j):
            if l[i] != l[j]:
                return False
            i += 1
            j -= 1
        return True 
