package AE2;

import java.util.LinkedList;
import java.util.Queue;

public class binarySearchTree {
    static Node root;
    static class Node {
        int item;
        Node left;
        Node right;
        Node(int data) {
            this.item = data;
            left = null;
            right = null;
        }
    }

    public binarySearchTree() {
        root = null;
    }

    public static void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.item + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }
    public static void insert(int T, Node x) {
        if (x == null) {
            root = new Node(T);
            return;
        }
        if (x.item > T) {
            if (x.left == null) {
                x.left = new Node(T);
            } else {
                insert(T, x.left);
            }
        } else {
            if (x.right == null) {
                x.right = new Node(T);
            } else {
                insert(T, x.right);
            }
        }
    }
    public static int min(Node x) {
        if (x.left == null) {
            return x.item;
        }
        return min(x.left);
    }

    public static Node extractMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = extractMin(x.left);
        return x;
    }

   public static void main(String[] args) {
        insert(25, root);
        insert(20, root);
        insert(22, root);
        insert(15, root);
        insert(10, root);
        insert(16, root);
        insert(30, root);
        insert(35, root);
        insert(27, root);
        insert(28, root);
        insert(26, root);
        insert(40, root);
        System.out.println("Tree: ");
        levelOrder();
        System.out.print("\n");
        System.out.println("Minimum :" + min(root));
        System.out.println("Tree after extracting minimum: ");
        extractMin(root);
        levelOrder();


    }
}
