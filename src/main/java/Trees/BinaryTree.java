package Trees;

class Node{
    int value;
    Node left, right;

    public Node(int key){
        value = key;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    Node root;

    BinaryTree(){
        root = null;
    }

    // postOrder transversal (left->right->root)
    void _postOrder(Node node){
        if(node == null){
            return;
        }
        _postOrder(node.left);
        _postOrder(node.right);
        System.out.print(node.value + "->");
    }

    // preOrder transversal (root->left->right)
    void _preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value + "->");
        _preOrder(node.left);
        _preOrder(node.right);
    }

    // inOrder transversal (left->root->right)
    void _inOrder(Node node){
        if(node == null){
            return;
        }
        _inOrder(node.left);
        System.out.print(node.value + "->");
        _inOrder(node.right);
    }

    void postOrder() {
        this._postOrder(root);
    }

    void inOrder() {
        _inOrder(root);
    }

    void preOrder() {
        _preOrder(root);
    }

    boolean _isFullBinaryTree(Node node){
        if(node == null){
            return true;
        }
        if(node.left == null && node.right == null){
            return true;
        }
        if(node.left != null && node.right != null){
            return _isFullBinaryTree(node.left) && _isFullBinaryTree(node.right);
        }
        return false;
    }

    boolean isFullBinaryTree(){
        return _isFullBinaryTree(root);
    }

    int depth(Node node){
        int dep = 0;
        while (node != null){
            dep++;
            node = node.left;
        }
        return  dep;
    }

    boolean _isPerfectBinaryTree(Node root, int depth, int level){
        if(root == null){
            return true;
        }
        if (root.left == null && root.right == null)
            return (depth == level + 1);

        if (root.left == null || root.right == null)
            return false;

        return _isPerfectBinaryTree(root.left, depth, level + 1) &&
                _isPerfectBinaryTree(root.right, depth, level + 1);
    }

    boolean isPerfectBinaryTree(){
        int dep = depth(root);
        return _isPerfectBinaryTree(root, dep, 0);
    }

    int numberOfNodes(Node node){
        if(node == null){
            return 0;
        }
        return (1 + numberOfNodes(node.left) + numberOfNodes(node.right));
    }

    boolean _isCompleteBinaryTree(Node node, int index, int numberOfNodes){
        if(node == null){
            return true;
        }
        if(index >= numberOfNodes){
            return false;
        }

        return (_isCompleteBinaryTree(node.left, index * 2 + 1, numberOfNodes) &&
                (_isCompleteBinaryTree(node.right, index * 2 + 2, numberOfNodes)));
    }

    boolean isCompleteBinaryTree(){
        int numberOfNodes = numberOfNodes(root);
        return _isCompleteBinaryTree(root, 0, numberOfNodes);
    }

    int _isHeightBalancedBinaryTree(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = _isHeightBalancedBinaryTree(node.left);
        int rightHeight = _isHeightBalancedBinaryTree(node.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    boolean isHeightBalancedBinaryTree(){
         return _isHeightBalancedBinaryTree(root) != -1;
    }

    Node _insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        if(data < node.value){
            node.left = _insert(node.left, data);
        }
        if(data > node.value){
            node.right = _insert(node.right, data);
        }

        return node;
    }

    void insert(int data){
         _insert(root, data);
    }

    Node _search(Node node, int num){
        if(node == null){
            return null;
        }
        if(node.value == num){
            return node;
        }
        if(node.value > num){
            return _search(node.left, num);
        }
        return _search(node.right, num);
    }

    Boolean search(int data){
        Node node = _search(root, data);
        return node != null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(8);

        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(9);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);



        System.out.println("Inorder traversal");
        tree.inOrder();

        System.out.println("\nPreorder traversal ");
        tree.preOrder();

        System.out.println("\nPostorder traversal");
        tree.postOrder();

        System.out.println("\nIs full binary tree: " + Boolean.toString(tree.isFullBinaryTree()));
        System.out.println("Is perfect binary tree: " + Boolean.toString(tree.isPerfectBinaryTree()));
        System.out.println("Is complete binary tree: " + Boolean.toString(tree.isCompleteBinaryTree()));
        System.out.println("Is height balanced binary tree: " + Boolean.toString(tree.isHeightBalancedBinaryTree()));
        System.out.println("Is 4 present: " + Boolean.toString(tree.search(4)));
    }
}
