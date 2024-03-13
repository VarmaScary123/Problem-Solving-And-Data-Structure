package DataStructures.BST;

import java.util.Scanner;

public class RightView {
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

    public void rightView() {
        rightView(root, 1);
    }

    int maxLevel = 0;

    public void rightView(Node root, int level) {
        if (root == null)
            return;

        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }

        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        RightView rv = new RightView();

        for (int i = 0; i < N; i++)
            root = rv.insert(root, sc.nextInt());

        sc.close();

        rv.display(root);
        System.out.print("\nRight View : ");
        rv.rightView();
    }
}
