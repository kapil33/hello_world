package interviews.twentytwentyone.harness;

import algorithms.trees.TreeNode;

public class SecondMinimumNumber {
    /*Problem Statement: given a tree which has below properties:
    * 1. every node = min(left child, right child)
    * 2. every node has max of 2 children
    *
    * Example 1:
    *           3
    *         3   5
    *       3  4 6  5
    * Answer: 4
    *
    * Example 2:
     *           3
     *         3   5
     *       3  6 6  5
     * Answer: 5
     *
     * Example 3:
     *           1
     *         1   1
     * Answer: -1
    * */

    static int secondMinimumNumber;

    public SecondMinimumNumber() {
        secondMinimumNumber = Integer.MAX_VALUE;
    }

    private void getSecondMinimumNumber(TreeNode root){
        if (root == null || root.left == null || root.right == null
                || (root.val == root.left.val && root.val == root.right.val))
            return;
        if (root.val == root.left.val){
            if (secondMinimumNumber > root.right.val)
                secondMinimumNumber= root.right.val;
            getSecondMinimumNumber(root.left);
        }else{
            if (secondMinimumNumber > root.left.val)
                secondMinimumNumber= root.left.val;
            getSecondMinimumNumber(root.right);
        }
    }

    @Override
    public String toString() {
        if (secondMinimumNumber == Integer.MAX_VALUE)
            return "Result is: " + -1;
        else
            return "Result is: " + secondMinimumNumber;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        SecondMinimumNumber smn = new SecondMinimumNumber();
        smn.getSecondMinimumNumber(root);
        System.out.println(smn);

        root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        smn = new SecondMinimumNumber();
        smn.getSecondMinimumNumber(root);
        System.out.println(smn);

        root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        smn = new SecondMinimumNumber();
        smn.getSecondMinimumNumber(root);
        System.out.println(smn);
    }
}
