package DataStructures.BST;

import java.util.Scanner;

public class ValidBST {
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

    public void display(Node root) {
        if (root == null)
            return;

        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }

    public boolean isValidBST(Node root) {
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data < min || root.data > max)
            return false;

        return validBST(root.left, min, root.data) && validBST(root.right, root.data, max);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ValidBST va = new ValidBST();

        for (int i = 0; i < N; i++)
            root = va.insert(root, sc.nextInt());

        sc.close();

        va.display(root);

        if (va.isValidBST(root))
            System.out.println("Valid BST");
        else
            System.out.println("Not a Valid BST");
    }
}