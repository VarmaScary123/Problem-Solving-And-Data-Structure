package DataStructures.BST;

import java.util.*;

public class InsertInBST {

    class Node {
        Node left;
        int data;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static Node root = null;

    public Node insert(Node node, int data) {
        if(node == null) return new Node(data);

        if(data < node.data) node.left = insert(node.left, data);
        else if(data > node.data) node.right = insert(node.right, data);

        return node;
    }

    public void display(Node root) {
        if(root == null) return;

        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        InsertInBST bst = new InsertInBST();
        for(int i=0;i<N;i++) {
            int data = sc.nextInt();
            root = bst.insert(root, data);
        }

        bst.display(root);
        sc.close();

    }
}
