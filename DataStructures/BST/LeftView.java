package DataStructures.BST;

import java.util.Scanner;

public class LeftView {
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
        if(node ==  null) return new Node(data);

        if(data < node.data) node.left = insert(node.left, data);
        else if(data > node.data) node.right = insert(node.right, data);

        return node;
    }

    public void display(Node root) {
        if(root == null) return;

        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }

    public void leftView() {
        leftView(root, 1);
    }

    int maxLevel = 0;
    public void leftView(Node root, int level) {
        if(root == null) return;

        if(maxLevel < level) {
            System.out.print(root.data+" ");
            maxLevel = level;
        }

        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LeftView lv = new LeftView();
        
        for(int i=0;i<N;i++)
            root = lv.insert(root, sc.nextInt());

        lv.display(root);

        System.out.print("\nLeft View ->");
        lv.leftView();
        sc.close();
    }
}
