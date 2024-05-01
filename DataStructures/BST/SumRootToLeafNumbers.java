package DataStructures.BST;

import java.util.Scanner;

public class SumRootToLeafNumbers {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node root;
    private static int result = 0;

    public Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (root.left == null)
            root.left = insert(root.left, data);
        else if (root.right == null)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);

        return root;
    }

    public void display(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }

    public int sumNumbers(Node root) {
        if (root == null)
            return 0;

        sumNumbersHelper(root, 0);
        return result;
    }

    public void sumNumbersHelper(Node root, int sum) {
        if (root == null)
            return;

        sum = (sum * 10) + root.data;

        if (root.left == null && root.right == null)
            result += sum;

        sumNumbersHelper(root.left, sum);
        sumNumbersHelper(root.right, sum);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        SumRootToLeafNumbers bt = new SumRootToLeafNumbers();
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            root = bt.insert(root, data);
        }

        bt.display(root);

        System.out.print("\nSum Root To Leaf Numbers : " + bt.sumNumbers(root));
        sc.close();
    }
}
