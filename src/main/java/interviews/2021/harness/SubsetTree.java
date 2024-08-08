package interviews.harness;

import algorithms.trees.TreeNode;

public class SubsetTree {
    /*Problem Statement: there are 2 trees T1 & T2, T1 is very very big and T2 is very small.
    Return true if T2 exists in T1 otherwise false.
    */

    //time complexity: O(N * M)
    //space complexity: O(height(bigger tree)) = O(logN)
    public boolean doesT2ExistInT1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;

        return t1.val == t2.val && doesT2ExistInT1(t1.left, t2.left) && doesT2ExistInT1(t1.right, t2.right)
                || doesT2ExistInT1(t1.left, t2) || doesT2ExistInT1(t1.right, t2);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.left.right.left = new TreeNode(6);
        t1.left.right.right = new TreeNode(7);

        t1.right = new TreeNode(3);
        t1.right.right = new TreeNode(8);
        t1.right.right.left = new TreeNode(9);
        t1.right.right.right = new TreeNode(10);

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(6);
        t2.right = new TreeNode(7);

        SubsetTree st = new SubsetTree();
        System.out.println(st.doesT2ExistInT1(t1, t2));

        t2.left.left = new TreeNode(12);
        System.out.println(st.doesT2ExistInT1(t1, t2));

        System.out.println(st.doesT2ExistInT1(t1, new TreeNode(1)));
    }
}
