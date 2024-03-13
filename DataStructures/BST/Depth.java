package DataStructures.BST;

import java.util.Scanner;

public class Depth {
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

    public int getDepth(int val) {
        return depthOfNode(root, val, 0);
    }

    public int depthOfNode(Node root, int val, int depth) {
        if(root == null) return -1;
        if(val == root.data) return depth;
        else if(val < root.data) return depthOfNode(root.left, val, depth + 1);
        else return depthOfNode(root.right, val, depth + 1);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Depth d = new Depth();
        for(int i=0;i<N;i++)
            root = d.insert(root, sc.nextInt());
            
        sc.close();
        d.display(root);
        int val = sc.nextInt();

        System.out.println("Depth of " + val + " : " + d.getDepth(val));
    }
}
