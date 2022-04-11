package AE2;


public class extensionOfBST {
    static Node root;
    static Node minNode = new Node(Integer.MAX_VALUE, size());
    static class Node {
        private Node successor;
        private int size;
        private int item;
        private Node left;
        private Node right;
        private Node parent;
        Node(int item, int size) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.size = size;
        }
    }

    public extensionOfBST() {
        root = null;
    }

    private static int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    private static int size(){
        return size(root);
    }

    public static int min() {
        return minNode.item;
    }

    private static Node minimum(Node node) {
        if ( node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }

    public static Node successor(Node node){
        if(node.right!=null){
            return minimum(node.right);
        }
        Node y = node.parent;
        while(y!=null && node==y.right){
            node = y;
            y = y.parent;
        }
        return y;
    }

    public static void transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }


    public static void extractMin(){
        transplant(minNode, minNode.right);
        minNode = minNode.successor;
    }

    public static void insert(Node node){
        Node y = null;
        Node x = root;
        while(x!=null){
            y = x;
            y.size = y.size + 1;
            if(node.item < x.item){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        node.parent = y;
        node.size = 1;
        if(y==null){
            root = node;
        } else {
            if(node.item < y.item){
                node.successor = successor(node);
                y.left = node;
            } else {
                node.successor = successor(node);
                y.right = node;
            }
            }
        if (node.parent != null) {
            node.parent.successor = successor(node.parent);
        }
            if (node.item < minNode.item) {
                minNode = node;
            }
        }


    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.item + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        extensionOfBST q = new extensionOfBST();
        q.insert(new Node(5, size()));
        q.insert(new Node(3, size()));
        q.insert(new Node(7, size()));
        q.insert(new Node(2, size()));
        q.insert(new Node(4, size()));
        q.insert(new Node(6, size()));
        q.insert(new Node(8, size()));
        System.out.println("Tree:");
        q.inorder(root);
        System.out.println("");
        System.out.println("Minimum: " + q.min());
        q.extractMin();
        System.out.println("Tree after extracting Min:");
        q.inorder(root);


    }



}
