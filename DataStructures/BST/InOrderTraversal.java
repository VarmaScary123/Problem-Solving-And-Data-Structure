package DataStructures.BST;

import java.util.Scanner;

public class InOrderTraversal {
    class Node {
        Node left;
        int data;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static Node root;

    public Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);

        return node;
    }

    public void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        InOrderTraversal io = new InOrderTraversal();
        for (int i = 0; i < N; i++)
            root = io.insert(root, sc.nextInt());

        io.inOrderTraversal(root);

        sc.close();
    }
}
