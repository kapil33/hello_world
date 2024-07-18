package interviews.harness;

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

    static int result;

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static void secondMinimumNumber(TreeNode root){
        if (root == null || root.left == null || root.right == null
                || (root.val == root.left.val && root.val == root.right.val))
            return;
        if (root.val == root.left.val){
            if (result == -1 || result > root.right.val)
                result = root.right.val;
            secondMinimumNumber(root.left);
        }else{
            if (result == -1 || result > root.left.val)
                result = root.left.val;
            secondMinimumNumber(root.right);
        }
    }

    public static void main(String[] args) {
        result = -1;
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(6);*/
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        secondMinimumNumber(root);*/
        secondMinimumNumber(root);
        System.out.println("Result is: " + result);
    }
}
