package DataStructures.BST;

import java.util.Scanner;

public class PostOrderTraversal {
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
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);

        return node;
    }

    public void postOrderTraversal(Node root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PostOrderTraversal po = new PostOrderTraversal();
        for (int i = 0; i < N; i++)
            root = po.insert(root, sc.nextInt());

        po.postOrderTraversal(root);
        sc.close();
    }
}
