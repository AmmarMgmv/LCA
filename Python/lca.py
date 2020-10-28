# The code below was found online at Geeksforgeeks.org
class Node: 
  
    def __init__(node, key): 
        node.key = key  
        node.left = None
        node.right = None

def checkNodes(root, n1, n2, v): 
      
    if root is None: 
        return None

    if root.key == n1 : 
        v[0] = True
        return root 
  
    if root.key == n2: 
        v[1] = True
        return root 
  
    left_lca = checkNodes(root.left, n1, n2, v) 
    right_lca = checkNodes(root.right, n1, n2, v) 
  
    if left_lca and right_lca: 
        return root  
  
    return left_lca if left_lca is not None else right_lca 
  
  
def find(root, k): 
      
    if root is None: 
        return False

    if (root.key == k or find(root.left, k) or find(root.right, k)): 
        return True

    return False
  
def findLCA(root, n1, n2): 
      
    v = [False, False] 
  
    lca = checkNodes(root, n1, n2, v) 
  
    if (v[0] and v[1] or v[0] and find(lca, n2) or v[1] and find(lca, n1)): 
        return lca 
  
    return None
  
root = Node(1) 
root.left = Node(2) 
root.right = Node(3) 
root.left.left = Node(4) 
root.left.right = Node(5) 
root.right.left = Node(6) 
root.right.right = Node(7) 
root.left.left.left = Node(8) 
root.left.left.right = Node(9) 
root.left.right.left = Node(10) 
  
lca = findLCA(root, 4, 5) 
if lca is not None: 
    print ("LCA(4, 5) = ", lca.key )
else : 
    print ("Keys are not present")
  
lca = findLCA(root, 4, 12) 
if lca is not None: 
    print ("LCA(4,12) = ", lca.key) 
else: 
    print ("Keys are not present")