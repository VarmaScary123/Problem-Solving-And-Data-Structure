/*
    You are given the root of a binary tree containing digits from 0 to 9 only.

    Each root-to-leaf path in the tree represents a number.

    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
    Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

    A leaf node is a node with no children.

    

    Example 1:

    Input: root = [1,2,3]
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.

    Example 2:

    Input: root = [4,9,0,5,1]
    Output: 1026
    Explanation:
    The root-to-leaf path 4->9->5 represents the number 495.
    The root-to-leaf path 4->9->1 represents the number 491.
    The root-to-leaf path 4->0 represents the number 40.
    Therefore, sum = 495 + 491 + 40 = 1026.
    

    Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 9
    The depth of the tree will not exceed 10.
 */

 // It is a Binary Tree Not a Binary Search Tree
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
