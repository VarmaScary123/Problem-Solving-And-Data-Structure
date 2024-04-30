/*
    Given the root of a binary tree, return the sum of all left leaves.

    A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

    Example 1:

    Input: root = [3,9,20,null,null,15,7]
    Output: 24
    Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
    Example 2:

    Input: root = [1]
    Output: 0
    

    Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    -1000 <= Node.val <= 1000
 */

package DataStructures.BST;

import java.util.Scanner;

public class SumOfLeftLeaves {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private static Node root;

    public Node insert(Node root, int data) {
        if(root == null) return new Node(data);

        if(data < root.data) root.left = insert(root.left, data);
        else if(data > root.data) root.right = insert(root.right, data);

        return root;
    }

    public void display(Node root) {
        if(root == null) return;

        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }

    int sum;
    public int sumOfLeftLeaves(Node root) {
        if(root == null) return 0;

        sumOfLeftLeavesHelper(root, false);
        return sum;
    }

    public void sumOfLeftLeavesHelper(Node root, boolean isLeft) {
        if(root == null) return;

        if(root.left == null && root.right == null && isLeft) {
            sum += root.data;
            return;
        }

        sumOfLeftLeavesHelper(root.left, true);
        sumOfLeftLeavesHelper(root.right, false);
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        SumOfLeftLeaves bst = new SumOfLeftLeaves();
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            root = bst.insert(root, data);
        }

        bst.display(root);

        System.out.println("\nSum of Left Leaves : "+bst.sumOfLeftLeaves(root));
        sc.close();

    }
}
