package DataStructures.BST;

import java.util.Scanner;

public class HeightOfBST {
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

        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }

    public int getHeight() {
        return height(root);
    }

    public int height(Node root) {
        if(root == null) return 0;
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HeightOfBST h = new HeightOfBST();

        for(int i=0;i<N;i++)
            root = h.insert(root, sc.nextInt());

        sc.close();
        h.display(root);

        int height = h.getHeight();

        System.out.println("\nHeight of the tree : " + height);
    }
}
