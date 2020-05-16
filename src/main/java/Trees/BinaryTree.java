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

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(15);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(4);

        tree.root.right = new Node(7);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);



        System.out.println("Inorder traversal");
        tree.inOrder();

        System.out.println("\nPreorder traversal ");
        tree.preOrder();

        System.out.println("\nPostorder traversal");
        tree.postOrder();

        System.out.println("\nIs full binary tree: " + Boolean.toString(tree.isFullBinaryTree()));
        System.out.println("\nIs perfect binary tree: " + Boolean.toString(tree.isPerfectBinaryTree()));
    }
}
