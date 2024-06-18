package gfg.interviews.harness;

public class SubsetTree {
    /*Problem Statement: there are 2 trees T1 & T2, T1 is very very big and T2 is very small.
    Return true if T2 exists in T1 otherwise false.
    */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //time complexity: O(N * M)
    //space complexity: O(height(bigger tree)) = O(logN)
    private boolean dfs(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        return dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }

    //root1 is the root of the bigger tree and root2 is smaller
    private boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root1 == null)
            return false;
        return dfs(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }


    public static void main(String[] args) {

    }
}
