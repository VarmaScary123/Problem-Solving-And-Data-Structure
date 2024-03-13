package DataStructures.BST;

import java.util.Scanner;

public class PreOrderTraversal {
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

    public Node insert(Node node, int data){
        if(node == null) return new Node(data);

        if(data < root.data) node.left = insert(node.left, data);
        else if(data > root.data) node.right = insert(node.right, data);

        return node;
    }

    public void preOrderTraversal(Node root) {
        if(root == null) return;

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PreOrderTraversal po = new PreOrderTraversal();
        for(int i=0;i<N;i++)
            root = po.insert(root, sc.nextInt());
        
        po.preOrderTraversal(root);
        sc.close();
    }
}
